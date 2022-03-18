package dev.jrip.txtms.problemdomain;

import java.util.*;

public class Contact {
	private String contactName;
	private long contactNumber;
	private long numberOfMessages;
	private ArrayList<Message> messages;

	public Contact(String contactName, long contactNumber, long numberOfMessages, ArrayList<Message> messages) {
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.numberOfMessages = numberOfMessages;
		this.messages = messages;
	}

	public Contact(String contactName, long contactNumber) {
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.messages = new ArrayList<Message>();
		this.numberOfMessages = 0;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public long getNumberOfMessages() {
		return this.numberOfMessages;
	}
	
	public void setNumberOfMessages(long numberOfMessages) {
		this.numberOfMessages = numberOfMessages;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}
	
	public void addMessage(Message message) {
		this.messages.add(message);
	}
	
	public void incrementNumberOfMessages() {
		numberOfMessages++;
	}
	
	@Override
	public String toString() {
		return "Contact Name: " + this.contactName + "\nContact Number: " + this.contactNumber + "\n";
	}

}
