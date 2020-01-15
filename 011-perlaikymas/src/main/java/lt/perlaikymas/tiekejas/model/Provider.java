package lt.perlaikymas.tiekejas.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import lt.perlaikymas.paslauga.model.Service;

@Entity(name = "Provider")
@Table(name = "provider")
public class Provider {
	@Id
	private String namel;
	private String city;
	private String companyCode;
	private int evaluation;
	@Enumerated
	private CompanyType companyType;

	@ManyToMany(mappedBy = "providers", cascade = { CascadeType.MERGE, CascadeType.DETACH }, fetch = FetchType.EAGER)
	private List<Service> services = new ArrayList<Service>();

	@ElementCollection
	@MapKeyColumn(name = "service_price")
	private Map<String, Double> priceOfServicesMap = new HashMap<String, Double>();

	public Provider() {
	}

	public Provider(String namel, String city, String companyCode, int evaluation, CompanyType companyType) {
		this.namel = namel;
		this.city = city;
		this.companyCode = companyCode;
		this.evaluation = evaluation;
		this.companyType = companyType;
	}

	public void addService(Service service, Double price) {
		this.priceOfServicesMap.put(service.getName(), price);
		this.services.add(service);
	}

	public void removeService(Service service) {
		this.priceOfServicesMap.remove(service.getName());
	}

	public Map<String, Double> getPriceOfServicesMap() {
		return priceOfServicesMap;
	}

	public void setPriceOfServicesMap(Map<String, Double> priceOfServicesMap) {
		this.priceOfServicesMap = priceOfServicesMap;
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

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((companyCode == null) ? 0 : companyCode.hashCode());
		result = prime * result + ((companyType == null) ? 0 : companyType.hashCode());
		result = prime * result + evaluation;
		result = prime * result + ((namel == null) ? 0 : namel.hashCode());
		result = prime * result + ((priceOfServicesMap == null) ? 0 : priceOfServicesMap.hashCode());
		result = prime * result + ((services == null) ? 0 : services.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Provider other = (Provider) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (companyCode == null) {
			if (other.companyCode != null)
				return false;
		} else if (!companyCode.equals(other.companyCode))
			return false;
		if (companyType != other.companyType)
			return false;
		if (evaluation != other.evaluation)
			return false;
		if (namel == null) {
			if (other.namel != null)
				return false;
		} else if (!namel.equals(other.namel))
			return false;
		if (priceOfServicesMap == null) {
			if (other.priceOfServicesMap != null)
				return false;
		} else if (!priceOfServicesMap.equals(other.priceOfServicesMap))
			return false;
		if (services == null) {
			if (other.services != null)
				return false;
		} else if (!services.equals(other.services))
			return false;
		return true;
	}

	public void setPriceOfServicesMap(HashMap<String, Double> priceOfServicesMap) {
		this.priceOfServicesMap = priceOfServicesMap;
	}

}
