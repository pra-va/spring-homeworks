package lt.pra_va.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lt.pra_va.cart.model.CartProduct;
import lt.pra_va.cart.model.CreateCartProductCommand;
import lt.pra_va.cart.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	private CartService cartService;

	@RequestMapping(path = "/{username}", method = RequestMethod.POST)
	@ApiOperation(value = "Add product to a cart", notes = "Adds product by id to provided username cart.")
	private void addToCart(@PathVariable("username") String username,
			@RequestBody CreateCartProductCommand createCartProductCommand) {
		CartProduct cartProduct = new CartProduct(createCartProductCommand.getId(), createCartProductCommand.getImage(),
				createCartProductCommand.getTitle());
		cartService.addProduct(cartProduct, username);
	}

	@RequestMapping(path = "/{username}/{productId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete product from cart", notes = "Removes product specified by id from cart specified by username.")
	public void deleteProduct(@PathVariable("username") String username, @PathVariable("productId") Long productId) {
		cartService.deleteProduct(username, productId);
	}

	@RequestMapping(path = "/{username}", method = RequestMethod.GET)
	@ApiOperation(value = "Get single cart", notes = "Returns single cart provided by username.")
	public List<CartProduct> getCartProducts(@PathVariable String username) {
		return cartService.getProducts(username);
	}

}
