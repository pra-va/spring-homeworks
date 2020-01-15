package lt.perlaikymas.tiekejas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.perlaikymas.tiekejas.model.Provider;

public interface ProviderRepository extends JpaRepository<Provider, String> {
	Provider findByNamelIgnoreCase(String name);
}
