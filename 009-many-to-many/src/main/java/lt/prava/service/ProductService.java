package lt.prava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.prava.dao.CartRepository;
import lt.prava.dao.ProductRepo;
import lt.prava.model.Cart;
import lt.prava.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private CartRepository cartRepository;

	public ProductService() {
	}

	public void createProduct(Product product) {
		productRepo.save(product);
	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public void addProductToCart(Long productId, String username) {
		Product product = productRepo.findById(productId).get();
		Cart cart = cartRepository.findByUsernameIgnoreCase(username);

		if (cart == null) {
			cart = new Cart(username);
		}

		if (product != null) {
			cart.addProduct(product);
			product.addCart(cart);
			cartRepository.save(cart);
		}
	}

}
