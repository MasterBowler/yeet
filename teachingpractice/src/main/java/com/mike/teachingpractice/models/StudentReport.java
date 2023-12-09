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
    @JoinColumn(name = "student_details_id", nullable = false)
    private StudentDetails studentDetails;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "studentReport")
    private List<StudentReportRow> studentReportRows;

    public StudentReport() {
    }

    public StudentReport(ClassSession classSession, StudentDetails studentDetails, LocalDateTime createdAt) {
        this.classSession = classSession;
        this.studentDetails = studentDetails;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassSession getClassSession() {
        return classSession;
    }

    public void setClassSession(ClassSession classSession) {
        this.classSession = classSession;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<StudentReportRow> getStudentReportRows() {
        return studentReportRows;
    }

    public void setStudentReportRows(List<StudentReportRow> studentReportRows) {
        this.studentReportRows = studentReportRows;
    }
}
