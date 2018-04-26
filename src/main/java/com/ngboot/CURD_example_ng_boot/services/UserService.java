package com.ngboot.CURD_example_ng_boot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngboot.CURD_example_ng_boot.model.User;
import com.ngboot.CURD_example_ng_boot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User save(User user) {
		return userRepository.saveAndFlush(user); 
	}
	
	public User Update(User user) {
		return userRepository.save(user);
	}
	
	public User find(String username) {
		return userRepository.findByUsername(username);
	}
	
	public Optional<User> find(Long id) {
		return userRepository.findById(id);
	}
}
