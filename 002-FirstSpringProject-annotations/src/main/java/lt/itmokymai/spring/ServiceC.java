package lt.itmokymai.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServiceC {

	@Autowired
	@Qualifier("product1")
	private Product theProduct;
	@Autowired
	private List<Product> items;
	@Autowired
	private Printer printer;

	public String getResult() {
		StringBuilder builder = new StringBuilder();
		for (Product product : items) {
			builder.append(product.toString() + "\n");
		}
		return builder.toString();
	}

	public Product getTheProduct() {
		return this.theProduct;
	}

	public void print() {
		printer.print(items);
	}

	public List<Product> getItems() {
		return items;
	}

//	@Autowired
//	public void setList (List<Product> products) {
//		this.items = products;
//	}

//	@PostConstruct
//	public void initMethod() {
//		System.out.println("Creating ServiceC");
//	}
//	
//	@PreDestroy
//	public void destroyMethod() {
//		System.out.println("Destroying ServiceC");
//	}

}
