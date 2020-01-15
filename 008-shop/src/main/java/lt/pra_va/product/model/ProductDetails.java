package lt.pra_va.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ProductDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long detailsId;
	@Column
	private String imageUrl;
	@Column
	private String details;
	@OneToOne(mappedBy = "productDetails", orphanRemoval = true)
	@JsonBackReference
	private Product product;

	public ProductDetails() {
	}

	public ProductDetails(String imageUrlString, String details, Product product) {
		this.imageUrl = imageUrlString;
		this.details = details;
		this.product = product;
	}

	public String getImageUrlString() {
		return imageUrl;
	}

	public String getDetails() {
		return details;
	}

	public Long getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(Long detailsId) {
		this.detailsId = detailsId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
