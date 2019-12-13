package it.nexi.DockerEchoDemo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "DockerController")
@RestController
public class DockerController {
	
	@PostMapping(path = "/echo")
	public Message echoPost(@RequestBody(required =  true) Message body) {
		if (null == body) {
			body = new Message();
		}
		return body.addMethod("POST");
	}
	
	@GetMapping(path = "/echo")
	public Message echoGet(@RequestParam(required = false) String message, @RequestBody(required =  false) Message body) {
		if (null == body) {
			body = new Message();
		}
		if (null != message) {
			body.setMessage(message);
		}
		return body.addMethod("GET");
	}
	
	@PutMapping(path = "/echo")
	public Message echoPut(@RequestBody(required =  true) Message body) {
		if (null == body) {
			body = new Message();
		}
		return body.addMethod("PUT");
	}
	
	@DeleteMapping(path = "/echo")
	public Message echoDelete(@RequestBody(required =  true) Message body) {
		if (null == body) {
			body = new Message();
		}
		return body.addMethod("DELETE");
	}
	
	@PatchMapping(path = "/echo")
	public Message echoPatch(@RequestBody(required =  true) Message body) {
		if (null == body) {
			body = new Message();
		}
		return body.addMethod("PATCH");
	}

}
