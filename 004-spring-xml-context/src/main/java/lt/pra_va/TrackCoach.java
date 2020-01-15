package lt.pra_va;

public class TrackCoach implements Coach {
	private HappyFortuneService happyFortuneService;

	public TrackCoach(HappyFortuneService happyFortuneService) {
		this.happyFortuneService = happyFortuneService;
	}

	public String getDailyWorkout() {
		return "Run a hard 5km.";
	}

	public String getDailyFortune() {
		return "Just do it: " + happyFortuneService.getFortune();
	}

	// add an init method
	public void doMyStartupStuff() {
		System.out.println("Track coach inside startup method.");
	}

	// add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("Track coach inside destroy method.");
	}

}
