package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Integer> {
}
