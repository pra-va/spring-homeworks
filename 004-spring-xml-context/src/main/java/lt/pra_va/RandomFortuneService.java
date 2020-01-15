package lt.pra_va;

import java.util.ArrayList;
import java.util.Random;

public class RandomFortuneService implements FortuneService {
	private ArrayList<String> randomFortunes = new ArrayList<String>();

	public RandomFortuneService(String good, String bad, String medium) {
		if (good != null) {
			this.randomFortunes.add(good);
		}

		if (bad != null) {
			this.randomFortunes.add(bad);
		}

		if (medium != null) {
			this.randomFortunes.add(medium);
		}

	}

	public String getFortune() {
		Random random = new Random();
		int randomNumber = random.nextInt(3);
		return randomFortunes.get(randomNumber);
	}

}
