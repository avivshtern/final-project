package DronePost;

public class Client{

	private String firstName;
	private String lastName;
	private Address address;
	private String phoneNumber; // used string because wanted to keep 0 at the beginning
	
	Client()
	{}
	
	Client(String firstName, String lastName, Address address, String phoneNumber)
	{
		setName(firstName, lastName);
		setAddress(address);
		setPhoneNumber(phoneNumber);
	}
	
	Client(String firstName, String lastName, String cityName, String streetName, int streetNum, String phoneNumber)
	{
		setName(firstName, lastName);
		setAddress(cityName, streetName, streetNum);
		setPhoneNumber(phoneNumber);
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
	
	public boolean setPhoneNumber(String phoneNumber)
	{
		if (phoneNumber.length()>10)
		{
			return false;
		}
		this.phoneNumber=phoneNumber;
		return true;
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
}
