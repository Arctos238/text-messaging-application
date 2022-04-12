package dev.jrip.txtms.managers;

import java.io.*;
import java.util.*;

import dev.jrip.txtms.problemdomain.*;
import dev.jrip.txtms.exception.*;

public class ApplicationManager {
	private static final int NUMBER_OF_MAIN_MENU_OPTIONS = 3;
	private static final int NUMBER_OF_CONTACT_MENU_OPTIONS = 5;
	private static final int NUMBER_OF_MESSAGE_MENU_OPTIONS = 3;

	Scanner numberScanner = new Scanner(System.in);
	private ArrayList<Contact> contacts;
//	private IOManager ioManager;
	private MessageManager messageManager;
	private ContactManager contactManager;

	public ApplicationManager() {
		messageManager = new MessageManager();
		contactManager = new ContactManager();
//		ioManager = new IOManager();

		contacts = new ArrayList<Contact>();
//			contacts = ioManager.populateContactsFromBinary();

		mainMenu();

//		ioManager.persistFile(contacts);
	}

	private void mainMenu() {
		int optionSelected = mainMenuOptions();

		while (optionSelected != NUMBER_OF_MAIN_MENU_OPTIONS) {

			switch (optionSelected) {
			case 1:
				contactMenu();
				break;
			case 2:
				messageMenu();
				break;
			}

			optionSelected = mainMenuOptions();
		}

	}

	private void contactMenu() {

		int optionSelected = contactOptions();

		while (optionSelected != NUMBER_OF_CONTACT_MENU_OPTIONS) {

			switch (optionSelected) {
			case 1:
				contactManager.showAllContacts(contacts);
				break;
			case 2:
				try {
					contactManager.addContact(contacts);
				} catch (ContactAlreadyExistsException e) {
					System.out.println(e.getMessage() + "\n");
				} catch (InvalidContactNumberLengthException e) {
					System.out.println(e.getMessage() + "\n");
				}
				break;
			case 3:
				contactManager.searchForContact(contacts);
				break;
			case 4:
				contactManager.deleteContact(contacts);
				break;
			}

			optionSelected = contactOptions();
		}
	}

	private int contactOptions() {
		int optionNumber = 0;
		boolean inputValid = false;
		int selection = 0;

		while (!inputValid) {
			System.out.print("Text Messaging System\nOptions Available:\n");
			System.out.printf("%-1d:%-20s%n", optionNumber += 1, "Show All Contacts");
			System.out.printf("%-1d:%-20s%n", optionNumber += 1, "Add A New Contact");
			System.out.printf("%-1d:%-20s%n", optionNumber += 1, "Search For A Contact");
			System.out.printf("%-1d:%-20s%n", optionNumber += 1, "Delete A Contact");
			System.out.printf("%-1d:%-20s%n", optionNumber += 1, "Go Back To The Previous Menu");

			System.out.print("\nEnter Your Selection: ");
			selection = numberScanner.nextInt();
			System.out.println();

			if (selection <= NUMBER_OF_CONTACT_MENU_OPTIONS) {
				inputValid = true;
			} else {
				System.out.println("\nInvalid Option\n");
				optionNumber = 0;
			}
		}

		return selection;
	}

	private void messageMenu() {

		int optionSelected = messageOptions();

		while (optionSelected != NUMBER_OF_MAIN_MENU_OPTIONS) {

			switch (optionSelected) {

			case 1:
				messageManager.showAllMessages(contacts);
				break;

			case 2:
				messageManager.sendNewMessage(contacts);
				break;
			}

			optionSelected = messageOptions();
		}

	}

	private int messageOptions() {
		int optionNumber = 0;
		boolean inputValid = false;
		int selection = 0;

		while (!inputValid) {
			System.out.print("Text Messaging System\nOptions Available:\n");
			System.out.printf("%-1d:%-20s%n", optionNumber += 1, "See The List Of All Messages");
			System.out.printf("%-1d:%-20s%n", optionNumber += 1, "Send a new message");
			System.out.printf("%-1d:%-20s%n", optionNumber += 1, "Go Back To The Previous Menu");

			System.out.print("\nEnter Your Selection: ");
			selection = numberScanner.nextInt();
			System.out.println();

			if (selection <= NUMBER_OF_MESSAGE_MENU_OPTIONS) {
				inputValid = true;
			} else {
				System.out.println("\nInvalid Option\n");
				optionNumber = 0;
			}
		}

		return selection;
	}

	private int mainMenuOptions() {
		int optionNumber = 0;
		boolean inputValid = false;
		int selection = 0;

		while (!inputValid) {
			System.out.print("Text Messaging System\nOptions Available:\n");
			System.out.printf("%-1d:%-20s%n", optionNumber += 1, "Manage Contacts");
			System.out.printf("%-1d:%-20s%n", optionNumber += 1, "Messages");
			System.out.printf("%-1d:%-20s%n", optionNumber += 1, "Quit");

			System.out.print("\nEnter Your Selection: ");
			selection = numberScanner.nextInt();
			System.out.println();

			if (selection <= NUMBER_OF_MAIN_MENU_OPTIONS) {
				inputValid = true;
			} else {
				System.out.println("\nInvalid Option\n");
				optionNumber = 0;
			}

		}

		return selection;
	}

}
