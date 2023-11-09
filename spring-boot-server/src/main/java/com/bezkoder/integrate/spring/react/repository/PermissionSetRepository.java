package com.bezkoder.integrate.spring.react.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.integrate.spring.react.model.PermissionSet;

public interface PermissionSetRepository extends JpaRepository<PermissionSet, Long> {

	List<PermissionSet> findByNameContaining(String name);
}
