package lt.pra_va.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lt.pra_va.dao.UserRepository;
import lt.pra_va.model.Role;
import lt.pra_va.model.User;

@Service
public class CreateUserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(String email, String password) {
		User newUser = new User();
		newUser.setEmail(email);

		PasswordEncoder encoder = new BCryptPasswordEncoder();

		newUser.setPasswordString(encoder.encode(password));

		Role role = new Role();
		role.setName("CALC");
		newUser.setRole(role);
		userRepository.save(newUser);
	}
}
