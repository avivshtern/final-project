

public class Drone {
	
	private static final int ARRIVING_TO_REQUESTING_CLIENT_TIME_IN_MS = 5000;	
	private static final int ARRIVING_TO_DESTINED_CLIENT_TIME_IN_MS = 10000;
	private static final int MAX_FLIGHT_TIME_IN_HOURS = 3;
	
	private int droneID;
	private boolean isAvailable;
	private int batteryLifePercentage;
	private Order currentOrder;
	private Client requestingClient;
	private Client destinedClient;
	private Address startingAddress;
	private Address destenationAddress;
	
	Drone()
	{}

	Drone (int droneID)
	{
		setDroneID(droneID);
		isAvailable=true;
		batteryLifePercentage=100;
		System.out.println("Drone added successfuly. Drone ID:\n"+ droneID);
	}
	
	public void setForMission(Order currentOrder)
	{
		setCurrentOrder(currentOrder);
		requestingClient=currentOrder.getRequestingClient();
		destinedClient=currentOrder.getDestinedClient();
		startingAddress=requestingClient.getAddress();
		destenationAddress=destinedClient.getAddress();
		isAvailable=false;
		System.out.println("Drone is ready for mission, from " + requestingClient.getName() + ", at the address "+ startingAddress.addressToString()+ "\nto " + destinedClient.getName() + ", at the address "+ destenationAddress.addressToString());
		//arriving to requesting client
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	Message arrivalMessage = new Message(requestingClient.getPhoneNum(), "Drone is here to pick up the package from " + requestingClient.getName() + ", at the address "+ startingAddress.addressToString()+ "\nto " + destinedClient.getName() + ", at the address "+ destenationAddress.addressToString());
		            }
		        }, 
		        ARRIVING_TO_REQUESTING_CLIENT_TIME_IN_MS 
		);
		//arriving to destined client  
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	Message arrivalMessage = new Message(requestingClient.getPhoneNum(), "Package arrived successfuly to " + destinedClient.getName() + ", at the address "+ destenationAddress.addressToString());
		            	Message destinedClientMessage = new Message (destinedClient.getPhoneNum(), "Package arrived to you from "+requestingClient.getName());
		            	isAvailable=true;
		                batteryLifePercentage = batteryLifePercentage-(ARRIVING_TO_DESTINED_CLIENT_TIME_IN_MS+ARRIVING_TO_REQUESTING_CLIENT_TIME_IN_MS)/(MAX_FLIGHT_TIME_IN_HOURS*60*60*100);
		                if (batteryLifePercentage<=0)
		                {
		                	batteryLifePercentage=100;//simulates charging
		                }
		            }
		        }, 
		        ARRIVING_TO_DESTINED_CLIENT_TIME_IN_MS 
		);
		
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

}
