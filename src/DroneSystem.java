
import java.util.*;
import java.time.*;

// this class is the main class that manage the brain of the system and connects between the clients to the orders and the drones, and sets an API for the UI and the DB manager
public class DroneSystem {
	
	private int numOfDrones=5;
	// these three arrays are set to 0 to make sure that the size of these arrays is the exact size needed. in every insert to those arrays the increase their sizes with .ensureCapacity()
	public ArrayList<Client> clientList= new ArrayList<Client>(0);
	public ArrayList<Drone> droneList = new ArrayList<Drone>(0);
	public ArrayList<Order> orderList = new ArrayList<Order>(0);
	
	DroneSystem()
	{
		//initiates the drones
		for (int i=0; i<numOfDrones; i++)
		{
			Drone createdDrone=new Drone(i);
			droneList.ensureCapacity(i+1); 
			droneList.add(createdDrone);
		}
		
		System.out.println("system is ready");
	}

	public int addClient (String firstName, String lastName, String cityName, String streetName, int streetNum, String phoneNumber, eSubscriptionType subscriptionType)// creates a client and adds it to clientArray
	{
		clientList.ensureCapacity(clientList.size()+1);
		Client currentClient = new Client(firstName, lastName, cityName, streetName, streetNum, phoneNumber, clientList.size(), subscriptionType);
		clientList.add(currentClient);
		System.out.println("Client added successfuly. Client details:\n"+ currentClient.clientToString());
		return currentClient.getClientID();//returns it for the UI 
	}
	
	private Drone findAvailableDrone()//looking for an available drone from droneList. if not found, returns null
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
		return null;
	}
	
	public void addOrder (int requestingClientID, int destinedClientID)//creates new order 
	{
		Client requestingClient = clientList.get(requestingClientID);
		Client destinedClient = clientList.get(destinedClientID);
		Period period = Period.between(requestingClient.getDateOfPayment(), LocalDate.now());//being calculated for monthly subscriptions
		if (requestingClient.getNumOfShipmentsLeft()==0 ||  (requestingClient.getSubscriptionType()==eSubscriptionType.MONTHLY && period.getMonths()>1))//checks if subscription is suppose to end
		{
			requestingClient.setSubscriptionType(null);
			requestingClient.setNumOfShipmentsLeft(0);
			System.out.println("can not make new order, the client needs to choose new subscription type and set the order again");
			return;
		}
		if (requestingClient.getSubscriptionType()==eSubscriptionType.MONTHLY && period.getDays()<=30)//verifies that monthly subscription won't end before time  
		{
			requestingClient.setNumOfShipmentsLeft(1000);
		}
		Drone currentDrone=findAvailableDrone();
		if (currentDrone==null)
		{
			System.out.println("no available drone. please try again later");
			return;
		}
		orderList.ensureCapacity(orderList.size()+1);
		Order currentOrder = new Order(orderList.size(), requestingClient, destinedClient, currentDrone);
		orderList.add(currentOrder);
		currentDrone.setForMission(currentOrder);
		requestingClient.addNewOrder(currentOrder);
		System.out.println("Order added successfuly. Order details:\n"+ currentOrder.orderToString());
	}
	
	public ArrayList getClientIDList ()
	{
		ArrayList<Integer> clientIDList= new ArrayList<Integer>(clientList.size());
		for (int i=0; i<clientList.size(); i++)
		{
			clientIDList.add(i);//every client ID is in order from 0 to num of clients (represented ad clientList.size())
		}
		return clientIDList;
	}
	
	public void sendingMessageBetweenClients (int requestingClientID, int destinedClientID, String messageContent)
	{
		Client requestingClient = clientList.get(requestingClientID);
		Client destinedClient = clientList.get(destinedClientID);
		Message messageRequested = new Message (requestingClient.getPhoneNum(), destinedClient.getPhoneNum(), messageContent);
	}
	

}
