package lt.pra_va.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Role")
public class Role {

	@Id
	@NotBlank
	private String name;

	public Role(String name) {
		this.name = name;
	}

	public Role() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
