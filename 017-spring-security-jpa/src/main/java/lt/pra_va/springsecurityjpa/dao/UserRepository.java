package lt.pra_va.springsecurityjpa.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.pra_va.springsecurityjpa.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}
