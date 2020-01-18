package DronePost;

import java.util.ArrayList;
import java.util.Date;

public class Client{

	private String firstName;
	private String lastName;
	private Address address;
	private String phoneNumber; // used string because wanted to keep 0 at the beginning
	private int clientID;
	private int numOfOrders;
	private Date dateOfRegistration;
	
	private ArrayList<Order> clientOrderList = new ArrayList<Order>(0);
	Client()
	{}
	
	Client(String firstName, String lastName, Address address, String phoneNumber, int clientID, Date dateOfRegistration)
	{
		setName(firstName, lastName);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setClientID(clientID);
		setDateOfRegistration(dateOfRegistration);
		numOfOrders=0;
	}
	
	Client(String firstName, String lastName, String cityName, String streetName, int streetNum, String phoneNumber, int clientID, Date dateOfRegistration)
	{
		setName(firstName, lastName);
		setAddress(cityName, streetName, streetNum);
		setPhoneNumber(phoneNumber);
		setClientID(clientID);
		setDateOfRegistration(dateOfRegistration);
		numOfOrders=0;
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

	public void setDateOfRegistration(Date dateOfRegistration)
	{
		this.dateOfRegistration=dateOfRegistration;		
	}
	
	public void addNewOrder(Order order)
	{
		numOfOrders++;
		clientOrderList.ensureCapacity(numOfOrders);
		clientOrderList.add(order);
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
	
	public Date getDateOfRegistration()
	{
		return dateOfRegistration;
	}
	
	
}
