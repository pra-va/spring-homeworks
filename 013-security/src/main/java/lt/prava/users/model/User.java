package lt.prava.users.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "User")
@Table(name = "user")
public class User {

	@NotBlank
	@Id
	@Column
	private String username;

	@NotBlank
	@Size(min = 6)
	@Column
	private String password;

	@NotBlank
	@Email
	@Column
	private String email;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "ROLE_ID")
	private Role role;

	public User(@NotBlank String username, @NotBlank @Size(min = 6) String password, @NotBlank @Email String email,
			Role role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
