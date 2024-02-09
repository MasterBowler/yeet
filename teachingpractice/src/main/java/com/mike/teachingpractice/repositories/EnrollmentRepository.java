package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.ClassSession;
import com.mike.teachingpractice.models.Enrollment;
import com.mike.teachingpractice.models.User;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    @Query("SELECT e.session FROM Enrollment e WHERE e.student = :student")
    Set<ClassSession> findAllByStudent(@Param("student") User student);

    Optional<Enrollment> findBySessionAndStudent(ClassSession classSession, User student);
}
