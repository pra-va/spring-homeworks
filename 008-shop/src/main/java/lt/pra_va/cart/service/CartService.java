package lt.pra_va.cart.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.pra_va.cart.dao.CartRepository;
import lt.pra_va.cart.model.Cart;
import lt.pra_va.cart.model.CartProduct;
import lt.pra_va.product.dao.ProductsRepository;
import lt.pra_va.product.model.Product;

@Service
public class CartService {
	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private CartRepository cartRepository;

	@Transactional
	public List<CartProduct> getProducts(String username) {
		Cart cart = cartRepository.findByUsernameIgnoreCase(username);
		if (cart != null) {
			return cart
					.getProducts().stream().map((product) -> new CartProduct(product.getId(),
							product.getProductDetails().getImageUrl(), product.getTitle()))
					.collect(Collectors.toList());
		} else {
			return null;
		}

	}

	@Transactional
	public void addProduct(CartProduct cartProduct, String username) {
		Cart cart = cartRepository.findByUsernameIgnoreCase(username);
		Product product = productsRepository.findById(cartProduct.getId()).get();

		if (cart == null) {
			cart = new Cart(username);
		}

		if (product != null) {
			cart.addProduct(product);
			product.addCart(cart);
			productsRepository.save(product);
		}
	}

	@Transactional
	public void deleteProduct(String username, Long productId) {
		Cart cart = cartRepository.findByUsernameIgnoreCase(username);
		Product product = productsRepository.findById(productId).get();

		cart.getProducts().remove(product);
		product.getCarts().remove(cart);

		cartRepository.save(cart);
		productsRepository.save(product);
	}

}
