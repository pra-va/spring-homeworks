package lt.egzaminas.examProduct.service;

import lt.egzaminas.examProduct.model.enums.ArchiveType;
import lt.egzaminas.examProduct.model.enums.Category;
import lt.egzaminas.examProduct.model.enums.LibraryType;
import lt.egzaminas.examProduct.model.enums.RentType;

public class InstitutionData {
	private String name;
	private String town;
	private String photo;
	private Category category;
	private ArchiveType archiveType;
	private LibraryType libraryType;
	private RentType rentType;

	public InstitutionData() {
	}

	public InstitutionData(String name, String town, String photo, Category category) {
		this.name = name;
		this.town = town;
		this.photo = photo;
		this.category = category;

	}

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

	public ArchiveType getArchiveType() {
		return archiveType;
	}

	public void setArchiveType(ArchiveType archiveType) {
		this.archiveType = archiveType;
	}

	public LibraryType getLibraryType() {
		return libraryType;
	}

	public void setLibraryType(LibraryType libraryType) {
		this.libraryType = libraryType;
	}

	public RentType getRentType() {
		return rentType;
	}

	public void setRentType(RentType rentType) {
		this.rentType = rentType;
	}

}
