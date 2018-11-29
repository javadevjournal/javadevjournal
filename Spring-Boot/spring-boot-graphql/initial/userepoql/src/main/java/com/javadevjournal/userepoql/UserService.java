package com.javadevjournal.userepoql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
@Transactional
public class UserService {
	private UserRepository store ;
	
	public UserService(UserRepository db) {
		this.store = db ;
	}
	
	public List<User> getAllUsers() {
		return this.store.findAll();
	}
	
	public Optional<User> getUser(String id) {
		return this.store.findById(id);
	}
	
	public User saveUser(User user) {
		return this.store.save(user);
	}
	
	public void deleteUser(String id) {
		this.store.deleteById(id);
	}
}
