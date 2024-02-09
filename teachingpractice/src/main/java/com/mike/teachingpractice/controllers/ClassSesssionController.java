package com.mike.teachingpractice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.mike.teachingpractice.dtos.ClassSessionDTO;
import com.mike.teachingpractice.models.ClassSession;
import com.mike.teachingpractice.models.Enrollment;
import com.mike.teachingpractice.models.Group;
import com.mike.teachingpractice.models.User;
import com.mike.teachingpractice.repositories.ClassSessionRepository;
import com.mike.teachingpractice.repositories.EnrollmentRepository;
import com.mike.teachingpractice.repositories.GroupMembershipRepository;
import com.mike.teachingpractice.repositories.GroupRepository;
import com.mike.teachingpractice.repositories.UserRepository;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/class-session")
public class ClassSesssionController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClassSessionRepository classSessionRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    GroupMembershipRepository GroupMembershipRepository;

    @Autowired
    EnrollmentRepository enrollmentRepository;

    // create new class session
    @PostMapping("/create")
    public ClassSession createNewClassSession(@RequestBody ClassSessionDTO classSessionDTO, Principal principal) {
        User teacher = userRepository.findByUsername(principal.getName()).get();
        Collection<? extends GrantedAuthority> authorities = teacher.getAuthorities();
        boolean isTeacher = authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_TEACHER"));
        if (isTeacher) {
            ClassSession classSession = new ClassSession(teacher,
                    groupRepository.findById(classSessionDTO.getGroupId()).get(), classSessionDTO.getDate(),
                    classSessionDTO.getStartTime(), classSessionDTO.getEndTime(), classSessionDTO.getAvailableSeats(),
                    classSessionDTO.getName(), classSessionDTO.getDescription());
            classSessionRepository.save(classSession);
            return classSession;
        }

        return null;
    }

    // get all class sessions

    // get all class session by group id
    @GetMapping("/group/{id}")
    public Set<ClassSession> getClassSessionsByGroup(@RequestParam String groupId, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        boolean isTeacher = authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_TEACHER"));
        boolean isStudent = authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_STUDENT"));
        if (isTeacher) {
            return classSessionRepository.findAllByGroupAndTeacher(
                    groupRepository.findById(Integer.parseInt(groupId)).get(),
                    user);
        } else if (isStudent) {
            Group group = GroupMembershipRepository.findByStudent(user).get().getGroup();

            // only return classes that a student has participated in OR
            // classes that a student is registered in OR
            // classes that a student can register in
            Set<ClassSession> classSessions = enrollmentRepository.findAllByStudent(user);
            classSessions.addAll(classSessionRepository.findAllFutureSessionsByGroup(group.getId()));
            return classSessions;
        }
        return null;
    }

    // enroll student to class session
    @PutMapping("enroll/{id}")
    public ClassSession enrollInClass(@PathVariable Integer classId, @RequestBody Principal principal) {
        User student = userRepository.findByUsername(principal.getName()).get();
        ClassSession classSession = classSessionRepository.findById(classId).orElse(null);
        if (classSession != null) {
            if (classSession.getAvailableSeats() > 0) {
                Enrollment enrollment = new Enrollment(classSession, student, LocalDateTime.now());
                enrollmentRepository.save(enrollment);
                classSession.setAvailableSeats(classSession.getAvailableSeats() - 1);
                classSessionRepository.save(classSession);
                return classSession;
            }
        }
        return null;
    }

    // cancel enrollment to class session
    @PutMapping("cancel/{id}")
    public ClassSession cancelEnrollmentInClass(@PathVariable Integer classId, @RequestBody Principal principal) {
        User student = userRepository.findByUsername(principal.getName()).get();
        ClassSession classSession = classSessionRepository.findById(classId).orElse(null);
        if (classSession != null) {
            Enrollment enrollment = enrollmentRepository.findBySessionAndStudent(classSession, student).orElse(null);
            if (enrollment != null) {
                enrollmentRepository.delete(enrollment);
                classSession.setAvailableSeats(classSession.getAvailableSeats() + 1);
                classSessionRepository.save(classSession);
                return classSession;
            }
        }
        return null;
    }

    // get class sessions of a teacher

    // update class session

    // delete class session

    // register student to class session

    // get all students in class session
}
