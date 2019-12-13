package it.nexi.docker.echo;

import lombok.Getter;
import lombok.Setter;

public class Message {
	
	@Getter @Setter
	private String text;
	
	@Getter @Setter
	private String method;
	
	public Message() {
	}
	
	public Message(String text) {
		this.text = text;
	}
	
	public Message(String text, String method) {
		this.text = text;
		this.method = method;
	}

	public Message addMethod(String method) {
		this.method = method;
		return this;
	}

}
