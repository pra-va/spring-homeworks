package lt.pra_va;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lt.pra_va.model.CreateUserCommand;
import lt.pra_va.service.CreateUserService;

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
