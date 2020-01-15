package lt.pra_va;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfig {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());

		context.close();

	}
}
