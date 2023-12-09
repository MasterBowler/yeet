package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.ChatMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMembershipRepository extends JpaRepository<ChatMembership, Long> {
}
