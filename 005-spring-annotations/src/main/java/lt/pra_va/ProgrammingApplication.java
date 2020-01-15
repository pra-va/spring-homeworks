package lt.pra_va;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProgrammingApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ProgrammingConfiguration.class);

		ProgrammingCoach coach = context.getBean("programmingCoach", ProgrammingCoach.class);

		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		context.close();

	}

}
