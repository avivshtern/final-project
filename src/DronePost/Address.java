package DronePost;

public class Address {

	private String cityName;
	private String streetName;
	private int streetNum;
	
	Address()
	{}
	
	Address (String cityName, String streetName, int streetNum)
	{
		setCityName(cityName);
		setStreetName(streetName);
		setStreetNum(streetNum);
	}
	
	public void setCityName(String cityName)
	{
		this.cityName=cityName;
	}
	
	public void setStreetName(String streetName)
	{
		this.streetName=streetName;
	}
	
	public void setStreetNum(int streetNum)
	{
		this.streetNum=streetNum;
	}
	
	public String getCityName()
	{
		return cityName;
	}
	
	public String getStreetName()
	{
		return streetName;
	}
	
	public int getStreetNum()
	{
		return streetNum;
	}
}
