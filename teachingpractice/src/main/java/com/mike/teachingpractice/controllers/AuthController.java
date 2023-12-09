package com.mike.teachingpractice.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mike.teachingpractice.dtos.UserDto;
import com.mike.teachingpractice.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.mike.teachingpractice.config.UserAuthenticationProvider;
import com.mike.teachingpractice.dtos.CredentialsDto;
import com.mike.teachingpractice.dtos.SignUpDto;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping(value = "/api/auth/logn")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("api/auth/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("api/users/" + createdUser.getId())).body(createdUser);
    }

}