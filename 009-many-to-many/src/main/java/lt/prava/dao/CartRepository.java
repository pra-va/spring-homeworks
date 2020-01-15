package lt.prava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.prava.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	Cart findByUsernameIgnoreCase(String username);
}
