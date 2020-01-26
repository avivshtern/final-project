package DronePost;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
	
public class DataBaseManager
{

	public static Connection conn;

	public static Connection getConn(String dbName) throws ClassNotFoundException {
	try{
		//dbName="final_project_db_1"; // TODO asaf erase after finish
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,"root","");
		System.out.println("Connected...");
		return conn;
	}
	catch(SQLException e){
		System.out.println(e);
	return null;
	}
}
	
	public void addClientIntoDb (Client client)
	{
		try {
		Connection connSubscriberDb;
		connSubscriberDb=getConn("final_project_db_1");
		int clientID=client.getClientID();
		String firstName=client.getFirstName();
		String lastName=client.getLastName();
		String phoneNumber=client.getPhoneNum();
		eSubscriptionType subscriptionType=client.getSubscriptionType();
		int numOfShipmentsLeft=client.getNumOfShipmentsLeft();
		Date dateOfRegistration=client.getDateOfRegistration();

		String query = " insert into clients (clientID, firstName, lastName, phoneNumber, subscriptionType, numOfShipmentsLeft, dateOfRegistration)" + " values (?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt = connSubscriberDb.prepareStatement(query);
		preparedStmt.setInt (1, clientID);
		preparedStmt.setString (2, firstName);
		preparedStmt.setString (3, lastName);
		preparedStmt.setString (4, phoneNumber);
		preparedStmt.setInt (5, subscriptionType.ordinal());
		preparedStmt.setInt (6, numOfShipmentsLeft);
		preparedStmt.setDate (7, dateOfRegistration);
		preparedStmt.execute();
		
		String cityName=client.getAddress().getCityName();
		String streetName=client.getAddress().getStreetName();
		int streetNumber=client.getAddress().getStreetNum();
		
		
		query = " insert into address (clientID_fk, cityName, streetName, streetNum)" + " values (?,?,?,?)";
		preparedStmt = connSubscriberDb.prepareStatement(query);
		preparedStmt.setInt (1, clientID);
		preparedStmt.setString (2, cityName);
		preparedStmt.setString (3, streetName);
		preparedStmt.setInt (4, streetNumber);
		preparedStmt.execute();
		
		//connSubscriberDb.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
		System.out.println("addClientInDb");
	}
	
	public ResultSet getClientsDetail()
	{
		try {
			String query,firstName,lastName,password;
			Connection conn;
			Statement stmt;
			ResultSet rs;
			conn = getConn("subscribers_db");
			query ="SELECT * from subscribers";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			return rs;
		
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
		
	}
	
	public void addDroneIntoDb (Drone drone)
	{
		try {
		Connection connSubscriberDb;
		connSubscriberDb=getConn("final_project_db_1");
		
		int droneID=drone.getDroneID();
		boolean isAvailable=drone.getIsAvailable();
		int batteryLifePercentage=drone.getBatteryLifePercentage();

		String query = " insert into drones (droneID, isAvailable, batteryLifePercentage)" + " values (?,?,?)";
		PreparedStatement preparedStmt = connSubscriberDb.prepareStatement(query);
		preparedStmt.setInt (1, droneID);
		preparedStmt.setBoolean (2, isAvailable);
		preparedStmt.setInt (3, batteryLifePercentage);
		preparedStmt.execute();
	
		
		//connSubscriberDb.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void addOrderIntoDb (Order order)
	{
		try {
		Connection connSubscriberDb;
		connSubscriberDb=getConn("final_project_db_1");
		
		int orderNum=order.getOrderNum();
		int requestingClient=order.getRequestingClient().getClientID();
		int destinedClient=order.getDestinedClient().getClientID();
		int missionDrone=order.getMissionDrone().getDroneID();
		java.sql.Date dateCreated=order.getDateCreated();
		
		String query = " insert into orders (orderNum, requestingClient_fk, destinedClient_fk, missionDrone_fk, dateCreated)" + " values (?,?,?,?,?)";
		PreparedStatement preparedStmt = connSubscriberDb.prepareStatement(query);
		preparedStmt.setInt (1, orderNum);
		preparedStmt.setInt (2, requestingClient);
		preparedStmt.setInt (3, destinedClient);
		preparedStmt.setInt (4, missionDrone);
		preparedStmt.setDate (5, dateCreated);
		preparedStmt.execute();
	
		
		//connSubscriberDb.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}

