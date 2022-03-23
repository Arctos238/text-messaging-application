package dev.jrip.txtms.problemdomain;

import java.util.*;

public abstract class Message {
	private String bodyOfMessage;
	private int messageSerialCode;
	
	public Message (String bodyOfMessage) {
		
		this.bodyOfMessage = bodyOfMessage;
		this.messageSerialCode = generateSerialCode();
	}
	
	public Message (String bodyOfMessage, int messageSerialCode) {
		this.bodyOfMessage = bodyOfMessage;
		this.messageSerialCode = messageSerialCode;
	}
	
	public String getBodyOfMessage() {
		
		return bodyOfMessage;
	}
	
	public int getMessageSerialCode() {
		
		return messageSerialCode;
	}
	
	private int generateSerialCode() {
		return 10000 + (int)(Math.random() * 89999);
	}
	
	@Override
	public String toString() {
		return "Message: " + this.bodyOfMessage + "\n";
	}
	
}
