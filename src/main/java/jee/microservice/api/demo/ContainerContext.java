package jee.microservice.api.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DockerClientBuilder;

@SpringBootApplication
@RestController
public class ContainerContext {

	@GetMapping("/containerId")
	public String returnContainerId() {
		String containerId = "empty";
		DockerClient dockerClient = DockerClientBuilder.getInstance().build();
		ListContainersCmd listContainersCmd = dockerClient.listContainersCmd().withShowAll(true);
		for (Container container : listContainersCmd.exec()) {
			containerId = container.getId();
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