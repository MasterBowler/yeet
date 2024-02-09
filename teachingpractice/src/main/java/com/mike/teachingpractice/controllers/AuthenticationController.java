package com.mike.teachingpractice.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mike.teachingpractice.models.User;
import com.mike.teachingpractice.services.AuthenticationService;
import com.mike.teachingpractice.services.UserService;

import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;

import com.mike.teachingpractice.dtos.LoginRequestDTO;
import com.mike.teachingpractice.dtos.LoginResponseDTO;
import com.mike.teachingpractice.dtos.RegisterStudentDTO;
import com.mike.teachingpractice.dtos.RegisterTeacherDTO;
import com.mike.teachingpractice.dtos.RegistrationDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
// CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    // @PostMapping("/register")
    // public String registerUser(@RequestBody RegistrationDTO body) {
    // authenticationService.registerUser(body.getUsername(), body.getFirstName(),
    // body.getLastName(),
    // body.getPassword());
    // return "User registered";
    // }

    // register teacher
    @PostMapping("/register/teacher")
    public String postMethodName(@RequestBody RegisterTeacherDTO registerTeacherDTO) {
        User user = authenticationService.registerTeacher(registerTeacherDTO.getFirstName(),
                registerTeacherDTO.getLastName(),
                registerTeacherDTO.getEmail(), registerTeacherDTO.getPassword(), registerTeacherDTO.getPhoneNumber(),
                registerTeacherDTO.getHighschool(), registerTeacherDTO.getSubject(),
                registerTeacherDTO.getExperience().intValue(),
                registerTeacherDTO.getTeachingDegree());

        return user.getUsername();
    }

    // register student
    @PostMapping("register/student")
    public String postMethodName(@RequestBody RegisterStudentDTO registerStudentDTO) {
        User user = authenticationService.registerStudent(registerStudentDTO.getFirstName(),
                registerStudentDTO.getLastName(), registerStudentDTO.getEmail(), registerStudentDTO.getPassword(),
                registerStudentDTO.getPhoneNumber(), registerStudentDTO.getUniversity(),
                registerStudentDTO.getFaculty(), registerStudentDTO.getSpecialty(), registerStudentDTO.getYearOfStudy(),
                registerStudentDTO.getGroup(), registerStudentDTO.getLocation(), registerStudentDTO.getAddress(),
                registerStudentDTO.getTransport());

        return user.getUsername();
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody LoginRequestDTO body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}