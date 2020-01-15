package lt.pra_va.cart.model;

public class CartProduct {
	private Long id;
	private String image;
	private String title;

	public CartProduct() {
	}

	public CartProduct(Long id, String image, String title) {
		this.id = id;
		this.image = image;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
