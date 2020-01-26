package DronePost;

import java.util.Date;

public class Order{

	private int orderNum;
	private Client requestingClient;
	private Client destinedClient;
	private java.sql.Date dateCreated;
	private Drone missionDrone;
	
	Order()
	{}
	
	Order(int orderNum, Client requestingClient, Client destinedClient, java.sql.Date dateCreated, Drone missionDrone)
	{
		setOrderNum(orderNum);
		setRequestingClient(requestingClient);
		setDestinedClient(destinedClient);
		setDateCreated(dateCreated);
		setMissionDrone(missionDrone);
		System.out.println("Order set successfuly. Order details:\n"+orderToString());
	}
	
	public String orderToString()
	{
		return ("Order Number: "+ orderNum+"\nRequesting client: "+requestingClient.clientToString()+ "\nDestined client: "+destinedClient.clientToString()+"\nDate created:"+ dateCreated+"/nDrone ID:"+ missionDrone.getDroneID());
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
	
	public void setDateCreated (java.sql.Date dateCreated)
	{
		this.dateCreated=dateCreated;
	}
	
	public void setMissionDrone (Drone missionDrone)
	{
		this.missionDrone=missionDrone;
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
	
	public java.sql.Date getDateCreated()
	{
		return dateCreated;
	}
	
	public Drone getMissionDrone()
	{
		return missionDrone;
	}
	
}
