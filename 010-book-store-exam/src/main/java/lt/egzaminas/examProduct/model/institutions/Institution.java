package lt.egzaminas.examProduct.model.institutions;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lt.egzaminas.examProduct.model.enums.Category;

@Entity(name = "Institution")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "institution_type")
//@NamedQuery(name = "Institution.getInstitutionByType", query = "select i from Institution i where i.institution_type like ?1")
public abstract class Institution {
	private static final Logger LOGGER = LogManager.getLogger(Institution.class);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String town;

	private String photo;

	private Category category;

//	private List<Book> books;

	public Institution() {
	}

	public Institution(String name, String town, String photo, Category category) {
		this.name = name;
		this.town = town;
		this.photo = photo;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public static Logger getLogger() {
		return LOGGER;
	}

}
