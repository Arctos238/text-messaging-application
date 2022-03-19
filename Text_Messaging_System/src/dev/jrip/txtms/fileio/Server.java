package dev.jrip.txtms.fileio;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // don't need to specify a hostname, it will be the current machine
        ServerSocket ss = new ServerSocket(7776);
        System.out.println("ServerSocket awaiting connections...");
        Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
        System.out.println("Connection from " + socket + "!");

        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        // read the message from the socket
        int numberOfContacts = dataInputStream.readInt();
        
        for(int i = 0; i < numberOfContacts; i++) {
        	System.out.println(dataInputStream.readUTF());
           	System.out.println(dataInputStream.readLong());
           	long numberOfMessages = dataInputStream.readLong();
           	
           	if (numberOfMessages != 0) {
           		for (int j = 0; j < numberOfMessages; j++) {
           			System.out.println(dataInputStream.readUTF());
           		}
           	}
           	
        }

        System.out.println("Closing sockets.");
        ss.close();
        socket.close();
    }
}

//Server Output
/*
ServerSocket awaiting connections...
Connection from Socket[addr=/127.0.0.1,port=62085,localport=7777]!
The message sent from the socket was: Hello from the other side!
Closing sockets.
*/

// Client Output
/*
Connected!
Sending string to the ServerSocket
Closing socket and terminating program.
*/