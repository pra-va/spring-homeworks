package lt.pra_va.product.service;

import lt.pra_va.product.model.CreateProductCommand;
import lt.pra_va.product.model.Product;

public class ProductOfService {
	private Long id;
	private String title;
	private double price;
	private int quantity;
	private String imageUrl;
	private String description;

	public ProductOfService() {
	}

	public ProductOfService(String title, double price, int quantity, String imageUrl, String description, Long id) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void productSetup(Product product) {
		this.id = product.getId();
		this.title = product.getTitle();
		this.price = product.getPrice();
		this.quantity = product.getQuantity();
		this.imageUrl = product.getProductDetails().getImageUrl();
		this.description = product.getProductDetails().getDetails();
	}

	public void productSetup(CreateProductCommand createProductCommand) {
		this.title = createProductCommand.getTitle();
		this.price = createProductCommand.getPrice();
		this.quantity = createProductCommand.getQuantity();
		this.imageUrl = createProductCommand.getImageUrl();
		this.description = createProductCommand.getDescription();
	}

	public void productSetup(String title, double price, int quantity, String imageUrl, String description) {
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
		this.description = description;
	}

	public String getTitle() {
		return title;
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
