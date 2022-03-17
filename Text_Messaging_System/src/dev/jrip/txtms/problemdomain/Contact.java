package dev.jrip.txtms.problemdomain;

import java.util.*;

public class Contact {
	private String contactName;
	private int contactNumber;
	private ArrayList<Message> messages;

	public Contact(String contactName, int contactNumber, ArrayList<Message> messages) {
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.messages = messages;
	}

	public Contact(String contactName, int contactNumber) {
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.messages = new ArrayList<Message>();
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}
	
	@Override
	public String toString() {
		return "Contact Name: " + this.contactName + "/n Contact Number: " + this.contactNumber;
	}

}
