package lt.pra_va.product.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lt.pra_va.cart.model.Cart;
import lt.pra_va.product.service.ProductOfService;

@Entity(name = "Product")
@Table(name = "product")
@NamedQuery(name = "Product.myQuery", query = "select p from Product p where p.price < ?1")
@NamedQuery(name = "Product.myJoinQuery", query = "select p.title, w.imageUrl from Product p join p.productDetails w where p.price < ?1")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String title;

	@Column
	private double price;

	@Column
	private int quantity;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private ProductDetails productDetails;

	private static final Logger LOGGER = LogManager.getLogger(Product.class);

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "product_cart", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "cart_id"))
//	@JsonIgnore
	private List<Cart> carts = new ArrayList<Cart>();

	public Product() {
	}

	public Product(String title, double price, int quantity, String imageUrl, String details) {
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.productDetails = new ProductDetails(imageUrl, details, this);
	}

	public Product(ProductOfService productOfService) {
		this.title = productOfService.getTitle();
		this.price = productOfService.getPrice();
		this.quantity = productOfService.getQuantity();
		this.productDetails = new ProductDetails(productOfService.getImageUrl(), productOfService.getDescription(),
				this);
	}

	public void productSetup(String title, double price, int quantity, String imageUrl, String details) {
		LOGGER.info("\tAssigning properites: " + title + " " + price + " " + quantity + " " + imageUrl + " " + details);
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.productDetails = new ProductDetails(imageUrl, details, this);
	}

	public void addCart(Cart cart) {
		this.carts.add(cart);
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public void init() {
		LOGGER.info("Product CREATED");
	}

	public void destroy() {
		LOGGER.info("Product " + this.title + "  DESTROYED");
	}

}
