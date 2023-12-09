package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.TeacherDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDetailsRepository extends JpaRepository<TeacherDetails, Long> {
}
