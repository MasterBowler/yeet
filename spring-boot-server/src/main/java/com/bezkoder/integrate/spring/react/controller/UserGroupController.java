package com.bezkoder.integrate.spring.react.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.integrate.spring.react.model.UserGroup;
import com.bezkoder.integrate.spring.react.repository.UserGroupRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserGroupController {

	@Autowired
	UserGroupRepository userGroupRepository;

	@GetMapping("/userGroups")
	public ResponseEntity<List<UserGroup>> getAllUserGroups(@RequestParam(required = false) String name) {

		try {

			List<UserGroup> userGroups = new ArrayList<>();

			if (name == null) {

				userGroups.addAll(userGroupRepository.findAll());

			} else {

				userGroups.addAll(userGroupRepository.findByNameContaining(name));
			}

			if (userGroups.isEmpty()) {

				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(userGroups, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/userGroups/{id}")
	public ResponseEntity<UserGroup> getUserGroupById(@PathVariable("id") long id) {

		Optional<UserGroup> userGroupOptional = userGroupRepository.findById(id);
		return userGroupOptional.map(set -> new ResponseEntity<>(set, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/userGroups")
	public ResponseEntity<UserGroup> createUserGroup(@RequestBody UserGroup userGroup) {

		try {

			UserGroup newUserGroup = new UserGroup(userGroup.getName(), userGroup.getPermissionSet());
			newUserGroup = userGroupRepository.save(newUserGroup);

			return new ResponseEntity<>(newUserGroup, HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/userGroups/{id}")
	public ResponseEntity<UserGroup> updateUserGroup(@PathVariable("id") long id, @RequestBody UserGroup userGroup) {

		Optional<UserGroup> userGroupOptional = userGroupRepository.findById(id);

		if (userGroupOptional.isPresent()) {

			UserGroup updatedUserGroup = userGroupOptional.get();
			updatedUserGroup.setName(userGroup.getName());
			updatedUserGroup.setPermissionSet(userGroup.getPermissionSet());

			return new ResponseEntity<>(userGroupRepository.save(updatedUserGroup), HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/userGroups/{id}")
	public ResponseEntity<HttpStatus> deleteUserGroup(@PathVariable("id") long id) {

		try {

			userGroupRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/userGroups")
	public ResponseEntity<HttpStatus> deleteAllPermissionSets() {

		try {

			userGroupRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
