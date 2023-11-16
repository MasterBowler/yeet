package com.mike.teachingpractice.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "student_reports")
public class StudentReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private ClassSession classSession;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    //link to student details somehow

    @OneToMany(mappedBy = "studentReport")
    private List<StudentReportRow> studentReportRow;
}
