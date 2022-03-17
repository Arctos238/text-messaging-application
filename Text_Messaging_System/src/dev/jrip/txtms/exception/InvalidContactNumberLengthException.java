package dev.jrip.txtms.exception;


public class InvalidContactNumberLengthException extends Exception {
	
	public InvalidContactNumberLengthException(String contactNumberString) {
		super(contactNumberString + " is an incorrect phone number (Must be 10 digits long)");
	}
}
