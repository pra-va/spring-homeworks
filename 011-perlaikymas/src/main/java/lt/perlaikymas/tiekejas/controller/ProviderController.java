package lt.perlaikymas.tiekejas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lt.perlaikymas.paslauga.service.ServiceDataWithPrice;
import lt.perlaikymas.tiekejas.model.AddServiceToProviderCommand;
import lt.perlaikymas.tiekejas.model.CreateProviderComand;
import lt.perlaikymas.tiekejas.service.ProviderData;
import lt.perlaikymas.tiekejas.service.ServiceOfProvider;

@CrossOrigin
@RestController
@RequestMapping("/api/provider")
public class ProviderController {
	@Autowired
	private ServiceOfProvider serviceOfProvider;

	@GetMapping
	@ApiOperation(value = "getAllProviders")
	public List<ProviderData> getAllProviders() {
		return serviceOfProvider.getAllProviders();
	}

	@PostMapping
	@ApiOperation(value = "newProvider")
	public void newProvider(@RequestBody CreateProviderComand command) {
		this.serviceOfProvider.createProvider(new ProviderData(command.getNamel(), command.getCity(),
				command.getCompanyCode(), command.getEvaluation(), command.getCompanyType()));
	}

	@RequestMapping(path = "/{providerName}", method = RequestMethod.GET)
	@ApiOperation(value = "getSingleProvider")
	public ProviderData getSingleProvider(@PathVariable String providerName) {
		return this.serviceOfProvider.getSingleProvider(providerName);
	}

	@RequestMapping(path = "/{providerName}", method = RequestMethod.PUT)
	@ApiOperation(value = "editProvider")
	public void editProvider(@PathVariable String providerName, @RequestBody CreateProviderComand command) {
		this.serviceOfProvider.editProvider(providerName, new ProviderData(command.getNamel(), command.getCity(),
				command.getCompanyCode(), command.getEvaluation(), command.getCompanyType()));
	}

	@RequestMapping(path = "/{providerName}", method = RequestMethod.DELETE)
	@ApiOperation(value = "deleteProvider")
	public void deleteProvider(@PathVariable String providerName) {
		this.serviceOfProvider.deleteProvider(providerName);
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "addServiceToProvider")
	private void addServiceToProvider(@RequestBody AddServiceToProviderCommand command) {
		this.serviceOfProvider.addService(command.getServiceName(), command.getServicePrice(),
				command.getProviderName());
	}

	@RequestMapping(path = "/remove/{providerName}/{serviceName}", method = RequestMethod.DELETE)
	@ApiOperation(value = "providerName")
	private void deleteServiceFromProvider(@PathVariable("serviceName") String serviceName,
			@PathVariable("providerName") String providerName) {
		this.serviceOfProvider.removeService(serviceName, providerName);
	}

	@RequestMapping(path = "/services/{providerName}", method = RequestMethod.GET)
	@ApiOperation(value = "getServicesByProvider")
	private List<ServiceDataWithPrice> getServicesByProvider(@PathVariable String providerName) {
		return this.serviceOfProvider.getServiceData(providerName);
	}

}
