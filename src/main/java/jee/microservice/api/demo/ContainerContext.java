package jee.microservice.api.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ContainerContext {

	String containerId = "empty";

	public ContainerContext() {
		try {
			InetAddress id = InetAddress.getLocalHost();
			containerId = id.getHostName();
		} catch (UnknownHostException e) {
			containerId = e.getMessage();
		}
	}

	@GetMapping("/container")
	public String represent() {
		return "Hello! I'm container with name :  " + containerId;
	}
	
	@GetMapping("/demo")
	public String demo() {
		return "Demo message :  " + containerId;
	}


	@GetMapping("/{input}")
	public String introduce(@PathVariable String input) {
		return "Hello " + input + " ! I'm container with name :  " + containerId + " living in a world called open shift.";
	}

	public static void main(String[] args) {
		SpringApplication.run(ContainerContext.class, args);
	}

}
