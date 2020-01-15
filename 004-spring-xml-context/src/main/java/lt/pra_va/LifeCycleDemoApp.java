package lt.pra_va;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleDemoApp {
	public static void main(String[] args) {
		// Create spring container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"lifecycle-application-context.xml");

		// Create coach objects
		Coach theCoach = context.getBean("myCoach", Coach.class);

		context.close();
	}
}
