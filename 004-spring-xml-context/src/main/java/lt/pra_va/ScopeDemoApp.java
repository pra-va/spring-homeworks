package lt.pra_va;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeDemoApp {
	public static void main(String[] args) {
		// Create spring container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("scope-application-context.xml");

		// Create coach objects
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// Check if coaches are the same object. b
		boolean result = (theCoach == alphaCoach);

		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMem location for theCoach: " + theCoach);
		System.out.println("\nMem location for alphaCoach: " + alphaCoach);

		context.close();
	}
}
