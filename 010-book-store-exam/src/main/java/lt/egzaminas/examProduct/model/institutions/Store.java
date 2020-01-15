package lt.egzaminas.examProduct.model.institutions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lt.egzaminas.examProduct.model.enums.Category;

@Entity
@DiscriminatorValue(value = "store")
public class Store extends Institution {
	private Long booksSold = 0L;

	public Store() {
	}

	public Store(String name, String town, String photo, Category category) {
		super(name, town, photo, category);
	}

	public Long getBooksSold() {
		return booksSold;
	}

	public void setBooksSold(Long booksSold) {
		this.booksSold = booksSold;
	}

	@Override
	public String toString() {
		return "Store [booksSold=" + booksSold + ", getId()=" + getId() + ", getName()=" + getName() + ", getTown()="
				+ getTown() + ", getPhoto()=" + getPhoto() + ", getCategory()=" + getCategory() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
