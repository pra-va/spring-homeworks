package lt.itmokymai.spring;

import org.springframework.stereotype.Component;

@Component
public class ServiceA {

	public ServiceA() {
		super();
	}

	public ServiceA(String message) {
		super();
		this.message = message;
	}

	private String message;

	public String getResult() {
		return getMessage();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void init() {
		System.out.println("Init method is running");
	}

	public void destroy() {
		System.out.println("Destroy method is running");
	}

}
