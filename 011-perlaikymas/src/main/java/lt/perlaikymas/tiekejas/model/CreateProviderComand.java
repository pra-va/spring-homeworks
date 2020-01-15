package lt.perlaikymas.tiekejas.model;

public class CreateProviderComand {
	private String namel;
	private String city;
	private String companyCode;
	private int evaluation;
	private CompanyType companyType;

	public String getNamel() {
		return namel;
	}

	public void setNamel(String namel) {
		this.namel = namel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

}
