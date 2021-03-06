package lt.prava.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.prava.users.dao.UserRepository;
import lt.prava.users.model.Role;
import lt.prava.users.model.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findById(username).get();
		if (user == null) {
			throw new UsernameNotFoundException(username + " not found.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				AuthorityUtils.createAuthorityList(new String[] { "ROLE_" + user.getRole().getName() }));
	}

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public User findByEmail(String email) {
		return userRepository.findByEmailIgnoreCase(email);
	}

	@Transactional
	public void createUser(String username, String email, String password) {
		User newUser = new User();
		newUser.setUsername(username);
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		newUser.setPassword(encoder.encode(password));
		Role role = new Role();
		role.setName("CALC");
		newUser.setRole(role);
		User savedUser = userRepository.save(newUser);
	}
}
