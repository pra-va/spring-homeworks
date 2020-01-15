package lt.pra_va;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] dataStrings = { "Beware of the wolf", "Diligence is mother", "The journey is the reward." };
	private Random random = new Random();

	public String getFortune() {
		int index = this.random.nextInt(dataStrings.length);
		return this.dataStrings[index];
	}

}
