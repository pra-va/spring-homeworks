package lt.perlaikymas.tiekejas.service;

import lt.perlaikymas.tiekejas.model.CompanyType;

public class ProviderData {
	private String namel;
	private String city;
	private String companyCode;
	private int evaluation;
	private CompanyType companyType;

	public ProviderData() {
	}

	public ProviderData(String namel, String city, String companyCode, int evaluation, CompanyType companyType) {
		this.namel = namel;
		this.city = city;
		this.companyCode = companyCode;
		this.evaluation = evaluation;
		this.companyType = companyType;
	}

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
