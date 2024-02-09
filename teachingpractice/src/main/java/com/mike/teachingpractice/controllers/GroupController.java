package com.mike.teachingpractice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.mike.teachingpractice.models.Group;
import com.mike.teachingpractice.models.GroupMembership;
import com.mike.teachingpractice.models.User;
import com.mike.teachingpractice.repositories.GroupMembershipRepository;
import com.mike.teachingpractice.repositories.GroupRepository;
import com.mike.teachingpractice.repositories.UserRepository;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    GroupMembershipRepository groupMembershipRepository;

    // create new group
    @PostMapping("/create")
    public Integer createNewGroup(@RequestBody String groupName, String teacherUsername, Principal principal) {
        User teacher = userRepository.findByUsername(teacherUsername).get();
        User admin = userRepository.findByUsername(principal.getName()).get();
        boolean isAdmin = admin.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        if (isAdmin) {
            Group group = new Group(groupName, teacher);
            groupRepository.save(group);
        }
        return 0;
    }

    // add student to group
    @PutMapping("addStudent/{id}")
    public Integer putMethodName(@PathVariable String id, @RequestBody String studentUsername, Principal principal) {
        User student = userRepository.findByUsername(studentUsername).get();
        User admin = userRepository.findByUsername(principal.getName()).get();
        boolean hasAuthority = admin.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN") || a.getAuthority().equals("ROLE_TEACHER"));
        if (hasAuthority) {
            Group group = groupRepository.findById(Integer.parseInt(id)).orElse(null);
            if (group != null) {
                // check if student is not already in a group
                if (!groupMembershipRepository.existsByStudent(student)) {
                    GroupMembership groupMembership = new GroupMembership(group, student);
                    groupMembershipRepository.save(groupMembership);
                    return groupMembership.getId();
                }
            }
        }
        return 0;
    }

    // get all groups of a teacher
    @GetMapping("/getMyGroups")
    public Set<Group> getMyGroups(@RequestBody Principal principal) {
        User teacher = userRepository.findByUsername(principal.getName()).get();
        boolean isTeacher = teacher.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_TEACHER"));
        if (isTeacher) {
            return groupRepository.findAllByTeacher(teacher);
        }
        return null;
    }

    // get the group of a student
    @GetMapping("/getMyGroup")
    public Group getMyGroup(@RequestBody Principal principal) {
        User student = userRepository.findByUsername(principal.getName()).get();
        boolean isStudent = student.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_STUDENT"));
        if (isStudent) {
            GroupMembership groupMembership = groupMembershipRepository.findByStudent(student).get();
            return groupMembership.getGroup();
        }
        return null;
    }

    // get group by id

    // get group by teacher id

    // update group

    // delete group

    // register student to group

    // get all students in group
}
