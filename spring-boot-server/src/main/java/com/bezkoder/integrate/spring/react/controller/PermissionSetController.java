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

import com.bezkoder.integrate.spring.react.model.PermissionSet;
import com.bezkoder.integrate.spring.react.repository.PermissionSetRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PermissionSetController {

	@Autowired
	PermissionSetRepository permissionSetRepository;

	@GetMapping("/permissionSets")
	public ResponseEntity<List<PermissionSet>> getAllPermissionSets(@RequestParam(required = false) String name) {

		try {

			List<PermissionSet> permissionSets = new ArrayList<>();

			if (name == null) {

				permissionSets.addAll(permissionSetRepository.findAll());

			} else {

				permissionSets.addAll(permissionSetRepository.findByNameContaining(name));
			}

			if (permissionSets.isEmpty()) {

				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(permissionSets, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/permissionSets/{id}")
	public ResponseEntity<PermissionSet> getPermissionSetById(@PathVariable("id") long id) {

		Optional<PermissionSet> permissionSetOptional = permissionSetRepository.findById(id);
		return permissionSetOptional.map(set -> new ResponseEntity<>(set, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/permissionSets")
	public ResponseEntity<PermissionSet> createPermissionSet(@RequestBody PermissionSet permissionSet) {

		try {

			PermissionSet newPermissionSet = new PermissionSet(permissionSet.getName(), permissionSet.getPermissions());
			newPermissionSet = permissionSetRepository.save(newPermissionSet);

			return new ResponseEntity<>(newPermissionSet, HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/permissionSets/{id}")
	public ResponseEntity<PermissionSet> updatePermissionSet(@PathVariable("id") long id, @RequestBody PermissionSet permissionSet) {

		Optional<PermissionSet> permissionSetOptional = permissionSetRepository.findById(id);

		if (permissionSetOptional.isPresent()) {

			PermissionSet updatedPermissionSet = permissionSetOptional.get();
			updatedPermissionSet.setName(permissionSet.getName());
			updatedPermissionSet.setPermissions(permissionSet.getPermissions());

			return new ResponseEntity<>(permissionSetRepository.save(updatedPermissionSet), HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/permissionSets/{id}")
	public ResponseEntity<HttpStatus> deletePermissionSet(@PathVariable("id") long id) {

		try {

			permissionSetRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/permissionSets")
	public ResponseEntity<HttpStatus> deleteAllPermissionSets() {

		try {

			permissionSetRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
