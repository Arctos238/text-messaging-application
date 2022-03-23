package dev.jrip.txtms.problemdomain;

public class SentMessage extends Message{
	private String sentDate;
	
	public SentMessage(String bodyOfMessage) {
		super(bodyOfMessage);
		generateSentDate();
	}

	public SentMessage (String bodyOfMessage, int messageSerialCode, String sentDate) {
		super(bodyOfMessage, messageSerialCode);
	}

	public String getSentDate() {
		return sentDate;
	}

	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}
	
	private void generateSentDate() {
		// TODO Auto-generated method stub
		
	}
	
}
