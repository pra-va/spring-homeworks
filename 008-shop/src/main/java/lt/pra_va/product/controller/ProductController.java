package lt.pra_va.product.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.pra_va.product.model.ClientProduct;
import lt.pra_va.product.model.CreateProductCommand;
import lt.pra_va.product.service.ProductOfService;
import lt.pra_va.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	private static final Logger LOGGER = LogManager.getLogger(ProductController.class);

	@Autowired
	private ApplicationContext context;

	@RequestMapping(path = "/getByPrice/{price}", method = RequestMethod.GET)
	@ApiOperation(value = "Find product by exect price")
	public List<ClientProduct> getProductByPrice(@PathVariable double price) {
		return productService.findByPrice(price);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create product", notes = "Creates new shop product.")
	public void createProduct(
			@ApiParam(value = "Product data", required = true) @RequestBody final CreateProductCommand command) {
		ProductOfService productOfService = context.getBean(ProductOfService.class);
		productOfService.productSetup(command);
		productService.createProduct(productOfService);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get all products", notes = "Returns all products.")
	public List<ClientProduct> getAllProducts() {
		List<ProductOfService> products = productService.getAllProducts();
		List<ClientProduct> clientProducts = new ArrayList<>();
		for (ProductOfService product : products) {
			ClientProduct clientProduct = context.getBean(ClientProduct.class);
			clientProduct.clientProductSetup(product);
			clientProducts.add(clientProduct);
		}
		return clientProducts;

	}

	@RequestMapping(path = "/{productId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get single product", notes = "Rerturns single product by provided product id.")
	public ClientProduct getProduct(@PathVariable Long productId) {
		ClientProduct clientProduct = context.getBean(ClientProduct.class);
		clientProduct.clientProductSetup(this.productService.getProduct(productId));
		return clientProduct;
	}

	@RequestMapping(path = "/{productId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Updates product", notes = "Updates product using provided product id.")
	public void updateProduct(@PathVariable("productId") Long productId,
			@RequestBody final CreateProductCommand command) {
		ProductOfService productOfService = context.getBean(ProductOfService.class);
		productOfService.productSetup(command);
		this.productService.updateProduct(productId, productOfService);
	}

	@RequestMapping(path = "/{productId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Deletes product", notes = "Deletes product using provided product id.")
	public void deleteProduct(@PathVariable Long productId) {
		this.productService.deleteProduct(productId);
	}

	@PostConstruct
	public void init() {
		LOGGER.info("Product controller CREATED");
	}

	@PreDestroy
	public void destroy() {
		LOGGER.info("Product controller DESTROYED");
	}

}
