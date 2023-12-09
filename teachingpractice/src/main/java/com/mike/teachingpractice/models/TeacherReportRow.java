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

    @OneToMany(mappedBy = "teacherReportRow", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TeacherReportRowDetails> details;

    public TeacherReportRow() {
    }

    public TeacherReportRow(TeacherReport teacherReport, int criterionNumber, User student,
            List<TeacherReportRowDetails> details) {
        this.teacherReport = teacherReport;
        this.criterionNumber = criterionNumber;
        this.student = student;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeacherReport getTeacherReport() {
        return teacherReport;
    }

    public void setTeacherReport(TeacherReport teacherReport) {
        this.teacherReport = teacherReport;
    }

    public int getCriterionNumber() {
        return criterionNumber;
    }

    public void setCriterionNumber(int criterionNumber) {
        this.criterionNumber = criterionNumber;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public List<TeacherReportRowDetails> getDetails() {
        return details;
    }

    public void setDetails(List<TeacherReportRowDetails> details) {
        this.details = details;
    }
}
