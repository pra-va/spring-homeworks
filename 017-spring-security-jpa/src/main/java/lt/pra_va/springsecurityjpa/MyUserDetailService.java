package lt.pra_va.springsecurityjpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lt.pra_va.springsecurityjpa.dao.UserRepository;
import lt.pra_va.springsecurityjpa.models.MyUserDetails;
import lt.pra_va.springsecurityjpa.models.User;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

		return user.map(MyUserDetails::new).get();
	}

}
