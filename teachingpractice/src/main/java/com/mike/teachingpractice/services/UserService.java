package com.mike.teachingpractice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mike.teachingpractice.repositories.UserRepository;

//This class determines whether the username&password match up

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    // @Autowired
    // private UserRepository userRepository;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // System.out.println("In the user details service");

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username is not valid"));
    }

    // public void connectUser(User user); status online
    // public void disconnectUser(User user); status offline
    // maybe online status should be set at login / logout

}
