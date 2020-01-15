package it.akademija.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.dao.DBUsersRepository;
import it.akademija.model.User;

@Service
public class UserService {
	@Autowired
	@Qualifier("repoUserDao")
	private DBUsersRepository repository;

	public UserService() {
	}

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return repository.getUsers();
	}

	@Transactional
	public void createUser(User user) {
		repository.createUser(user);
	}

	@Transactional
	public void deleteUser(String username) {
		repository.deleteUser(username);
	}

}
