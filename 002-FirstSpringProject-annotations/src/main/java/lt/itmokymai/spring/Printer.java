package lt.itmokymai.spring;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Printer {
	public void print(List<Product> products) {
		for (Product product : products) {
			System.out.println("Printer: " +  product.toString());
		}
	}
}
