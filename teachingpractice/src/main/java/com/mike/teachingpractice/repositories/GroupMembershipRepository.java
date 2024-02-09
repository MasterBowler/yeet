package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.Group;
import com.mike.teachingpractice.models.GroupMembership;
import com.mike.teachingpractice.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMembershipRepository extends JpaRepository<GroupMembership, Integer> {

    Optional<GroupMembership> findByGroup(Group group);

    Optional<GroupMembership> findByStudent(User student);

    boolean existsByStudent(User student);

    boolean existsByGroup(Group group);
}
