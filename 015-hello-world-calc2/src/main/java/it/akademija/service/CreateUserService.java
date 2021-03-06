package it.akademija.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.dao.UserRepository;
import it.akademija.model.Role;
import it.akademija.model.User;

@Service
public class CreateUserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void createUser(String email, String password) {
		User newUser = new User();
		newUser.setEmail(email);

		Password
		
		newUser.setPasswordString(encoder.encode(password));

		Role role = new Role();
		role.setName("CALC");
		newUser.setRole(role);
		userRepository.save(newUser);
	}
}
