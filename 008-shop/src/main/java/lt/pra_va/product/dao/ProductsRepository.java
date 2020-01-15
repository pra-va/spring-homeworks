package lt.pra_va.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.pra_va.product.model.Product;

public interface ProductsRepository extends JpaRepository<Product, Long> {
	List<Product> myQuery(double price);

	List<Product> myJoinQuery(double price);
}
