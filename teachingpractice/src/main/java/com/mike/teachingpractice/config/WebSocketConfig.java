package com.mike.teachingpractice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mike.teachingpractice.models.User;
import com.mike.teachingpractice.repositories.UserRepository;

import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
@Order(Ordered.HIGHEST_PRECEDENCE + 99)
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private JwtDecoder jwtDecoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // the client starts a new websockets communication at /ws
        registry.addEndpoint("/websocket").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // the client sends messages to /app
        registry.setApplicationDestinationPrefixes("/app");
        // the client subscribes to /topic and /user
        registry.enableSimpleBroker("/topic", "/queue");
        registry.setUserDestinationPrefix("/user");
    }

    // @Override
    // public boolean configureMessageConverters(List<MessageConverter>
    // messageConverters) {
    // DefaultContentTypeResolver resolver = new DefaultContentTypeResolver();
    // resolver.setDefaultMimeType(MimeTypeUtils.APPLICATION_JSON);
    // MappingJackson2MessageConverter converter = new
    // MappingJackson2MessageConverter();
    // converter.setObjectMapper(new ObjectMapper());
    // converter.setContentTypeResolver(resolver);
    // messageConverters.add(converter);
    // return false;
    // }

    // https://docs.spring.io/spring-framework/reference/web/websocket/stomp/authentication-token-based.html
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message,
                        StompHeaderAccessor.class);
                if (StompCommand.CONNECT.equals(accessor.getCommand())) {
                    String jwtToken = accessor.getFirstNativeHeader("Authorization");
                    if (jwtToken != null) {
                        Jwt jwt = jwtDecoder.decode(jwtToken);
                        String username = (String) jwt.getClaims().get("username");
                        User user = userRepository.findByUsername(username)
                                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
                        Authentication auth = new UsernamePasswordAuthenticationToken(user, null,
                                user.getAuthorities());
                        accessor.setUser(auth);
                        // SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }
                return message;
            }
        });
    }
}