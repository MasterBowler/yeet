package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
