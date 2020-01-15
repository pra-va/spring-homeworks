package lt.pra_va;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	// Default empty constructor.
	public TennisCoach() {
		System.out.println(">> Tennis coach inside default constructor.");
	}

//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}

	// Setter method with crazy name
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> Tennis coach inside doMyStartupStuff()");
	}

	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> Tennis coach inside doMyCleanupStuff()");
	}

	public String getDailyWorkout() {
		return "Practice your backhand voley.";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
