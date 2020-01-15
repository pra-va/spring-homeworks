package lt.perlaikymas.paslauga.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.perlaikymas.paslauga.dao.ServiceRepository;

@Service
public class ServiceOfService {

	@Autowired
	private ServiceRepository serviceRepository;

	@Transactional
	public List<ServiceData> getAllServices() {
		return serviceRepository
				.findAll().stream().map((item) -> new ServiceData(item.getName(), item.getPhotoId(),
						item.getServiceCategory(), item.getDescription(), item.getPrice()))
				.collect(Collectors.toList());
	}

	@Transactional
	public void createService(ServiceData serviceData) {
		serviceRepository
				.save(new lt.perlaikymas.paslauga.model.Service(serviceData.getName(), serviceData.getPhotoId(),
						serviceData.getServiceCategory(), serviceData.getDescription(), serviceData.getPrice()));
	}

	@Transactional
	public ServiceData getSingleService(String serviceName) {
		lt.perlaikymas.paslauga.model.Service service = serviceRepository.findByNameIgnoreCase(serviceName);
		return new ServiceData(service.getName(), service.getPhotoId(), service.getServiceCategory(),
				service.getDescription(), service.getPrice());
	}

	@Transactional
	public void editService(String serviceName, ServiceData serviceData) {
		lt.perlaikymas.paslauga.model.Service service = serviceRepository.findByNameIgnoreCase(serviceName);
		serviceRepository.delete(service);
		serviceRepository
				.save(new lt.perlaikymas.paslauga.model.Service(serviceData.getName(), serviceData.getPhotoId(),
						serviceData.getServiceCategory(), serviceData.getDescription(), serviceData.getPrice()));
	}
}
