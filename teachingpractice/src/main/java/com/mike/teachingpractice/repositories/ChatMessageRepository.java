package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
