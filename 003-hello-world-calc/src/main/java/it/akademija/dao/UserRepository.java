package it.akademija.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import it.akademija.model.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

	User findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

	void removeByUsernameIgnoreCase(String username);

	@Query("select user from User user order by user.age desc")
	List<User> findOldestUser();

}
