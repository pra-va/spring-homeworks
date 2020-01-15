package lt.pra_va.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.pra_va.cart.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	Cart findByUsernameIgnoreCase(String username);
}
