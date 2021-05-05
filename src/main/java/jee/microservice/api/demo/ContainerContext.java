package jee.microservice.api.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ContainerContext {

	@GetMapping("/containerId")
	public String returnContainerId() {
		String containerId = "empty";
		try {
			InetAddress id = InetAddress.getLocalHost();
			containerId = id.getHostName();
		} catch (UnknownHostException e) {
			containerId= e.getMessage();			
		}
		return "Welcome to java techie " + containerId;
	}

	@GetMapping("/greet")
	public String greetConsumer() {
		return "Welcome ! I'm a microservice running in beatutiful world of Openshift platform";
	}

	public static void main(String[] args) {
		SpringApplication.run(ContainerContext.class, args);
	}

}