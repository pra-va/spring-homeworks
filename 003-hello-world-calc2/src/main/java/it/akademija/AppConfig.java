package it.akademija;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import it.akademija.dao.DBUsersRepository;

@Configuration
@ImportResource({ "classpath*:application-context.xml" })
public class AppConfig {

	@Bean
	public Product product1() {
		return new Product("Product1", "asd", "asd", "asd", "asd");
	}

	@Bean
	public Product product2() {
		return new Product("Product2", "asd", "asd", "asd", "asd");
	}

	@Bean
	public Product product3() {
		return new Product("Product3", "asd", "asd", "asd", "asd");
	}

	@Bean
	public DBUsersRepository repoUserDao() {
		return new DBUsersRepository();
	}

}