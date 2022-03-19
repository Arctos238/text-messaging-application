package dev.jrip.txtms.fileio;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import dev.jrip.txtms.problemdomain.Contact;
import dev.jrip.txtms.problemdomain.Message;

public class Client {
	private static final String FILENAME = "res/contacts.bin";

	public static void main(String[] args) throws IOException {
		// need host and port, we want to connect to the ServerSocket at port 7776
		Socket socket = new Socket("localhost", 7776);
		System.out.println("Connected!");

		// get the output stream from the socket.
		OutputStream outputStream = socket.getOutputStream();
		// create a data output stream from the output stream so we can send data
		// through it
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

		System.out.println("Sending string to the ServerSocket");

		/*
		 * // Message to send String message;
		 * 
		 * System.out.println("Enter Message to send: "); Scanner in = new
		 * Scanner(System.in); message = in.nextLine();
		 * 
		 * 
		 * // write the message we want to send dataOutputStream.writeUTF(message);
		 * dataOutputStream.flush(); // send the message dataOutputStream.close(); //
		 * close the output stream when we're done.
		 */

		FileInputStream fStream = new FileInputStream(FILENAME);
		DataInputStream inputFile = new DataInputStream(fStream);

		boolean endOfFile = false;
		
		dataOutputStream.writeInt(5);
		
		while (!endOfFile) {
			try {
				String contactName = inputFile.readUTF();
				long contactNumber = inputFile.readLong();
				long numberOfMessages = inputFile.readLong();


				dataOutputStream.writeUTF(contactName);
				dataOutputStream.writeLong(contactNumber);
				dataOutputStream.writeLong(numberOfMessages);
				readMessages(numberOfMessages, inputFile, dataOutputStream);
				
				
			} catch (IOException e) {
				endOfFile = true;
			}
		}

		dataOutputStream.flush();
		dataOutputStream.close();

		System.out.println("Closing socket and terminating program.");
		socket.close();
	}

	private static void readMessages(Long numberOfMessages, DataInputStream inputFile, DataOutputStream dataOutputStream) throws IOException {

		for (int i = 0; i < numberOfMessages; i++) {
			String bodyOfMessage = inputFile.readUTF();
			int messageSerialCode = inputFile.readInt();
			
			dataOutputStream.writeUTF(bodyOfMessage);
			
		}
	}

}
