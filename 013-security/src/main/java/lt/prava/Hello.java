package lt.prava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Hello {

	@GetMapping
	public String helloWorld() {
		return ("<h1>Hello, World!</h1>");
	}
}
