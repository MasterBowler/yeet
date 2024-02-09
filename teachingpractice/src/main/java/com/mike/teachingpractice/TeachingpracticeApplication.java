package com.mike.teachingpractice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mike.teachingpractice.models.Role;
import com.mike.teachingpractice.models.User;
import com.mike.teachingpractice.repositories.RoleRepository;
import com.mike.teachingpractice.repositories.UserRepository;

@SpringBootApplication
public class TeachingpracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeachingpracticeApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RoleRepository roleRepository, UserRepository userRepository,
			PasswordEncoder passwordEncoder) {
		return args -> {

			if (roleRepository.findByAuthority("ADMIN").isPresent())
				return;

			Role adminRole = roleRepository.save(new Role("ADMIN"));
			// roleRepository.save(new Role("USER"));
			roleRepository.save(new Role("TEACHER"));
			roleRepository.save(new Role("STUDENT"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			User adminUser = new User(0, "admin@gmail.com", "admin", "Adminescu", passwordEncoder.encode("admin"),
					"0756212748", roles);
			userRepository.save(adminUser);
		};
	}
}
