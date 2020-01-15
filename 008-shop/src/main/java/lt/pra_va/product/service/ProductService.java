package lt.pra_va.product.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.pra_va.product.dao.ProductsRepository;
import lt.pra_va.product.model.ClientProduct;
import lt.pra_va.product.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private ApplicationContext context;

	private static final Logger LOGGER = LogManager.getLogger(ProductService.class);

	@Transactional
	public List<ClientProduct> findByPrice(double price) {
		List<Product> products = productsRepository.myQuery(price);
		List<ClientProduct> clientProducts = products.stream().map((product) -> new ClientProduct(product))
				.collect(Collectors.toList());
		return clientProducts;
	}

	@Transactional
	public void createProduct(ProductOfService productOfService) {
		productsRepository.save(new Product(productOfService.getTitle(), productOfService.getPrice(),
				productOfService.getQuantity(), productOfService.getImageUrl(), productOfService.getDescription()));
	}

	@Transactional
	public List<ProductOfService> getAllProducts() {
		return this.productsRepository.findAll().stream()
				.map((product) -> new ProductOfService(product.getTitle(), product.getPrice(), product.getQuantity(),
						product.getProductDetails().getImageUrl(), product.getProductDetails().getDetails(),
						product.getId()))
				.collect(Collectors.toList());
	}

	@Transactional
	public ProductOfService getProduct(Long productId) {
		Product product = this.productsRepository.findById(productId).orElse(null);
		ProductOfService productOfService = context.getBean(ProductOfService.class);
		productOfService.productSetup(product);
		return productOfService;

	}

	@Transactional
	public void updateProduct(Long productId, ProductOfService productOfService) {
		if (this.productsRepository.existsById(productId)) {
			this.productsRepository.deleteById(productId);
			this.productsRepository.save(new Product(productOfService));
		}
	}

	@Transactional
	public void deleteProduct(Long productId) {
		this.productsRepository.deleteById(productId);
	}

	@PostConstruct
	public void init() {
		LOGGER.info("Product service CREATED");
	}

	@PreDestroy
	public void destroy() {
		LOGGER.info("Product service DESTROYED");
	}

}
