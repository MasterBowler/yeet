package com.mike.teachingpractice.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.mike.teachingpractice.models.Chat;
import com.mike.teachingpractice.models.ChatMembership;
import com.mike.teachingpractice.models.User;
import com.mike.teachingpractice.repositories.ChatMembershipRepository;
import com.mike.teachingpractice.repositories.ChatRepository;
import com.mike.teachingpractice.repositories.UserRepository;

@Service
public class ChatService {

    @Autowired
    private ChatMembershipRepository chatMembershipRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    UserRepository userRepository;

    public boolean isUserInChat(Integer chatId, String userId) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new IllegalArgumentException("Chat not found"));
        User user = userRepository.findByUsername(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return chatMembershipRepository.existsByChatAndUser(chat, user);
    }

    public Chat getChatBetweenUsers(User user1, User user2) {
        return chatRepository.findPrivateChatBetweenUsers(user1, user2)
                .orElseGet(() -> createNewPrivateChat(user1, user2));
    }

    private Chat createNewPrivateChat(User user1, User user2) {
        Chat newChat = new Chat();
        newChat.setIsGroupChat(false);
        chatRepository.save(newChat);

        ChatMembership membership1 = new ChatMembership();
        membership1.setChat(newChat);
        membership1.setUser(user1);
        chatMembershipRepository.save(membership1);

        ChatMembership membership2 = new ChatMembership();
        membership2.setChat(newChat);
        membership2.setUser(user2);
        chatMembershipRepository.save(membership2);
        return newChat;
    }

    public Chat createNewGroupChat(User creator) {
        Collection<? extends GrantedAuthority> authorities = creator.getAuthorities();
        boolean hasPermission = authorities.stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN") || a.getAuthority().equals("TEACHER"));

        if (!hasPermission) {
            throw new AccessDeniedException("User does not have permission to create a group chat");
        }

        Chat newChat = new Chat();
        newChat.setIsGroupChat(true);
        chatRepository.save(newChat);

        ChatMembership membership = new ChatMembership();
        membership.setChat(newChat);
        membership.setUser(creator);
        chatMembershipRepository.save(membership);

        return newChat;
    }

    public ChatMembership addUserToGroupChat(User admin, User userToAdd, Chat chat) {
        Collection<? extends GrantedAuthority> authorities = admin.getAuthorities();
        boolean hasPermission = authorities.stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN") || a.getAuthority().equals("TEACHER"));

        if (!hasPermission) {
            throw new AccessDeniedException("User does not have permission to add a user to a group chat");
        }

        if (!chat.getIsGroupChat()) {
            throw new IllegalArgumentException("Chat is not a group chat");
        }

        ChatMembership membership = new ChatMembership();
        membership.setChat(chat);
        membership.setUser(userToAdd);
        chatMembershipRepository.save(membership);

        return membership;
    }
}
