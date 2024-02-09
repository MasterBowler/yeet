package com.mike.teachingpractice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mike.teachingpractice.models.User;
import com.mike.teachingpractice.repositories.UserRepository;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
// ? CrossOrigin("*") - used to not get blocked by CORS
public class UserController {

    @Autowired
    private UserRepository userRepository; // Data Access Object

    @GetMapping("/hello")
    public String helloUserController(Principal principal) {
        return "User " + principal.getName();
    }

    // @PreAuthorize("hasAuthority("ADMIN")") how to auhtorize routes by role
    // @GetMapping("/adminOnly")
    // ...
}
