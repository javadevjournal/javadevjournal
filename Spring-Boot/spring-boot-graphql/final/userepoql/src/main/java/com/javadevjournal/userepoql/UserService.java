package com.javadevjournal.userepoql;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
	
	public Optional<User> getUser(int id) {
		return this.store.findById(id);
	}
	
	public List<User> getUsers(int first, int last) {
		if ((last == 0) || (last < first)) {
			// Ignore last if invalid value was specified
			last = (int) this.store.count();
		}
		return this.store.findAllById(
			IntStream.rangeClosed(first, last)
			.boxed()
			.collect(Collectors.toList())
		);
	}
	
	public User newUser(String login, String name) {
		User u = new User();
		u.setLogin(login);
		u.setName(name);
		return this.store.save(u);
	}
	
	public User saveUser(User user) {
		return this.store.save(user);
	}
	
	public void deleteUser(int id) {
		this.store.deleteById(id);
	}
}
