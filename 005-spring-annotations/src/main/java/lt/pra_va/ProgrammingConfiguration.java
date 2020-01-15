package lt.pra_va;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProgrammingConfiguration {

	@Bean
	public FortuneService fortuneService() {
		return new ProgrammingFortuneService();
	}

	@Bean
	public ProgrammingCoach programmingCoach() {
		return new ProgrammingCoach(fortuneService());
	}

}
