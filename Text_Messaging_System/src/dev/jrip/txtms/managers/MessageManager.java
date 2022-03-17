package dev.jrip.txtms.managers;

import java.util.*;

import dev.jrip.txtms.problemdomain.Contact;
import dev.jrip.txtms.problemdomain.Message;

public class MessageManager {

	public void deleteMessage(ArrayList<Message> messages, Message message) {
		for (int i = 0; i < messages.size(); i++) {
			Message tempMessage = messages.get(i);

			if (tempMessage == message) {
				messages.remove(i);
			}
		}
	}

	public void addMessage(Message message, Contact contact) {
		contact.getMessages().add(message);
	}
	
	public void showAllMessages(ArrayList<Contact> contacts) {
		
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
			ArrayList<Message> allContactMessages = contact.getMessages();
		
			for (int j = 0; j < allContactMessages.size(); j++) {
				System.out.println(allContactMessages.get(j));
			}
		}
	}

}
