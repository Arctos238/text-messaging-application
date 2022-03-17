package dev.jrip.txtms.problemdomain;

import java.util.*;

public class Message {
	private String bodyOfMessage;
	private Date sentDate;
	private int messageSerialCode;
	
	public Message (String bodyOfMessage) {
		
		this.bodyOfMessage = bodyOfMessage;
		this.messageSerialCode = generateSerialCode();
		sentDate = new Date();
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
		return "Sent: " + this.sentDate + "\n" + "Message: " + this.bodyOfMessage + "\n";
	}
	
}
