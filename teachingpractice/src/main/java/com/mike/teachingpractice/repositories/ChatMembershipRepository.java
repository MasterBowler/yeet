package com.mike.teachingpractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mike.teachingpractice.models.Chat;
import com.mike.teachingpractice.models.ChatMembership;
import com.mike.teachingpractice.models.User;

@Repository
public interface ChatMembershipRepository extends JpaRepository<ChatMembership, Integer> {

    // @Query("SELECT CASE WHEN COUNT(cm) > 0 THEN true ELSE false END FROM
    // chat_memberships cm WHERE cm.chat_id = :chatId AND cm.user_id = :userId")
    // boolean existsByChatAndUser(Integer chatId, Integer userId);
    boolean existsByChatAndUser(Chat chat, User user);
}
