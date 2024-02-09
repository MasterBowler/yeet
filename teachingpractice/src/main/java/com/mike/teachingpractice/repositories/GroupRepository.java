package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.Group;
import com.mike.teachingpractice.models.User;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    Set<Group> findAllByTeacher(User teacher);
}
