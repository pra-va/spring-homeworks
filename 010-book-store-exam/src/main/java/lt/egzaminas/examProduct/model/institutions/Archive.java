package lt.egzaminas.examProduct.model.institutions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import lt.egzaminas.examProduct.model.enums.ArchiveType;
import lt.egzaminas.examProduct.model.enums.Category;

@Entity
@DiscriminatorValue(value = "archive")
public class Archive extends Institution {
	@Enumerated
	private ArchiveType archiveType;

	public Archive() {
	}

	public Archive(String name, String town, String photo, Category category, ArchiveType archiveType) {
		super(name, town, photo, category);
		this.archiveType = archiveType;
	}

	public ArchiveType getArchiveType() {
		return archiveType;
	}

	public void setArchiveType(ArchiveType archiveType) {
		this.archiveType = archiveType;
	}

}
