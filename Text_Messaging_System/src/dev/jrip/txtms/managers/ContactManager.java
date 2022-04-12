package dev.jrip.txtms.managers;

import java.util.*;

import dev.jrip.txtms.exception.*;
import dev.jrip.txtms.problemdomain.*;

public class ContactManager {
	private Scanner numberInput;
	private Scanner stringInput;

	public ContactManager() {
		numberInput = new Scanner(System.in);
		stringInput = new Scanner(System.in);
	}

	public void addContact(ArrayList<Contact> contacts)
			throws ContactAlreadyExistsException, InvalidContactNumberLengthException {
		String contactName = getContactName();

		long contactNumber = getContactNumber();

		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);

			if (contact.getContactName().equals(contactName) && contact.getContactNumber() == contactNumber) {
				throw new ContactAlreadyExistsException(contact);
			}
		}

		Contact newContact = new Contact(contactName, contactNumber);
		contacts.add(newContact);

		System.out.println();

	}

	private String getContactName() {
		System.out.print("Enter the contacts name: ");
		return stringInput.nextLine();
	}

	private long getContactNumber() throws InvalidContactNumberLengthException {
		System.out.print("Enter the contacts number: ");
		long contactNumber = numberInput.nextLong();
		String contactNumberString = contactNumber + "";

		if (contactNumberString.length() == 10) {
			return contactNumber;
		} else {
			throw new InvalidContactNumberLengthException(contactNumberString);
		}

	}

	public void showAllContacts(ArrayList<Contact> contacts) {
		if (contacts == null) {
			System.out.println("You have no contacts\n");
		} else {
			for (int i = 0; i < contacts.size(); i++) {
				System.out.println(contacts.get(i));
			}
		}
	}

	public void searchForContact(ArrayList<Contact> contacts) {
		Contact contact = retrieveContact(contacts);

		if (contact == null) {
			System.out.println("\nNo Contact Found with That Name\n");
		} else {
			System.out.println(contact + "\n");
		}

	}

	public void deleteContact(ArrayList<Contact> contacts) {
		Contact contact = retrieveContact(contacts);

		if (contact == null) {
			System.out.println("\nNo Contact Found with That Name\n");
		} else {
			System.out.println(contact + "\nHas been Deleted\n");
		}

	}

	private Contact retrieveContact(ArrayList<Contact> contacts) {
		System.out.print("Enter Contact Name: ");
		String contactName = stringInput.nextLine();
		System.out.println();

		Contact contact = null;

		for (int i = 0; i < contacts.size(); i++) {
			Contact tempContact = contacts.get(i);

			if (tempContact.getContactName().equals(contactName)) {
				contact = tempContact;
			}
		}

		return contact;
	}
}
