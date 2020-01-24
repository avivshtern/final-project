package DronePost;
import java.util.*;
public class DroneSystem {

private int numOfClients;
private int numOfOrders;
private int numOfDrones=100;
private ArrayList<Client> clientList= new ArrayList<Client>(0);
private ArrayList<Drone> droneList = new ArrayList<Drone>(numOfDrones);
private ArrayList<Order> orderList = new ArrayList<Order>(0);

public void addClient (String firstName, String lastName, String cityName, String streetName, int streetNum, String phoneNumber, eSubscriptionType subscriptionType)
{
	numOfClients++;
	Date currentDate=new Date();
	Client currentClient = new Client(firstName, lastName, cityName, streetName, streetNum, phoneNumber, numOfClients, currentDate, subscriptionType);
	clientList.ensureCapacity(numOfClients);
	clientList.add(currentClient);
}

private Drone findAvailableDrone()
{
	for (int i=0; i<numOfDrones; i++)
	{
		Drone currentDrone=droneList.get(i);
		if (currentDrone.getIsAvailable()==true)
		{
			return currentDrone;
		}
	}
	return null;
}

public void addOrder (int orderNum, Client requestingClient, Client destinedClient, Date dateCreated)
{
	numOfOrders++;
	Date currentDate=new Date();
	Drone currentDrone=findAvailableDrone();
	Order currentOrder = new Order(numOfOrders, requestingClient, destinedClient, currentDate, currentDrone);
	orderList.ensureCapacity(numOfClients);
	orderList.add(currentOrder);
	currentDrone.setCurrentOrder(currentOrder);
	requestingClient.addNewOrder(currentOrder);
	
}



}
