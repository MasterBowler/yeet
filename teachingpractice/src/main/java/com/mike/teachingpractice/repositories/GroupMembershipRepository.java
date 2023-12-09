package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.GroupMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMembershipRepository extends JpaRepository<GroupMembership, Long> {
}
