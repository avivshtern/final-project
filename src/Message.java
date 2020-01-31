

public class Message {
	private String messageContent;
	private String phoneNumRequestingClient;
	private String phoneNumDestinedClient;
	
	Message()
	{}
	
	Message(String phoneNumRequestingClient, String phoneNumDestinedClient, String messageContent)
	{
		setMessageContent(messageContent);
		setPhoneNumDestinedClient(phoneNumDestinedClient);
		setPhoneNumRequestingClient(phoneNumRequestingClient);
		System.out.println("sending message from:" + phoneNumRequestingClient + ", to:" + phoneNumDestinedClient + "\n message content:" + messageContent + "\n message sent successfuly"); 
	}
	
	Message(String phoneNumRequestingClient, String messageContent)
	{
		setMessageContent(messageContent);
		setPhoneNumRequestingClient(phoneNumRequestingClient);
		System.out.println("sending message from: Drone System, to:" + phoneNumRequestingClient + "\n message content:" + messageContent + "\n message sent successfuly"); 
	}
	
	public void setMessageContent(String messageContent)
	{
		this.messageContent=messageContent;
	}
	
	public void setPhoneNumRequestingClient(String phoneNumRequestingClient)
	{
		this.phoneNumRequestingClient=phoneNumRequestingClient;
	}
	
	public void setPhoneNumDestinedClient(String phoneNumDestinedClient)
	{
		this.phoneNumDestinedClient=phoneNumDestinedClient;
	}
	
	public String getMessageContent()
	{
		return messageContent;
	}
	
	public String getPhoneNumDestinedClient()
	{
		return phoneNumDestinedClient;
	}
	
	public String getPhoneNumRequestingClient()
	{
		return phoneNumRequestingClient;
	}
	
}
