package com.bezkoder.integrate.spring.react.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.integrate.spring.react.model.UserGroup;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

	List<UserGroup> findByNameContaining(String name);
}
