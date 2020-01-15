package it.akademija.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.akademija.PagingData;
import it.akademija.model.CreateUserCommand;
import it.akademija.model.User;
import it.akademija.service.JpaUserService;
import it.akademija.service.UserService;

@RestController
@Api(value = "user")
@RequestMapping(value = "/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PagingData pagingData;
	@Autowired
	private JpaUserService jpaUserService;

	public UserController() {
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create user", notes = "Creates user with data.")
	public void createUser(
			@ApiParam(value = "User Data", required = true) @Valid @RequestBody final CreateUserCommand command) {
		jpaUserService.createUser(new User(command.getUsername(), command.getFirstName(), command.getLastName(),
				command.getAge(), command.getEmail()));
	}

	@RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete user", notes = "Deletes user with certain username.")
	public void deleteUser(@PathVariable final String username) {
		jpaUserService.deleteUser(username);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get users", notes = "Returns registered users.")
	public List<User> getUsers() {
//		this.pagingData.setLimit(10);
		return jpaUserService.getUsers();
	}

	@RequestMapping(path = "/{firstName}/{lastName}", method = RequestMethod.GET)
	@ApiOperation(value = "Find user", notes = "Returns user with certain first and last name.")
	public User findUserByFirstAndLastName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		System.out.println("Returning: " + jpaUserService.findByFirstAndLastName(firstName, lastName));
		return jpaUserService.findByFirstAndLastName(firstName, lastName);
	}

	@RequestMapping(path = "/oldest", method = RequestMethod.GET)
	@ApiOperation(value = "Find oldest user", notes = "Returns current oldest user.")
	public User findOldestUser() {
		return jpaUserService.findOldestUser();
	}
}
