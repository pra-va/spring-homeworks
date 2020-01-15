package lt.egzaminas.examProduct.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.egzaminas.examProduct.dao.InstitutionRepository;
import lt.egzaminas.examProduct.model.institutions.Archive;
import lt.egzaminas.examProduct.model.institutions.Institution;
import lt.egzaminas.examProduct.model.institutions.Library;
import lt.egzaminas.examProduct.model.institutions.Rent;
import lt.egzaminas.examProduct.model.institutions.Store;

@Service
public class InstitutionService {
	private static final Logger LOGGER = LogManager.getLogger(InstitutionService.class);

	@Autowired
	private InstitutionRepository institutionRepository;

	@Transactional
	public void createStore(InstitutionData data) {
		institutionRepository.save(new Store(data.getName(), data.getTown(), data.getPhoto(), data.getCategory()));
	}

	@Transactional
	public void createRent(InstitutionData data) {
		institutionRepository.save(
				new Rent(data.getName(), data.getTown(), data.getPhoto(), data.getCategory(), data.getRentType()));
	}

	@Transactional
	public void createLibrary(InstitutionData data) {
		institutionRepository.save(new Library(data.getName(), data.getTown(), data.getPhoto(), data.getCategory(),
				data.getLibraryType()));
	}

	@Transactional
	public void createArchive(InstitutionData data) {
		institutionRepository.save(new Archive(data.getName(), data.getTown(), data.getPhoto(), data.getCategory(),
				data.getArchiveType()));
	}

	@Transactional
	public List<Institution> getAllInstitutions() {
		return institutionRepository.findAll();
	}

}
