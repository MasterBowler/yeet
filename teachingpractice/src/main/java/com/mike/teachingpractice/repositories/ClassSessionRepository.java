package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.ClassSession;
import com.mike.teachingpractice.models.Group;
import com.mike.teachingpractice.models.User;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClassSessionRepository extends JpaRepository<ClassSession, Integer> {

    Set<ClassSession> findAllByGroupAndTeacher(Group group, User user);

    Set<ClassSession> findAllByGroup(Group group);

    @Query(value = "SELECT * FROM class_session cs WHERE cs.group_id = :groupId AND TIMESTAMP(cs.date, cs.start_time) > CURRENT_TIMESTAMP", nativeQuery = true)
    Set<ClassSession> findAllFutureSessionsByGroup(@Param("groupId") Integer groupId);
}
