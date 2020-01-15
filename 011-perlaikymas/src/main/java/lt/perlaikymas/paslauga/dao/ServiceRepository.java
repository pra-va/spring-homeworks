package lt.perlaikymas.paslauga.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.perlaikymas.paslauga.model.Service;

public interface ServiceRepository extends JpaRepository<Service, String> {

	Service findByNameIgnoreCase(String name);

}
