package com.mike.teachingpractice.dtos;

public class RegistrationDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public RegistrationDTO() {
        super();
    }

    public RegistrationDTO(String username, String firstName, String lastName, String password) {
        super();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Registration info: username: " + this.username + " password: " + this.password;
    }
}
