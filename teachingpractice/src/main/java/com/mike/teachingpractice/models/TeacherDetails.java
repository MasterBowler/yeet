package com.mike.teachingpractice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher_details")
public class TeacherDetails {
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

    public TeacherDetails() {
    }

    public TeacherDetails(long teacherId, String highschool, String subject, int experience, String teachingDegree) {
        this.teacherId = teacherId;
        this.highschool = highschool;
        this.subject = subject;
        this.experience = experience;
        this.teachingDegree = teachingDegree;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getHighschool() {
        return highschool;
    }

    public void setHighschool(String highschool) {
        this.highschool = highschool;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getTeachingDegree() {
        return teachingDegree;
    }

    public void setTeachingDegree(String teachingDegree) {
        this.teachingDegree = teachingDegree;
    }
}