package it.nexi.DockerEchoDemo;

public class Message {
	
	private String message;
	private String method;
	
	public Message() {
	}
	
	public Message(String message) {
		this.message = message;
	}
	
	public Message(String message, String method) {
		this.message = message;
		this.method = method;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	
	public Message addMethod(String method) {
		this.method = method;
		return this;
	}

}
