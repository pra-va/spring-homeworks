package lt.pra_va;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("badmintonFortune")
public class BadmintonFortuneService implements FortuneService {
	@Value("${good}")
	private String good;
	@Value("${bad}")
	private String bad;
	@Value("${medium}")
	private String medium;
	private String[] randomFortunes = new String[3];

	public BadmintonFortuneService() {
	}

	@PostConstruct
	public void defineRandomFortunes() {
		this.randomFortunes[0] = this.good;
		this.randomFortunes[1] = this.bad;
		this.randomFortunes[2] = this.medium;
	}

	public String getFortune() {
		Random random = new Random();
		return this.randomFortunes[random.nextInt(this.randomFortunes.length)];
	}

}
