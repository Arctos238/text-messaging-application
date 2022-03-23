//package dev.jrip.txtms.managers;
//
//import java.io.*;
//import java.util.*;
//
//import dev.jrip.txtms.problemdomain.*;
//
//public class IOManager {
//	private static final String FILENAME = "res/contacts.bin";
//
//	public ArrayList<Contact> populateContactsFromBinary() throws FileNotFoundException {
//		ArrayList<Contact> contacts = null;
//		FileInputStream fStream = new FileInputStream(FILENAME);
//		DataInputStream inputFile = new DataInputStream(fStream);
//		contacts = new ArrayList<>();
//		boolean endOfFile = false;
//
//		while (!endOfFile) {
//			try {
//				String contactName = inputFile.readUTF();
//				long contactNumber = inputFile.readLong();
//				long numberOfMessages = inputFile.readLong();
//
//				ArrayList<Message> messages;
//				Contact contact;
//
//				if (numberOfMessages == 0) {
//					messages = new ArrayList<>();
//				} else {
//					messages = readMessages(numberOfMessages, inputFile);
//				}
//
//				contact = new Contact(contactName, contactNumber, numberOfMessages, messages);
//				contacts.add(contact);
//			} catch (IOException e) {
//				endOfFile = true;
//			}
//		}
//
//		return contacts;
//	}
//
//	private ArrayList<Message> readMessages(Long numberOfMessages, DataInputStream inputFile) throws IOException {
//		ArrayList<Message> messages = new ArrayList<>();
//
//		for (int i = 0; i < numberOfMessages; i++) {
//			String bodyOfMessage = inputFile.readUTF();
//			int messageSerialCode = inputFile.readInt();
//
//			Message message = new Message(bodyOfMessage, messageSerialCode);
//
//			messages.add(message);
//		}
//
//		return messages;
//	}
//
//	public void persistFile(ArrayList<Contact> contacts) {
//
//		try {
//			FileOutputStream fStream = new FileOutputStream(FILENAME);
//			DataOutputStream outputFile = new DataOutputStream(fStream);
//			for (int i = 0; i < contacts.size(); i++) {
//				writeContact(contacts.get(i), outputFile);
//			}
//		} catch (IOException e) {
//			System.out.println("Contact Did Not Get Written");
//		}
//	}
//
//	public void writeContact(Contact contact, DataOutputStream outputFile) throws IOException {
//
//		outputFile.writeUTF(contact.getContactName());
//		outputFile.writeLong(contact.getContactNumber());
//
//		long numberOfMessages = contact.getNumberOfMessages();
//		outputFile.writeLong(numberOfMessages);
//
//		if (numberOfMessages != 0) {
//			writeMessages(contact.getMessages(), numberOfMessages, outputFile);
//		}
//	}
//
//	public void writeMessages(ArrayList<Message> messages, long numberOfMessages, DataOutputStream outputFile)
//			throws IOException {
//		for (int i = 0; i < numberOfMessages; i++) {
//			Message message = messages.get(i);
//
//			outputFile.writeUTF(message.getBodyOfMessage());
//			outputFile.writeInt(message.getMessageSerialCode());
//		}
//	}
//}
