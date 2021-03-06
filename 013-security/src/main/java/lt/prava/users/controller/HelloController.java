package lt.prava.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.prava.users.model.CreateUserModel;
import lt.prava.users.services.UserService;

@RestController
public class HelloController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/loggedUsername", method = RequestMethod.GET)
	public String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			return currentUserName;
		}
		return "not logged";
	}

	@RequestMapping(path = "/api/newUser", method = RequestMethod.POST)
	public void createNewUser(@RequestBody CreateUserModel createUserModel) {
		userService.createUser(createUserModel.getUsername(), createUserModel.getEmail(),
				createUserModel.getPassword());
	}

}
