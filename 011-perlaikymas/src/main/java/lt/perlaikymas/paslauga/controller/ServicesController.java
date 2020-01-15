package lt.perlaikymas.paslauga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lt.perlaikymas.paslauga.model.CreateServiceCommand;
import lt.perlaikymas.paslauga.service.ServiceData;
import lt.perlaikymas.paslauga.service.ServiceOfService;

@RestController
@RequestMapping("/api/service")
public class ServicesController {

	@Autowired
	private ServiceOfService serviceOfService;

	@GetMapping
	@ApiOperation(value = "getAllServices")
	public List<ServiceData> getAllServices() {
		return serviceOfService.getAllServices();
	}

	@PostMapping
	@ApiOperation(value = "newService")
	public void newService(@RequestBody CreateServiceCommand command) {
		this.serviceOfService.createService(new ServiceData(command.getName(), command.getPhotoId(),
				command.getServiceCategory(), command.getDescription(), command.getPrice()));
	}

	@RequestMapping(path = "/{serviceName}", method = RequestMethod.GET)
	@ApiOperation(value = "getSingleService")
	public ServiceData getSingleService(@PathVariable String serviceName) {
		return this.serviceOfService.getSingleService(serviceName);
	}

	@RequestMapping(path = "/{serviceName}", method = RequestMethod.PUT)
	@ApiOperation(value = "editService")
	public void editService(@PathVariable String serviceName, @RequestBody CreateServiceCommand command) {
		this.serviceOfService.editService(serviceName, new ServiceData(command.getName(), command.getPhotoId(),
				command.getServiceCategory(), command.getDescription(), command.getPrice()));
	}
}
