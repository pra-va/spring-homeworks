package lt.egzaminas.examProduct.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lt.egzaminas.examProduct.model.CreateArchiveCommand;
import lt.egzaminas.examProduct.model.CreateLibraryCommand;
import lt.egzaminas.examProduct.model.CreateRentCommand;
import lt.egzaminas.examProduct.model.CreateStoreCommand;
import lt.egzaminas.examProduct.model.institutions.Institution;
import lt.egzaminas.examProduct.service.InstitutionData;
import lt.egzaminas.examProduct.service.InstitutionService;

@RestController
@RequestMapping("/api/exam")
public class InstitutionController {
	private static final Logger LOGGER = LogManager.getLogger(InstitutionController.class);

	@Autowired
	private InstitutionService institutionService;

	@RequestMapping(path = "/create/store", method = RequestMethod.POST)
	@ApiOperation(value = "createBookStore")
	public void createBookStore(@RequestBody final CreateStoreCommand createStoreCommand) {
		institutionService.createStore(new InstitutionData(createStoreCommand.getName(), createStoreCommand.getTown(),
				createStoreCommand.getPhoto(), createStoreCommand.getCategory()));
	}

	@RequestMapping(path = "/create/rent", method = RequestMethod.POST)
	@ApiOperation(value = "createBookRent")
	public void createBookRent(@RequestBody final CreateRentCommand createRentCommand) {
		InstitutionData institutionData = new InstitutionData(createRentCommand.getName(), createRentCommand.getTown(),
				createRentCommand.getPhoto(), createRentCommand.getCategory());
		institutionData.setRentType(createRentCommand.getRentType());
		institutionService.createRent(institutionData);
	}

	@RequestMapping(path = "/create/library", method = RequestMethod.POST)
	@ApiOperation(value = "createBookLibrary")
	public void createBookLibrary(@RequestBody final CreateLibraryCommand createLibraryCommand) {
		InstitutionData institutionData = new InstitutionData(createLibraryCommand.getName(),
				createLibraryCommand.getTown(), createLibraryCommand.getPhoto(), createLibraryCommand.getCategory());
		institutionData.setLibraryType(createLibraryCommand.getLibraryType());
		institutionService.createLibrary(institutionData);
	}

	@RequestMapping(path = "/create/archive", method = RequestMethod.POST)
	@ApiOperation(value = "createBookarchive")
	public void createBookArchive(@RequestBody final CreateArchiveCommand createArchiveCommand) {
		InstitutionData institutionData = new InstitutionData(createArchiveCommand.getName(),
				createArchiveCommand.getTown(), createArchiveCommand.getPhoto(), createArchiveCommand.getCategory());
		institutionData.setArchiveType(createArchiveCommand.getArchiveType());
		institutionService.createArchive(institutionData);
	}

	@GetMapping
	@ApiOperation(value = "Get all books.")
	public List<Institution> getAllInstitutions() {
		return institutionService.getAllInstitutions();
	}

}
