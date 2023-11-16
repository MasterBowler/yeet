package com.mike.teachingpractice.models;


import jakarta.persistence.*;

@Entity
@Table(name = "chat_memberships")
public class ChatMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
