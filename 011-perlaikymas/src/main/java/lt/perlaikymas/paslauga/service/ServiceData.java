package lt.perlaikymas.paslauga.service;

import lt.perlaikymas.paslauga.model.ServiceCategory;

public class ServiceData {

	private String name;
	private String photoId;
	private ServiceCategory serviceCategory;
	private String description;
	private Double price;

	public ServiceData() {
	}

	public ServiceData(String name, String photoId, ServiceCategory serviceCategory, String description, Double price) {
		this.name = name;
		this.photoId = photoId;
		this.serviceCategory = serviceCategory;
		this.description = description;
		this.price = price;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public ServiceCategory getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(ServiceCategory serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
