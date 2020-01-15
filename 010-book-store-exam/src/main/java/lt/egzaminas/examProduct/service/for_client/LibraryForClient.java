package lt.egzaminas.examProduct.service.for_client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lt.egzaminas.examProduct.model.enums.Category;
import lt.egzaminas.examProduct.model.enums.LibraryType;

public class LibraryForClient extends InstitutionForClient {
	private static final Logger LOGGER = LogManager.getLogger(LibraryForClient.class);

	private String name;
	private String town;
	private String photo;
	private Category category;
	private LibraryType libraryType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LibraryType getLibraryType() {
		return libraryType;
	}

	public void setLibraryType(LibraryType libraryType) {
		this.libraryType = libraryType;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
