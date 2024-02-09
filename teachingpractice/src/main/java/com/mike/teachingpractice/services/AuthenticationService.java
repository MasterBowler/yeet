package com.mike.teachingpractice.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mike.teachingpractice.dtos.LoginResponseDTO;
import com.mike.teachingpractice.models.Role;
import com.mike.teachingpractice.models.StudentDetails;
import com.mike.teachingpractice.models.TeacherDetails;
import com.mike.teachingpractice.models.User;
import com.mike.teachingpractice.repositories.RoleRepository;
import com.mike.teachingpractice.repositories.StudentDetailsRepository;
import com.mike.teachingpractice.repositories.TeacherDetailsRepository;
import com.mike.teachingpractice.repositories.UserRepository;

@Service
@Transactional
public class AuthenticationService {

    @Autowired // dependency injection
    private UserRepository userRepository;

    @Autowired
    private TeacherDetailsRepository teacherDetailsRepository;

    @Autowired
    private StudentDetailsRepository studentDetailsRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    // public User registerUser(String username, String firstName, String lastName,
    // String password) {

    // String encodedPassword = passwordEncoder.encode(password);
    // Role userRole = roleRepository.findByAuthority("USER").get();

    // Set<Role> authorities = new HashSet<>();

    // authorities.add(userRole);
    // return userRepository.save(new User(0, username, firstName, lastName,
    // encodedPassword, authorities));
    // }

    public User registerTeacher(String firstName, String lastName, String email, String password, String phoneNumber,
            String highschool, String subject, Integer experience, String teachingDegree) {
        String encodedPassword = passwordEncoder.encode(password);
        Role teacherRole = roleRepository.findByAuthority("TEACHER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(teacherRole);
        User user = userRepository
                .save(new User(0, email, firstName, lastName, encodedPassword, phoneNumber, authorities));
        user.setUsername(firstName + lastName + user.getUserId().toString());
        user = userRepository.save(user);
        TeacherDetails teacherDetails = new TeacherDetails(user, highschool, subject, experience, teachingDegree);
        teacherDetailsRepository.save(teacherDetails);
        return user;
    }

    public User registerStudent(String firstName, String lastName, String email, String password, String phoneNumber,
            String university, String faculty, String specialty, Integer yearOfStudy, String group, String location,
            String address, String transport) {
        String encodedPassword = passwordEncoder.encode(password);
        Role studentRole = roleRepository.findByAuthority("STUDENT").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(studentRole);
        User user = userRepository
                .save(new User(0, email, firstName, lastName, encodedPassword, phoneNumber, authorities));
        user.setUsername(firstName + lastName + user.getUserId().toString());
        userRepository.save(user);
        StudentDetails studentDetails = new StudentDetails(user, university, faculty, specialty, yearOfStudy, group,
                location, address, transport);
        studentDetailsRepository.save(studentDetails);
        return user;
    }

    public LoginResponseDTO loginUser(String username, String password) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String token = tokenService.generateJwt(authentication);
            return new LoginResponseDTO(username, token);
        } catch (AuthenticationException e) {
            return new LoginResponseDTO(null, "");
        }
    }
}
