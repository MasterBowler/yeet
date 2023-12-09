package com.mike.teachingpractice.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "teacher_report_row_details")
public class TeacherReportRowDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_report_row_id", nullable = false)
    private TeacherReportRow teacherReportRow;

    @ManyToOne
    @JoinColumn(name = "student_details", nullable = false)
    private StudentDetails studentDetails;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Column(name = "assitance", nullable = true)
    private boolean assitance;

    @Column(name = "teaching_project", nullable = true)
    private boolean teachingProject;

    @Column(name = "portfolio", nullable = true)
    private boolean portfolio;

    @Column(name = "workshop", nullable = true)
    private boolean workshop;

    @Column(name = "extracurriculars", nullable = true)
    private boolean extracurriculars;

    public TeacherReportRowDetails() {
    }

    public TeacherReportRowDetails(TeacherReportRow teacherReportRow, StudentDetails studentDetails, LocalDate date,
            LocalTime time, boolean assitance, boolean teachingProject, boolean portfolio, boolean workshop,
            boolean extracurriculars) {
        this.teacherReportRow = teacherReportRow;
        this.studentDetails = studentDetails;
        this.date = date;
        this.time = time;
        this.assitance = assitance;
        this.teachingProject = teachingProject;
        this.portfolio = portfolio;
        this.workshop = workshop;
        this.extracurriculars = extracurriculars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeacherReportRow getTeacherReportRow() {
        return teacherReportRow;
    }

    public void setTeacherReportRow(TeacherReportRow teacherReportRow) {
        this.teacherReportRow = teacherReportRow;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public boolean isAssitance() {
        return assitance;
    }

    public void setAssitance(boolean assitance) {
        this.assitance = assitance;
    }

    public boolean isTeachingProject() {
        return teachingProject;
    }

    public void setTeachingProject(boolean teachingProject) {
        this.teachingProject = teachingProject;
    }

    public boolean isPortfolio() {
        return portfolio;
    }

    public void setPortfolio(boolean portfolio) {
        this.portfolio = portfolio;
    }

    public boolean isWorkshop() {
        return workshop;
    }

    public void setWorkshop(boolean workshop) {
        this.workshop = workshop;
    }

    public boolean isExtracurriculars() {
        return extracurriculars;
    }

    public void setExtracurriculars(boolean extracurriculars) {
        this.extracurriculars = extracurriculars;
    }

    public int getYearOfStudy() {
        return this.studentDetails.getYearOfStudy();
    }
}
