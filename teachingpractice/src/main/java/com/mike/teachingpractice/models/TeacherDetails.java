package com.mike.teachingpractice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher_details")
public class TeacherDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User teacher;

    @Column(name = "highschool")
    private String highschool;

    @Column(name = "subject")
    private String subject;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "teaching_degree")
    private String teachingDegree;

    public TeacherDetails() {
    }

    public TeacherDetails(User teacher, String highschool, String subject, int experience, String teachingDegree) {
        this.teacher = teacher;
        this.highschool = highschool;
        this.subject = subject;
        this.experience = experience;
        this.teachingDegree = teachingDegree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacherId(User teacher) {
        this.teacher = teacher;
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