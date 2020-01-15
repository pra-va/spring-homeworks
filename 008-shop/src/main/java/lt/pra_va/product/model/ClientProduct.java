package lt.pra_va.product.model;

import lt.pra_va.product.service.ProductOfService;

public class ClientProduct {
	private Long id;
	private String title;
	private double price;
	private int quantity;
	private String imageUrl;
	private String description;

	public ClientProduct() {
	}

	public ClientProduct(Product product) {
		this.id = product.getId();
		this.title = product.getTitle();
		this.price = product.getPrice();
		this.quantity = product.getQuantity();
		this.imageUrl = product.getProductDetails().getImageUrl();
		this.description = product.getProductDetails().getImageUrl();
	}

	public void clientProductSetup(ProductOfService productOfService) {
		this.id = productOfService.getId();
		this.title = productOfService.getTitle();
		this.price = productOfService.getPrice();
		this.quantity = productOfService.getQuantity();
		this.imageUrl = productOfService.getImageUrl();
		this.description = productOfService.getDescription();
	}

	public String getTitle() {
		return title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
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
