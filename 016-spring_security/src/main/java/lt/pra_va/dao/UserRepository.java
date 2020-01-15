package lt.pra_va.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.pra_va.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByEmail(String email);

}
