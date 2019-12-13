package it.nexi.docker.echo;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DockerEchoDemoApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(DockerEchoDemoApplication.class, args);
		
		log.info("Variabili di ambiente:");
		for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
			log.info("[{}] = [{}]", entry.getKey(),  entry.getValue());
		}
		
		log.info("Apis at : /v2/api-docs");
	}

}
