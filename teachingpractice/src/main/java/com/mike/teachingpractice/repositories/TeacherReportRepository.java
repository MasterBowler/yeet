package com.mike.teachingpractice.repositories;

import com.mike.teachingpractice.models.TeacherReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherReportRepository extends JpaRepository<TeacherReport, Long> {
}
