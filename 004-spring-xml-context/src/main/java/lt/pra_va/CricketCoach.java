package lt.pra_va;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;

	// no-args constructor
	public CricketCoach() {
		System.out.println("Cricket coach is inside no args constructor.");
	}

	public String getEmail() {
		return emailAddress;
	}

	public void setEmail(String emailAddress) {
		System.out.println("Cricket coach inside EMAIL setter method.");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Cricket coach inside TEAM setter method.");
		this.team = team;
	}

	// setter method to inject dependency
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket coach inside FORTUNE SERVICE setter method.");
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes.";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
