package it.akademija.dao;

import java.util.List;

import it.akademija.model.User;

public interface UserData {

	List<User> getUsers();

	void createUser(User user);

	void deleteUser(String username);
}
