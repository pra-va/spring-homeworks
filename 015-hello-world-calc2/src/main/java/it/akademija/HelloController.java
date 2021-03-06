package it.akademija;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.akademija.service.CreateUserService;
import lombok.Data;

@RestController
public class HelloController {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private CreateUserService createUserService;

	@RequestMapping(value = "loggedUsername", method = RequestMethod.GET)
	public String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUsername = authentication.getName();
			return currentUsername;
		}
		return "not logged";
	}

	@RequestMapping(value = "createuser", method = RequestMethod.POST)
	public void createUser(@RequestBody CreateUserCommand command) {
		createUserService.createUser(command.getEmail(), command.getPassword());
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String hello() {
		return "Hello World!";
	}

	@Data
	static class Result {

		private final int left;
		private final int right;
		private final long answer;
	}

	@RequestMapping(value = "calc", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CALC')")
	Result calc(@RequestParam int left, @RequestParam int right) {
		MapSqlParameterSource source = new MapSqlParameterSource().addValue("left", left).addValue("right", right);
		return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
				(rs, rowNum) -> new Result(left, right, rs.getLong("answer")));
	}

//	@RequestMapping("calc")
//	@PreAuthorize("hasRole('CALC')")
//	String calc() {
//		return "<h1>Hi, Hello!</h1>";
//	}

}
