package lt.prava.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Cart")
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLong;

	private String username;

	@ManyToMany(mappedBy = "carts")
	@JsonBackReference
	List<Product> products = new ArrayList<Product>();

	public Cart() {
	}

	public Cart(String username) {
		this.username = username;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public Long getIdLong() {
		return idLong;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setIdLong(Long idLong) {
		this.idLong = idLong;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
