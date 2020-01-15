package lt.itmokymai.spring;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
	public ServiceA serviceABean() {
		return new ServiceA("Labas");
	}

	@Bean
	public ServiceB serviceBBean() {
		return new ServiceB();
	}

	@Bean
	public ServiceC serviceCBean() {
		return new ServiceC();
	}

	@Bean
	public Product product1() {
		return new Product("asd", "asd", "asd", "asd", "asd");
	}

	@Bean
	public Product product2() {
		return new Product("asd", "asd", "asd", "asd", "asd");
	}

	@Bean
	public Product product3() {
		return new Product("asd", "asd", "asd", "asd", "asd");
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Printer printer() {
		return new Printer();
	}

}
