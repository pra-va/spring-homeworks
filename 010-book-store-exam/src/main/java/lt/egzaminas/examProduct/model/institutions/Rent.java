package lt.egzaminas.examProduct.model.institutions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import lt.egzaminas.examProduct.model.enums.Category;
import lt.egzaminas.examProduct.model.enums.RentType;

@Entity
@DiscriminatorValue(value = "rent")
public class Rent extends Institution {
	private Long booksRented = 0L;
	@Enumerated
	private RentType rentType;

	public Rent() {
	}

	public Rent(String name, String town, String photo, Category category, RentType rentType) {
		super(name, town, photo, category);
		this.rentType = rentType;
	}

	public Long getBooksRented() {
		return booksRented;
	}

	public void setBooksRented(Long booksRented) {
		this.booksRented = booksRented;
	}

	public RentType getRentType() {
		return rentType;
	}

	public void setRentType(RentType rentType) {
		this.rentType = rentType;
	}

}
