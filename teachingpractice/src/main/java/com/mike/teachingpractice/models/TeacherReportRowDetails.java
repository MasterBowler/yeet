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

    //delete this and retrieve from student details?
    @Column(name = "year_of_study", nullable = false)
    private int yearOfStudy;

    //do I need student id?

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    @Column(name = "teaching_activity_type", nullable = false)
    private TeachingActivityType teachingActivityType; // should I allow more than one type?
}
