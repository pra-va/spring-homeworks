package lt.pra_va.cart.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lt.pra_va.product.model.Product;

@Component
public class ClientCart {
	private List<CartProduct> cartProducts = new ArrayList<CartProduct>();

	public ClientCart() {
	}

	public void addCartProduct(Product product) {
		this.cartProducts
				.add(new CartProduct(product.getId(), product.getProductDetails().getImageUrl(), product.getTitle()));
	}

	public void addCartProduct(CartProduct cartProduct) {
		this.cartProducts.add(cartProduct);
	}

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

}
