package lt.egzaminas.examProduct.service.for_client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lt.egzaminas.examProduct.model.enums.Category;
import lt.egzaminas.examProduct.model.enums.RentType;

public class RentForClient extends InstitutionForClient {
	private static final Logger LOGGER = LogManager.getLogger(RentForClient.class);

	private String name;
	private String town;
	private String photo;
	private Category category;
	private RentType rentType;

	public RentForClient(String name, String town, String photo, Category category, RentType rentType) {
		super();
		this.name = name;
		this.town = town;
		this.photo = photo;
		this.category = category;
		this.rentType = rentType;
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

	public RentType getRentType() {
		return rentType;
	}

	public void setRentType(RentType rentType) {
		this.rentType = rentType;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
