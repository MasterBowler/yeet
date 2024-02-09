package com.mike.teachingpractice.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_message_id", nullable = false, unique = true)
    private Integer chatMessageId;

    @Column(name = "senderId", nullable = false)
    private String senderId;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @Column(name = "message_content", nullable = false)
    private String messageContent;

    @Column(name = "timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public Integer getChatMessageId() {
        return chatMessageId;
    }

    public void setChatMessageId(Integer chatMessageId) {
        this.chatMessageId = chatMessageId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chatId) {
        this.chat = chatId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String message) {
        this.messageContent = message;
    }

    public Date getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timestamp = timeStamp;
    }
}
