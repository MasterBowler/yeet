package com.mike.teachingpractice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mike.teachingpractice.models.Chat;
import com.mike.teachingpractice.models.User;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {

    @Query("SELECT c FROM Chat c JOIN c.memberships m WHERE c.isGroupChat = false AND m.user IN (:user1, :user2) GROUP BY c HAVING COUNT(c) = 2")
    Optional<Chat> findPrivateChatBetweenUsers(@Param("user1") User user1, @Param("user2") User user2);
}
