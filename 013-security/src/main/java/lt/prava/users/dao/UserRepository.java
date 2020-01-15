package lt.prava.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.prava.users.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByEmailIgnoreCase(String email);
}
