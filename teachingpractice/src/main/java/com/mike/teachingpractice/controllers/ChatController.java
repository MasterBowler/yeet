package com.mike.teachingpractice.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import com.mike.teachingpractice.models.Chat;
import com.mike.teachingpractice.models.ChatMembership;
import com.mike.teachingpractice.models.ChatMessage;
import com.mike.teachingpractice.models.User;
import com.mike.teachingpractice.repositories.ChatMessageRepository;
import com.mike.teachingpractice.repositories.ChatRepository;
import com.mike.teachingpractice.repositories.UserRepository;
import com.mike.teachingpractice.services.ChatService;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    // Handle creating a new group chat by ADMIN or TEACHER
    @MessageMapping("/chat/group/create")
    public ResponseEntity<Integer> createGroupChat(Principal principal) {
        User creator = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Integer chatId = chatService.createNewGroupChat(creator).getChatId();
        return ResponseEntity.ok(chatId);
    }

    // Handle adding a user to a group chat by ADMIN or TEACHER
    @MessageMapping("/chat/group/addUser")
    public ResponseEntity<ChatMembership> addUserToGroupChat(Principal admin, String userToAddUsername,
            Integer chatId) {
        User adminUser = userRepository.findByUsername(admin.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        User userToAdd = userRepository.findByUsername(userToAddUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new NoSuchElementException("Chat not found"));

        ChatMembership membership = chatService.addUserToGroupChat(adminUser, userToAdd, chat);

        return ResponseEntity.ok(membership);
    }

    // Handle sending messages to a chat room
    @MessageMapping("/chat/{chatId}")
    // @SendTo("/topic/chat/{chatId}")
    public void sendGroupMessage(@DestinationVariable Integer chatId, ChatMessage message, Principal principal) {
        String senderId = principal.getName();
        if (!chatService.isUserInChat(chatId, senderId)) {
            throw new AccessDeniedException("User not a member of the chat");
        }

        message.setSenderId(senderId);
        message.setChat(new Chat(chatId));
        message.setTimeStamp(new Date());
        chatMessageRepository.save(message);

        // Broadcast the message to all members of the chat room
        messagingTemplate.convertAndSend("/topic/chat/" + chatId, message);
    }

    // Handle sending private messages
    @MessageMapping("/chat/private/{receiverId}")
    public void sendPrivateMessage(@DestinationVariable String receiverId, ChatMessage message, Principal principal) {
        String senderId = principal.getName();
        message.setSenderId(senderId);
        message.setChat(chatService.getChatBetweenUsers(userRepository.findByUsername(senderId).get(),
                userRepository.findByUsername(receiverId).get()));
        message.setTimeStamp(new Date());
        ChatMessage savedMessage = chatMessageRepository.save(message);
        messagingTemplate.convertAndSendToUser(receiverId, "/queue/messages", savedMessage);
    }

    // get all chats for user

    // remove user from chat by Admin or Teacher

    // create group chat by Admin or Teacher

    // create private chat

    // add user to group chat by Admin or Teacher

    // delete chat

    // get chat messages

    // get chat members
}
