package com.mike.teachingpractice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "student_details")
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "student_id")
    private long studentId;

    @Column(name = "university")
    private String university;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "year_of_study")
    private int yearOfStudy;

    @Column(name = "group")
    private String group;

    @Column(name =  "phone_number")
    private String phoneNumber;

    @Column(name = "location")
    private String location;

    @Column(name = "address")
    private String address;

    @Column(name = "transport")
    private String transport;

}
