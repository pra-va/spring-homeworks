package lt.perlaikymas.paslauga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lt.perlaikymas.tiekejas.model.Provider;

@Entity(name = "Service")
@Table(name = "service")
public class Service {
	@Id
	private String name;
	private String photoId;
	@Enumerated
	private ServiceCategory serviceCategory;
	private String description;
	private Double price;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinTable(name = "service_provider", joinColumns = @JoinColumn(name = "service_name"), inverseJoinColumns = @JoinColumn(name = "provider_name"))
	private List<Provider> providers = new ArrayList<>();

	public Service() {
	}

	public Service(String name, String photoId, ServiceCategory serviceCategory, String description, Double price) {
		this.name = name;
		this.photoId = photoId;
		this.serviceCategory = serviceCategory;
		this.description = description;
		this.price = price;
	}

	public void addProvider(Provider provider) {
		this.providers.add(provider);
	}

	public void removeProvider(Provider provider) {
		this.providers.remove(provider);
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
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

	@Override
	public String toString() {
		return "Service [name=" + name + ", photoId=" + photoId + ", serviceCategory=" + serviceCategory
				+ ", description=" + description + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photoId == null) ? 0 : photoId.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((serviceCategory == null) ? 0 : serviceCategory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photoId == null) {
			if (other.photoId != null)
				return false;
		} else if (!photoId.equals(other.photoId))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (serviceCategory != other.serviceCategory)
			return false;
		return true;
	}

}
