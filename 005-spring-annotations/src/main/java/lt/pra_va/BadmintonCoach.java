package lt.pra_va;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("BestBadmintonCoach")
public class BadmintonCoach implements Coach {
	@Autowired
	@Qualifier("badmintonFortune")
	private FortuneService fortuneService;

	public String getDailyWorkout() {
		return "Practice your backhand smash for 30 mins.";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
