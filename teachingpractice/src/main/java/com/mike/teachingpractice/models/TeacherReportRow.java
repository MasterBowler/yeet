package com.mike.teachingpractice.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teacher_report_rows")
public class TeacherReportRow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_report_id", nullable = false)
    private TeacherReport teacherReport;

    @Column(name = "criterion_number", nullable = false)
    private int criterionNumber;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @OneToMany(mappedBy = "teacherReportRow")
    private List<TeacherReportRowDetails> details;
}
