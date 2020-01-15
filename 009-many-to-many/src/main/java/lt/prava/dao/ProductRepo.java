package lt.prava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.prava.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
