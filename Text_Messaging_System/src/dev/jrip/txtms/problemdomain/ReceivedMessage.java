package dev.jrip.txtms.problemdomain;

public class ReceivedMessage extends Message{
	private String receivedDate;

	public ReceivedMessage (String bodyOfMessage) {
		super(bodyOfMessage);
		generateReceivedDate();
	}
	

	public ReceivedMessage (String bodyOfMessage, int messageSerialCode) {
		super(bodyOfMessage, messageSerialCode);
	}
	
	public String getReceivedDate() {
		return receivedDate;
	}


	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}


	private void generateReceivedDate() {
		
	}
}
