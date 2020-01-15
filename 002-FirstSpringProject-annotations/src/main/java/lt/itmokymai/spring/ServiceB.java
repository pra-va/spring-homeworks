package lt.itmokymai.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServiceB {
	@Autowired
	@Qualifier("serviceABean")
	private ServiceA serviceA;

	public String getResult() {
		return "ServiceB result:" + serviceA.getResult();
	}

	public ServiceA getServiceA() {
		return serviceA;
	}
//
//	public void setServiceA(ServiceA serviceA) {
//		this.serviceA = serviceA;
//	}

}