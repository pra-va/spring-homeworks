package lt.egzaminas.examProduct.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lt.egzaminas.examProduct.model.enums.Category;

public class CreateStoreCommand {
	private static final Logger LOGGER = LogManager.getLogger(CreateStoreCommand.class);

	private String name;
	private String town;
	private String photo;
	private Category category;

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
