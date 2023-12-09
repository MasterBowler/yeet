package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
