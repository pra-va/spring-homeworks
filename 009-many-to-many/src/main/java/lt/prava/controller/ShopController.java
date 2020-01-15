package lt.prava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lt.prava.model.Product;
import lt.prava.service.ProductService;

@RestController
public class ShopController {
	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/products/{title}", method = RequestMethod.POST)
	@ApiOperation(value = "createProduct", notes = "Creates a single product with a specified title.")
	public void createProduct(@PathVariable String title) {
		productService.createProduct(new Product(title));
	}

	@RequestMapping(path = "/products", method = RequestMethod.GET)
	@ApiOperation(value = "getAllProducts", notes = "Returns a list of all created products.")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@RequestMapping(path = "/add/{username}/{id}", method = RequestMethod.POST)
	@ApiOperation(value = "addProductToACart", notes = "Adds product provided by id to a cart of provided username.")
	public void addProductToCart(@PathVariable("id") Long id, @PathVariable("username") String username) {
		productService.addProductToCart(id, username);
	}

}
