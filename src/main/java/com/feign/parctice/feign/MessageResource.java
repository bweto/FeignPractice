package com.feign.parctice.feign;

import java.io.Serializable;
import java.util.List;

public class MessageResource implements Serializable {

	private static final long serialVersionUID = -6352757695011026328L;

	private List<String> messages;

	private String reasonPhrase;

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public String getReasonPhrase() {
		return reasonPhrase;
	}

	public void setReasonPhrase(String reasonPhrase) {
		this.reasonPhrase = reasonPhrase;
	}

}
