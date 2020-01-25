package DronePost;
import java.util.*;
public class DroneSystem {
	
	private int numOfDrones=5;
	private ArrayList<Client> clientList= new ArrayList<Client>(0);
	private ArrayList<Drone> droneList = new ArrayList<Drone>(numOfDrones);
	private ArrayList<Order> orderList = new ArrayList<Order>(0);
	
	DroneSystem()
	{
		for (int i=0; i>numOfDrones; i++)
		{
			Drone createdDrone=new Drone(i);
		}
		
		System.out.println("system is ready");
	}

	public void addClient (String firstName, String lastName, String cityName, String streetName, int streetNum, String phoneNumber, eSubscriptionType subscriptionType)
	{
		Date currentDate=new Date();
		clientList.ensureCapacity(clientList.size()+1);
		Client currentClient = new Client(firstName, lastName, cityName, streetName, streetNum, phoneNumber, clientList.size(), currentDate, subscriptionType);
		clientList.add(currentClient);
		System.out.println("Client added successfuly. Client details:\n"+ currentClient.clientToString());
	}
	
	private Drone findAvailableDrone()
	{
		for (int i=0; i<numOfDrones; i++)
		{
			Drone currentDrone=droneList.get(i);
			if (currentDrone.getIsAvailable()==true)
			{
				System.out.println("Available drone found, drone num: "+ currentDrone.getDroneID()+"\n battery left:"+ currentDrone.getBatteryLifePercentage()+"%");
				return currentDrone;
			}
		}
		System.out.println("There is no available drone right now, please wait as we find you an available drone");
		return findAvailableDrone(); // will look for an available drone until found one
	}
	
	public void addOrder (int orderNum, Client requestingClient, Client destinedClient, Date dateCreated)
	{
		if (requestingClient.getNumOfShipmentsLeft()==0)
		{
			System.out.println("can not make new order, the client needs to choose new subscription type and set the order again"); 	
			return;
		}
		Date currentDate=new Date();
		Drone currentDrone=findAvailableDrone();
		orderList.ensureCapacity(orderList.size()+1);
		Order currentOrder = new Order(orderList.size(), requestingClient, destinedClient, currentDate, currentDrone);
		orderList.add(currentOrder);
		currentDrone.setCurrentOrder(currentOrder);
		requestingClient.addNewOrder(currentOrder);
		System.out.println("Order added successfuly. Order details:\n"+ currentOrder.orderToString());
	}
	
	public void sendingMessageBetweenClients (Client requestingClient, Client destinedClient, String messageContent)
	{
		Message messageRequested = new Message (requestingClient.getPhoneNum(), destinedClient.getPhoneNum(), messageContent);
	}
}
