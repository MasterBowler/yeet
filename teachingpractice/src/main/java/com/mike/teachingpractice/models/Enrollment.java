package com.mike.teachingpractice.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private ClassSession session;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @Column(name = "enrollment_date", nullable = false)
    private LocalDateTime enrollmentDate;

    //how would I able to tell how many students are registered in one class?
    //how would I able to tell how many classes a student is registered in?
    //how can I tell what students are registered in a class?
}
