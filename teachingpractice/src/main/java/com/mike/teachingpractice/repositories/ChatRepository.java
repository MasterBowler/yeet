package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
