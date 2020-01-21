package DronePost;

public class Drone {
	private int droneID;
	private boolean isAvailable;
	private int batteryLifePercentage;
	private Order currentOrder;
	private Client requestingClient;
	private Client destinedClient;
	private Address startingAddress;
	private Address destenationAddress;
	private Message messageType;
	
	
	Drone()
	{}
	
	Drone (int droneID, boolean isAvailable, int batteryLifePercentage, Order currentOrder, Client requestingClient, Client destinedClient, Address startingAddress, Address destenationAddress, Message messageType)
	{
		setDroneID(droneID);
		setIsAvailable(isAvailable);
		setBatteryLifePercentage(batteryLifePercentage);
		setCurrentOrder(currentOrder);
		setRequestingClient(requestingClient);
		setDestinedClient(destinedClient);
		setStartingAddress(startingAddress);
		setDestinedClient(destinedClient);
		setMessageType(messageType);
	}
	
	Drone (int droneID, boolean isAvailable, int batteryLifePercentage, Order currentOrder)
	{
		setDroneID(droneID);
		setIsAvailable(isAvailable);
		setBatteryLifePercentage(batteryLifePercentage);
		setCurrentOrder(currentOrder);
		requestingClient=currentOrder.getRequestingClient();
		destinedClient=currentOrder.getDestinedClient();
		startingAddress=requestingClient.getAddress();
		destenationAddress=destinedClient.getAddress();
	}

	Drone (int droneID)
	{
		setDroneID(droneID);
		isAvailable=true;
		batteryLifePercentage=100;
	}
	
	public void setForOrder(Order currentOrder)
	{
		isAvailable=true;
		setCurrentOrder(currentOrder);
		requestingClient=currentOrder.getRequestingClient();
		destinedClient=currentOrder.getDestinedClient();
		startingAddress=requestingClient.getAddress();
		destenationAddress=destinedClient.getAddress();
	}
	

	
	public void setDroneID(int droneID)
	{
		this.droneID=droneID;
	}
	
	public void setCurrentOrder(Order currentOrder)
	{
		this.currentOrder=currentOrder;
	}
	
	public void setIsAvailable(boolean isAvailable)
	{
		this.isAvailable=isAvailable;
	}
	
	public void setBatteryLifePercentage(int batteryLifePercentage)
	{
		this.batteryLifePercentage=batteryLifePercentage;
	}
	
	public void setRequestingClient(Client requestingClient)
	{
		this.requestingClient=requestingClient;
	}
	
	public void setDestinedClient (Client destinedClient)
	{
		this.destinedClient=destinedClient;
	}
	
	public void setStartingAddress (Address startingAddress)
	{
		this.startingAddress=startingAddress;
	}

	public void seDestenationAddress (Address destenationAddress)
	{
		this.destenationAddress=destenationAddress;
	}
	
	public void setMessageType (Message messageType)
	{
		this.messageType=messageType;
	}
	
	public int getDroneID()
	{
		return droneID;
	}
	
	public boolean getIsAvailable()
	{
		return isAvailable;
	}
	
	public Order getCurrentOrder()
	{
		return currentOrder;
	}

	public int getBatteryLifePercentage()

	{
		return batteryLifePercentage;
	}

	public Client getRequestingClient()
	{
		return requestingClient;
	}
	
	public Client getDestinedClient ()
	{
		return destinedClient;
	}
	
	public Address getStartingAddress ()
	{
		return startingAddress;
	}

	public Address getDestenationAddress ()
	{
		return destenationAddress;
	}
	
	public Message getMessageType ()
	{
		return messageType;
	}

}
