package it.akademija;

public class Product {
	private String title;
	private String price;
	private String quantity;
	private String imageUrl;
	private String description;
	
	

	public Product(String title, String price, String quantity, String imageUrl, String description) {
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
		this.description = description;
	}



	@Override
	public String toString() {
		return "Product [title=" + title + ", price=" + price + ", quantity=" + quantity + ", imageUrl=" + imageUrl
				+ ", description=" + description + "]";
	}
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
