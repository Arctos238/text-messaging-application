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

	public void addContact(ArrayList<Contact> contacts) throws ContactAlreadyExistsException, InvalidContactNumberLengthException {
		String contactName = getContactName();

		int contactNumber = getContactNumber();

		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);

			if (contact.getContactName().equals(contactName) && contact.getContactNumber() == contactNumber) {
				throw new ContactAlreadyExistsException(contact);
			} else {
				Contact newContact = new Contact(contactName, contactNumber);
				contacts.add(newContact);
			}
		}
	}

	private String getContactName() {
		System.out.print("Enter the contacts name: ");
		return stringInput.nextLine();
	}

	private int getContactNumber() throws InvalidContactNumberLengthException {
		System.out.print("Enter the contacts number: ");
		int contactNumber = numberInput.nextInt();
		String contactNumberString = contactNumber + "";

		if (contactNumberString.length() == 10) {
			return contactNumber;
		} else {
			throw new InvalidContactNumberLengthException(contactNumberString);
		}

	}

	public void showAllContacts() {
		// TODO Auto-generated method stub

	}

}
