package it.nexi.docker.echo;

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
/* @RequestMapping("/echo") // moved to application.properties */
@RestController
public class DockerController {
	
	@PostMapping
	public Message echoPost(@RequestBody(required =  true) Message body) {
		if (null == body) {
			body = new Message();
		}
		return body.addMethod("POST");
	}
	
	@GetMapping
	public Message echoGet(@RequestParam(required = false) String text, @RequestBody(required =  false) Message body) {
		if (null == body) {
			body = new Message();
		}
		if (null != text) {
			body.setText(text);
		}
		return body.addMethod("GET");
	}
	
	@PutMapping
	public Message echoPut(@RequestBody(required =  true) Message body) {
		if (null == body) {
			body = new Message();
		}
		return body.addMethod("PUT");
	}
	
	@DeleteMapping
	public Message echoDelete(@RequestBody(required =  true) Message body) {
		if (null == body) {
			body = new Message();
		}
		return body.addMethod("DELETE");
	}
	
	@PatchMapping
	public Message echoPatch(@RequestBody(required =  true) Message body) {
		if (null == body) {
			body = new Message();
		}
		return body.addMethod("PATCH");
	}

}
