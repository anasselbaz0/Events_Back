package com.anji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anji.entity.User;
import com.anji.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean loginUser(User user) {
		User dbUser = userRepository.findByUsername(user.getUsername());
		
		if(dbUser.equals(user)) 
		{
			return true;
		}
		return false;
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}

	public User saveOrUpdateUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
