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

	@GetMapping("/load}")
	public String load() {
//		int numCore = 2;
//		int numThreadsPerCore = 2;
		double load = 0.8;
		final long duration = 60000;
		
		long startTime = System.currentTimeMillis();
		try {
            // Loop for the given duration
            while (System.currentTimeMillis() - startTime < duration) {
                // Every 100ms, sleep for the percentage of unladen time
                if (System.currentTimeMillis() % 100 == 0) {
                    Thread.sleep((long) Math.floor((1 - load) * 100));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//		
//		
//		for (int thread = 0; thread < numCore * numThreadsPerCore; thread++) {
//			new CPULoadGenerator("Thread" + thread, load, duration, null).start();
//		}
		return " Generated load & now check on my brother pods ";
	}

	public static void main(String[] args) {
		SpringApplication.run(ContainerContext.class, args);
	}

}
