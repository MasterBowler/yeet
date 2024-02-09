package com.mike.teachingpractice.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // @Column(name = "session_id")
    @ManyToOne
    @JoinColumn(name = "session_id")
    private ClassSession session;

    // @Column(name = "student_id", nullable = false)
    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    @Column(name = "enrollment_date")
    private LocalDateTime enrollmentDate;

    @Column(name = "assitance")
    private boolean assitance;

    @Column(name = "teaching_project")
    private boolean teachingProject;

    @Column(name = "portfolio")
    private boolean portfolio;

    @Column(name = "workshop")
    private boolean workshop;

    @Column(name = "extracurriculars")
    private boolean extracurriculars;

    public Enrollment() {
    }

    public Enrollment(ClassSession session, User student, LocalDateTime enrollmentDate) {
        this.session = session;
        this.student = student;
        this.enrollmentDate = enrollmentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClassSession getSession() {
        return session;
    }

    public void setSession(ClassSession session) {
        this.session = session;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
