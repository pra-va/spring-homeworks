package lt.prava.users.model;

public class CreateRoleModel {

	private String name;

	public CreateRoleModel(String name) {
		this.name = name;
	}

	public CreateRoleModel() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
