package DronePost;

public class Message {
	private String messageContent;
	
	Message()
	{}
	
	Message(String messageContent)
	{
		setMessageContent(messageContent);
	}
	
	public void setMessageContent(String messageContent)
	{
		this.messageContent=messageContent;
	}
	
	public String getMessageContent()
	{
		return messageContent;
	}
	
}
