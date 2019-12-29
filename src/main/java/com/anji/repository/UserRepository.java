package com.anji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anji.entity.User;
import com.anji.entity.enums.Role;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	User findByPassword(String password);

	User findByRole(Role role);

}
