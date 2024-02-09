package com.mike.teachingpractice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "student_details")
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // @Column(name = "student_id")
    @OneToOne
    private User student;

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

    @Column(name = "location")
    private String location;

    @Column(name = "address")
    private String address;

    @Column(name = "transport")
    private String transport;

    // Constructors
    public StudentDetails() {
    }

    public StudentDetails(User student, String university, String faculty, String specialty, int yearOfStudy,
            String group, String location, String address, String transport) {
        this.student = student;
        this.university = university;
        this.faculty = faculty;
        this.specialty = specialty;
        this.yearOfStudy = yearOfStudy;
        this.group = group;
        this.location = location;
        this.address = address;
        this.transport = transport;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }
}
