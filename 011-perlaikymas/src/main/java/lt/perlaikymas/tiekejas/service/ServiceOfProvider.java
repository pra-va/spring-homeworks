package lt.perlaikymas.tiekejas.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.perlaikymas.paslauga.dao.ServiceRepository;
import lt.perlaikymas.paslauga.service.ServiceDataWithPrice;
import lt.perlaikymas.tiekejas.dao.ProviderRepository;
import lt.perlaikymas.tiekejas.model.Provider;

@Service
public class ServiceOfProvider {
	@Autowired
	private ProviderRepository providerRepository;

	@Autowired
	private ServiceRepository serviceRepository;

	// Create
	@Transactional
	public void createProvider(ProviderData providerData) {
		this.providerRepository.save(new Provider(providerData.getNamel(), providerData.getCity(),
				providerData.getCompanyCode(), providerData.getEvaluation(), providerData.getCompanyType()));
	}

	// ReadAll
	@Transactional
	public List<ProviderData> getAllProviders() {
		return this.providerRepository
				.findAll().stream().map((item) -> new ProviderData(item.getNamel(), item.getCity(),
						item.getCompanyCode(), item.getEvaluation(), item.getCompanyType()))
				.collect(Collectors.toList());
	}

	// ReadOne
	@Transactional
	public ProviderData getSingleProvider(String name) {
		Provider provider = providerRepository.findByNamelIgnoreCase(name);
		return new ProviderData(provider.getNamel(), provider.getCity(), provider.getCompanyCode(),
				provider.getEvaluation(), provider.getCompanyType());
	}

	// Update
	@Transactional
	public void editProvider(String name, ProviderData providerData) {
		Provider provider = this.providerRepository.findByNamelIgnoreCase(name);
		this.providerRepository.delete(provider);
		this.providerRepository.save(new Provider(providerData.getNamel(), providerData.getCity(),
				providerData.getCompanyCode(), providerData.getEvaluation(), providerData.getCompanyType()));
	}

	// Delete
	@Transactional
	public void deleteProvider(String name) {
		Provider provider = this.providerRepository.findByNamelIgnoreCase(name);
		this.providerRepository.delete(provider);
	}

	// Add Service
	@Transactional
	public void addService(String serviceName, Double price, String providerName) {
		Provider provider = this.providerRepository.findByNamelIgnoreCase(providerName);
		lt.perlaikymas.paslauga.model.Service service = this.serviceRepository.findByNameIgnoreCase(serviceName);

		provider.addService(service, price);
		service.addProvider(provider);

		this.serviceRepository.save(service);
		this.providerRepository.save(provider);
	}

	// Remove service
	@Transactional
	public void removeService(String serviceName, String providerName) {
		Provider provider = this.providerRepository.findByNamelIgnoreCase(providerName);
		lt.perlaikymas.paslauga.model.Service service = this.serviceRepository.findByNameIgnoreCase(serviceName);

		provider.removeService(service);
		service.removeProvider(provider);

		this.serviceRepository.save(service);
		this.providerRepository.save(provider);
	}

	@Transactional
	public List<ServiceDataWithPrice> getServiceData(String providerName) {
		Map<String, Double> prices = this.providerRepository.findByNamelIgnoreCase(providerName)
				.getPriceOfServicesMap();
		return this.providerRepository.findByNamelIgnoreCase(providerName).getServices().stream()
				.map((item) -> new ServiceDataWithPrice(item.getName(), item.getPhotoId(), item.getServiceCategory(),
						item.getDescription(), prices.get(item.getName())))
				.collect(Collectors.toList());
	}

}
