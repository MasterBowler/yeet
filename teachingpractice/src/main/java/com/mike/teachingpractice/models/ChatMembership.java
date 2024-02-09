package com.mike.teachingpractice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat_memberships")
public class ChatMembership {

    @Id
    @Column(name = "chat_membership_id", nullable = false, unique = true)
    private Integer chatMembershipId;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // setter and getter methods

    public Integer getChatMembershipId() {
        return chatMembershipId;
    }

    public void setChatMembershipId(Integer chatMembershipId) {
        this.chatMembershipId = chatMembershipId;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chatId) {
        this.chat = chatId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }
}
