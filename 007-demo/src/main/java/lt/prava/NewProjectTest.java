
package lt.prava;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewProjectTest {

	@RequestMapping("/")
	String helloWorld() {
		return "Hello, world!";
	}
}
