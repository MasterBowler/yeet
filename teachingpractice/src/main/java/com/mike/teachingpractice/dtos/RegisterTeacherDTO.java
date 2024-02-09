package com.mike.teachingpractice.dtos;

public class RegisterTeacherDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String highschool;
    private String subject;
    private Integer experience;
    private String teachingDegree;

    // Constructors
    public RegisterTeacherDTO() {
    }

    public RegisterTeacherDTO(String firstName, String lastName, String email, String password, String phoneNumber,
            String highschool, String subject, Integer experience, String teachingDegree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.highschool = highschool;
        this.subject = subject;
        this.experience = experience;
        this.teachingDegree = teachingDegree;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHighschool(String highschool) {
        this.highschool = highschool;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setTeachingDegree(String teachingDegree) {
        this.teachingDegree = teachingDegree;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHighschool() {
        return highschool;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getExperience() {
        return experience;
    }

    public String getTeachingDegree() {
        return teachingDegree;
    }
}