package DronePost;

import java.util.Date;

public class Order{

	private int orderNum;
	private Client requestingClient;
	private Client destinedClient;
	private Date dateCreated;
	
	Order()
	{}
	
	Order(int orderNum, Client requestingClient, Client destinedClient, Date dateCreated)
	{
		setOrderNum(orderNum);
		setRequestingClient(requestingClient);
		setDestinedClient(destinedClient);
		setDateCreated(dateCreated);
	}
	
	public void setOrderNum(int orderNum)
	{
		this.orderNum=orderNum;
	}
	
	public void setRequestingClient (Client requestingClient)
	{
		this.requestingClient=requestingClient;
	}
	
	public void setDestinedClient(Client destinedClient)
	{
		this.destinedClient=destinedClient;
	}
	
	public void setDateCreated (Date dateCreated)
	{
		this.dateCreated=dateCreated;
	}
	
	public int getOrderNum()
	{
		return orderNum;
	}
	
	public Client getRequestingClient()
	{
		return requestingClient;
	}
	
	public Client getDestinedClient()
	{
		return destinedClient;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	
}
