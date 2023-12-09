package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.StudentReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentReportRepository extends JpaRepository<StudentReport, Long> {
}
