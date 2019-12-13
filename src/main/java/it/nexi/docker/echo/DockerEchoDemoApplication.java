package it.nexi.DockerEchoDemo;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerEchoDemoApplication {

	public static void main(String[] args) {
		
		System.out.println("Variabili di ambiente:");
		for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
			System.out.println("[" + entry.getKey() + "] = [" + entry.getValue() + "]");
		}
		
		System.out.println("Apis at : /v2/api-docs");
		
		SpringApplication.run(DockerEchoDemoApplication.class, args);
	}

}
