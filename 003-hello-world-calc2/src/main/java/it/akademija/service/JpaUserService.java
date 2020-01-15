package it.akademija.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.dao.UserRepository;
import it.akademija.model.User;

@Service
public class JpaUserService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void createUser(User user) {
		this.userRepository.save(user);
	}

	@Transactional
	public void deleteUser(String username) {
		userRepository.removeByUsernameIgnoreCase(username);
	}

	@Transactional
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Transactional
	public User findByFirstAndLastName(String firstName, String lastName) {
		return userRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
	}

	@Transactional
	public User findOldestUser() {
		return userRepository.findOldestUser().get(0);
	}
}
