package lt.pra_va;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigApp {
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		context.close();
	}
}
