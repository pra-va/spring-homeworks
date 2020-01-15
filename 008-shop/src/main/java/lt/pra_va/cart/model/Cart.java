package lt.pra_va.cart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lt.pra_va.product.model.Product;

@Entity(name = "Cart")
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	@ManyToMany(mappedBy = "carts", cascade = { CascadeType.MERGE, CascadeType.DETACH }, fetch = FetchType.EAGER)
	private List<Product> products = new ArrayList<Product>();

	public Cart() {
	}

	public Cart(String username) {
		this.username = username;
	}

	public void removeByProductId(Long productId) {
		Product productToRemove = null;
		for (Product product : products) {
			if (product.getId().equals(productId)) {
				productToRemove = product;
				break;
			}
		}
		this.products.remove(productToRemove);
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", username=" + username + ", products=" + products + "]";
	}

}
