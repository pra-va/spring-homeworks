package lt.pra_va;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

		boolean result = (theCoach == alphaCoach);

		System.out.println("The coach equals to alpha coach: " + result);
		System.out.println("The coach memory location: " + theCoach);
		System.out.println("Alpha coach memory location: " + alphaCoach);

		context.close();

	}

}
