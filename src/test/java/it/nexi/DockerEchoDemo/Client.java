package it.nexi.DockerEchoDemo;

import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class Client {
	
	private static final String URL = "http://localhost:8080/echo";
	private static final String APIS_URL = "http://localhost:8181/v2/api-docs";

	public static void main(String[] args) {
		runTests();
	}
	
	public static void runTests() {
		
		Logger logger = (Logger)LoggerFactory.getLogger("org.apache.http");
	    logger.setLevel(Level.INFO);
	    logger.setAdditive(false);
	    
	    doGetApis();
	    
	    doCall(HttpMethod.GET);
	    doCall(HttpMethod.POST);
	    doCall(HttpMethod.PUT);
	    doCall(HttpMethod.DELETE);
	    doCall(HttpMethod.PATCH);
	}
	
	private static void doGetApis() {
	    String apis = new RestTemplate().getForObject(APIS_URL, String.class);
	    System.out.println("APIS = " + apis);
	}
	
	private static void doCall(HttpMethod method) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    
	    RestTemplate restTemplate = new RestTemplate();
	    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
	    restTemplate.setRequestFactory(requestFactory);
	    
	    Message responseMessage = new Message("Test_OK_chiamata_metodo_" + method.name());

	    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL);
	    if (method == HttpMethod.GET) {
	    	builder.queryParam("message", responseMessage.getMessage());
	    }
	    
	    Message response = 
	    		restTemplate.exchange(builder.toUriString(), method,
	    							  new HttpEntity<Message>(responseMessage, headers),
	    							  Message.class).getBody();
	    System.out.println("TEST risposta metodo " + method.name() + " : [" + response.getMessage() + "]");
	}
}
