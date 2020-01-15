package lt.egzaminas.examProduct.model.institutions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import lt.egzaminas.examProduct.model.enums.Category;
import lt.egzaminas.examProduct.model.enums.LibraryType;

@Entity
@DiscriminatorValue(value = "library")
public class Library extends Institution {
	private Long booksLent = 0L;
	@Enumerated
	private LibraryType libraryType;

	public Library() {
	}

	public Library(String name, String town, String photo, Category category, LibraryType libraryType) {
		super(name, town, photo, category);
		this.libraryType = libraryType;
	}

	public Long getBooksLent() {
		return booksLent;
	}

	public void setBooksLent(Long booksLent) {
		this.booksLent = booksLent;
	}

	public LibraryType getLibraryType() {
		return libraryType;
	}

	public void setLibraryType(LibraryType libraryType) {
		this.libraryType = libraryType;
	}

}
