package lt.itmokymai.spring;

import java.util.List;

public class ServiceC {
	private List<Product> items;
	
	public String getResult() {
		StringBuilder builder = new StringBuilder();
		for (Product product : items) {
			builder.append(product.toString() + "\n");
		}
		return builder.toString();
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}
	
	
	
	
}
