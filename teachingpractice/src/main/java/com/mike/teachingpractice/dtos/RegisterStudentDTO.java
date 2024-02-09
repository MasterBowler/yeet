package com.mike.teachingpractice.dtos;

public class RegisterStudentDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String university;
    private String faculty;
    private String specialty;
    private Integer yearOfStudy;
    private String group;
    private String phoneNumber;
    private String location;
    private String address;
    private String transport;

    // Constructors
    public RegisterStudentDTO() {
    }

    public RegisterStudentDTO(String firstName, String lastName, String email, String password, String university,
            String faculty, String specialty, Integer yearOfStudy, String group, String phoneNumber, String location,
            String address, String transport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.university = university;
        this.faculty = faculty;
        this.specialty = specialty;
        this.yearOfStudy = yearOfStudy;
        this.group = group;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.address = address;
        this.transport = transport;
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

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTransport(String transport) {
        this.transport = transport;
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

    public String getUniversity() {
        return university;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public String getGroup() {
        return group;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    public String getTransport() {
        return transport;
    }
}