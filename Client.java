package DronePost;

import java.util.ArrayList;
import java.util.Date;

public class Client{
	
	//private static final int MONTH_IN_MS = 2592000000; // if a true month wanted, should be 2592000000
	private static final int MONTH_IN_MS = 259200000; // asaf - bug with long type
	
	private String firstName;
	private String lastName;
	private Address address;
	private String phoneNumber; // used string to keep 0 at the beginning
	private int clientID;
	//private static eSubscriptionType subscriptionType;
	private eSubscriptionType subscriptionType; // Asaf i think every client has different subscriptionType
	private int numOfShipmentsLeft;
	//private Date dateOfRegistration;
	private java.sql.Date dateOfRegistration;
	
	private ArrayList<Order> clientOrderList = new ArrayList<Order>(0);
	
	Client()
	{}
	
	Client(String firstName, String lastName, String cityName, String streetName, int streetNum, String phoneNumber, int clientID, java.sql.Date dateOfRegistration, eSubscriptionType subscriptionType)
	{
		setName(firstName, lastName);
		setAddress(cityName, streetName, streetNum);
		setPhoneNumber(phoneNumber);
		setClientID(clientID);
		setDateOfRegistration(dateOfRegistration);
		setSubscriptionType(subscriptionType);
		System.out.println("Client set successfuly. Client details:\n"+clientToString());
	}
	
	public String clientToString ()
	{
		return ("Client name: "+ firstName + " "+lastName+"\nClient Address: "+ address.addressToString() + "\nClient phone nubmber: "+phoneNumber+"\nClient ID: "+ clientID+ "\nClient date of registration:" + dateOfRegistration + "\nClient orders left: "+numOfShipmentsLeft);
	}
	
	public void setSubscriptionType (eSubscriptionType subscriptionType)
	{
		this.subscriptionType=subscriptionType;
		if (subscriptionType==eSubscriptionType.BIG_PACKAGE)
		{
			numOfShipmentsLeft=150;
		}
		if (subscriptionType==eSubscriptionType.SMALL_PACKAGE)
		{
			numOfShipmentsLeft=50;
		}
		if (subscriptionType==eSubscriptionType.MONTHLY)
		{
			numOfShipmentsLeft=10000;
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	numOfShipmentsLeft=0;
			            }
			        }, 
			        MONTH_IN_MS 
			);
		}
	}
	
	public void addNewOrder(Order order)
	{
		clientOrderList.ensureCapacity(clientOrderList.size()+1);
		clientOrderList.add(order);
		numOfShipmentsLeft--;
	}	
	
	public void setFirstName(String firstName)
	{
		this.firstName=firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	
	public void setName(String firstName, String lastName)
	{
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public void setAddress(Address address)
	{
		this.address=address;
	}
	
	public void setAddress(String cityName, String streetName, int streetNum)
	{
		this.address=new Address (cityName, streetName, streetNum);
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber=phoneNumber;
	}
	
	public void setClientID (int clientID)
	{
		this.clientID=clientID;
	}

	public void setDateOfRegistration(java.sql.Date dateOfRegistration)
	{
		this.dateOfRegistration=dateOfRegistration;		
	}
	
	public String getName()
	{
		return (firstName+' '+lastName);
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public Address getAddress()
	{
		return address;
	}
	
	public String getPhoneNum()
	{
		return phoneNumber;
	}
	
	public int getClientID()
	{
		return clientID;
	}
	
	public java.sql.Date getDateOfRegistration()
	{
		return dateOfRegistration;
	}
	
	//public Date getDateOfRegistration()
	//{
	//	return dateOfRegistration;
	//}
	
	public eSubscriptionType getSubscriptionType()
	{
		return subscriptionType;
	}
	
	public int getNumOfShipmentsLeft()
	{
		return numOfShipmentsLeft;
	}
	
}
