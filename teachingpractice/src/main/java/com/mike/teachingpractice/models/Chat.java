package com.mike.teachingpractice.models;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id", nullable = false, unique = true)
    private Integer chatId;

    @Column(name = "is_group_chat", nullable = false)
    private Boolean isGroupChat;

    @OneToMany(mappedBy = "chat")
    private Set<ChatMessage> messages;

    @OneToMany(mappedBy = "chat")
    private Set<ChatMembership> memberships;

    public Chat(Integer chatId) {
        this.chatId = chatId;
    }

    public Chat() {
    }

    public Set<User> getUsers() {
        return this.memberships.stream()
                .map(ChatMembership::getUser)
                .collect(Collectors.toSet());
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Boolean getIsGroupChat() {
        return isGroupChat;
    }

    public void setIsGroupChat(Boolean isGroupChat) {
        this.isGroupChat = isGroupChat;
    }

    public Set<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(Set<ChatMessage> messages) {
        this.messages = messages;
    }

    public Set<ChatMembership> getMemberships() {
        return memberships;
    }

    public void setMemberships(Set<ChatMembership> memberships) {
        this.memberships = memberships;
    }
}
