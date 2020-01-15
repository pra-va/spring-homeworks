package lt.pra_va;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		Coach theCoach = context.getBean("BestBadmintonCoach", Coach.class);

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		context.close();
	}
}
