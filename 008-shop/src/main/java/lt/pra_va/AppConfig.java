package lt.pra_va;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import lt.pra_va.cart.model.CartProduct;

@Configuration
@ImportResource({ "classpath*:application-context.xml" })
public class AppConfig {

	@Bean
	public CartProduct cartProduct() {
		return new CartProduct();
	}

}
