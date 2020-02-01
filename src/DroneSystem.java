
import java.util.*; 
import java.time.*;

// this class is the main class that manage the brain of the system and connects between the clients to the orders and the drones, and sets an API for the UI and the DB manager
public class DroneSystem {
	
	private int numOfDrones=5;
	// these three arrays are set to 0 to make sure that the size of these arrays is the exact size needed. in every insert to those arrays the increase their sizes with .ensureCapacity()
	public ArrayList<Client> clientList= new ArrayList<Client>(0);
	public ArrayList<Drone> droneList = new ArrayList<Drone>(0);
	public ArrayList<Order> orderList = new ArrayList<Order>(0);
	public Client currentUser;
	
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
	
	public Client registerNewUser(String firstName, String lastName, String cityName, String streetName, int streetNum, String phoneNumber, eSubscriptionType subscriptionType) {	
		currentUser = addClient(firstName, lastName, cityName, streetName, streetNum, phoneNumber,subscriptionType);
		return currentUser;
	}

	
	public Client addClient (String firstName, String lastName, String cityName, String streetName, int streetNum, String phoneNumber, eSubscriptionType subscriptionType)
	{
		clientList.ensureCapacity(clientList.size()+1);
		Client currentClient = new Client(firstName, lastName, cityName, streetName, streetNum, phoneNumber, clientList.size(), subscriptionType);
		clientList.add(currentClient);
		System.out.println("Client added successfuly. Client details:\n"+ currentClient.clientToString());
		return currentClient;
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
	
	public boolean subscriptionStatus (Client currentClient)
	{
		Period period = Period.between(currentClient.getDateOfPayment(), LocalDate.now());//being calculated for monthly subscriptions
		if (currentClient.getNumOfShipmentsLeft()==0 ||  (currentClient.getSubscriptionType()==eSubscriptionType.MONTHLY && period.getMonths()>1))//checks if subscription is suppose to end
		{
			currentClient.setSubscriptionType(null);
			currentClient.setNumOfShipmentsLeft(0);
			return false;
		}
		if (currentClient.getSubscriptionType()==eSubscriptionType.MONTHLY && period.getDays()<=30)//verifies that monthly subscription won't end before time  
		{
			currentClient.setNumOfShipmentsLeft(1000);
			return true;
		}
		return true;
	}
	
	public void newSubscription (Client currentClient, eSubscriptionType newSubscriptionType)
	{
		currentClient.setSubscriptionType(newSubscriptionType);
	}
	
	public String addOrder (int requestingClientID, int destinedClientID)
	{
		Client requestingClient = clientList.get(requestingClientID);
		Client destinedClient = clientList.get(destinedClientID);
		if (subscriptionStatus(requestingClient)==false)
		{
			return "can not make new order, the client needs to choose new subscription type and set the order again";
		}
		Drone currentDrone=findAvailableDrone();
		if (currentDrone==null)
		{
			System.out.println("no available drone. please try again later");
			return "no available drone. please try again later";
		}
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
	
	public Client logIn(String fullName, String Id) {
		 try {  	 
			Client client = getClientByID(Integer.parseInt(Id));
			System.out.println(client.getName() +"==" + fullName);
			if(client.getName().trim().equals(fullName)) {
				currentUser = client;
				return currentUser;
			
			}
			return null;
		 }catch(NumberFormatException e) {
			 return null; 
		 }
	}
	
	private  Client getClientByID(int id) {
		for( int i = 0; i< clientList.size() ; i++) {
			Client client = clientList.get(i);
			if(client.getClientID() == id) {
				return client;
			 }		  
		  }
		  return null;
	  }
	public void sendingMessageBetweenClients (Client requestingClient, Client destinedClient, String messageContent)
	{
		Message messageRequested = new Message (requestingClient.getPhoneNum(), destinedClient.getPhoneNum(), messageContent);
	}
	

}
