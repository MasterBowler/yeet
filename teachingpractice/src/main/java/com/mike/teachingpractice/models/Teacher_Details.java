package com.mike.teachingpractice.models;


import jakarta.persistence.*;

@Entity
@Table(name = "teacher_details")
public class Teacher_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "teacher_id")
    private long teacherId;

    @Column(name = "highschool")
    private String highschool;

    @Column(name = "subject")
    private String subject;

    @Column(name = "experience")
    private int experience;

    @Column(name = "teaching_degree")
    private String teachingDegree;
}
