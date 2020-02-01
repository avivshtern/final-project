
import java.util.*;
import java.time.*;
public class DroneSystem {
	
	private int numOfDrones=5;
	public ArrayList<Client> clientList= new ArrayList<Client>(0);
	public ArrayList<Drone> droneList = new ArrayList<Drone>(0);
	public ArrayList<Order> orderList = new ArrayList<Order>(0);
	
	DroneSystem()
	{
		for (int i=0; i<numOfDrones; i++)
		{
			Drone createdDrone=new Drone(i);
			droneList.ensureCapacity(i+1);
			droneList.add(createdDrone);
		}
		
		System.out.println("system is ready");
	}

	public Client addClient (String firstName, String lastName, String cityName, String streetName, int streetNum, String phoneNumber, eSubscriptionType subscriptionType)
	{
		clientList.ensureCapacity(clientList.size()+1);
		Client currentClient = new Client(firstName, lastName, cityName, streetName, streetNum, phoneNumber, clientList.size(), subscriptionType);
		clientList.add(currentClient);
		System.out.println("Client added successfuly. Client details:\n"+ currentClient.clientToString());
		return currentClient;
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
	
	public String addOrder (int requestingClientID, int destinedClientID)
	{
		Client requestingClient = clientList.get(requestingClientID);
		Client destinedClient = clientList.get(destinedClientID);
		if (requestingClient.getNumOfShipmentsLeft()==0)
		{
			Period period = Period.between(LocalDate.now(), requestingClient.getDateOfPayment());
				if (requestingClient.getSubscriptionType()!=eSubscriptionType.MONTHLY || (requestingClient.getSubscriptionType()==eSubscriptionType.MONTHLY && period.getDays()>=30)) 
				{
					String message = "can not make new order, the client needs to choose new subscription type and set the order again";
					System.out.println(message);
					return message;
				}
				if (requestingClient.getSubscriptionType()==eSubscriptionType.MONTHLY && period.getDays()<=30)
				{
					requestingClient.setNumOfShipmentsLeft(1000);
				}
		}
		Drone currentDrone=findAvailableDrone();
		orderList.ensureCapacity(orderList.size()+1);
		Order currentOrder = new Order(orderList.size(), requestingClient, destinedClient, currentDrone);
		orderList.add(currentOrder);
		currentDrone.setForMission(currentOrder);
		requestingClient.addNewOrder(currentOrder);
		
		String message = "Order added successfuly. Order details:\n from: " + currentDrone.getRequestingClient().getName() + ", "+ currentDrone.getRequestingClient().getAddress() +
				"\n to: " + currentOrder.getDestinedClient().getName() + ", " + currentOrder.getDestinedClient().getAddress();
		System.out.println(message);
		return message;
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
	
	public ArrayList<Client> getClientsList() 
	{
		return clientList;
	}
	
	public void sendingMessageBetweenClients (Client requestingClient, Client destinedClient, String messageContent)
	{
		Message messageRequested = new Message (requestingClient.getPhoneNum(), destinedClient.getPhoneNum(), messageContent);
	}
}
