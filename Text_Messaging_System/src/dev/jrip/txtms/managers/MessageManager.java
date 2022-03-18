package dev.jrip.txtms.managers;

import java.util.*;

import dev.jrip.txtms.problemdomain.Contact;
import dev.jrip.txtms.problemdomain.Message;

public class MessageManager {
	private Scanner stringInput;
	
	public MessageManager() {
		stringInput = new Scanner(System.in);
	}
	
	public void deleteMessage(ArrayList<Message> messages, Message message) {
		for (int i = 0; i < messages.size(); i++) {
			Message tempMessage = messages.get(i);

			if (tempMessage == message) {
				messages.remove(i);
			}
		}
	}
	
	public void sendNewMessage(ArrayList<Contact> contacts) {
		Contact contact = retrieveContact(contacts);
		if (contact == null) {
			System.out.println("No Contact Found \n");
			
		} else {
			String messageBody = createMessage();
			Message message = new Message(messageBody);
			contact.addMessage(message);
			contact.incrementNumberOfMessages();
		}
	}
	
	public String createMessage() {
		System.out.print("Enter your Message:");
		String messageBody = stringInput.nextLine();
		System.out.println();
		return messageBody;
	}
	
	private Contact retrieveContact(ArrayList<Contact> contacts) {
		
		System.out.print("Enter Contact Name: ");
		String contactName = stringInput.nextLine();
		System.out.println();
		
		Contact contact = null;
		
		for(int i = 0; i < contacts.size(); i++) {
			Contact tempContact = contacts.get(i);
			
			if(tempContact.getContactName().equals(contactName)) {
				contact = tempContact;
			}
		}
		
		return contact;
	}

	public void addMessage(Message message, Contact contact) {
		contact.getMessages().add(message);
	}
	
	public void showAllMessages(ArrayList<Contact> contacts) {
		
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
			ArrayList<Message> allContactMessages = contact.getMessages();
		
			for (int j = 0; j < allContactMessages.size(); j++) {
				System.out.println(contact.getContactName() + "\n");
				System.out.println(allContactMessages.get(j));
				System.out.println();
			}
		}
	}
}
