package lt.pra_va;

public class ProgrammingCoach implements Coach {
	private FortuneService fortuneService;

	public ProgrammingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Code for 2 hours.";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
