package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.ClassSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassSessionRepository extends JpaRepository<ClassSession, Long> {
}
