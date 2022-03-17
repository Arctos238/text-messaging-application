package dev.jrip.txtms.exception;

import dev.jrip.txtms.problemdomain.Contact;

public class ContactAlreadyExistsException extends Exception {
	public ContactAlreadyExistsException(Contact e) {
		super(e + " already exists");
	}
}
