
import java.sql.Connection;
import java.time.*;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseManager {

	private static final String DB_NAME = "final_project_db_1";

	private static Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, "root", "");
			System.out.println("Connected...");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static boolean createsTables ()
	{
		try 
		{
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			// creates clients
			stmt.execute("DROP TABLE IF EXISTS clients");
			stmt.execute("CREATE TABLE clients "
					+ "(clientID int, firstName varchar(10), lastName varchar(10), phoneNumber varchar(10), "
					+ "subscriptionType varchar(10), numOfShipmentsLeft int, dateOfRegistration Date)");
			//creates orders
			stmt.execute("DROP TABLE IF EXISTS orders");
			stmt.execute("CREATE TABLE orders "
					+ "(orderNum int, requestingClient int, destinedClient int, missionDrone int, dateCreated Date)");
			//creates drones
			stmt.execute("DROP TABLE IF EXISTS drones");
			stmt.execute("CREATE TABLE drones "
					+ "(droneID int, isAvailable boolean, batteryLifePercentage int)");
			//creates address
			stmt.execute("DROP TABLE IF EXISTS address");
			stmt.execute("CREATE TABLE address "
					+ "(cityName varchar(10) , streetName varchar(10), streetNum int)");
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public static void addClientIntoDb(Client client) {
		try {
			Connection conn = getConn();
			int clientID = client.getClientID();
			String firstName = client.getFirstName();
			String lastName = client.getLastName();
			String phoneNumber = client.getPhoneNum();
			eSubscriptionType subscriptionType = client.getSubscriptionType();
			int numOfShipmentsLeft = client.getNumOfShipmentsLeft();
			Date dateOfRegistration = Date.valueOf(client.getDateOfRegistration());
			String query = " insert into clients (clientID, firstName, lastName, phoneNumber, subscriptionType, numOfShipmentsLeft, dateOfRegistration)"
					+ " values (?,?,?,?,?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, clientID);
			preparedStmt.setString(2, firstName);
			preparedStmt.setString(3, lastName);
			preparedStmt.setString(4, phoneNumber);
			preparedStmt.setInt(5, subscriptionType.ordinal());
			preparedStmt.setInt(6, numOfShipmentsLeft);
			preparedStmt.setDate (7, dateOfRegistration);
			preparedStmt.execute();

			String cityName = client.getAddress().getCityName();
			String streetName = client.getAddress().getStreetName();
			int streetNumber = client.getAddress().getStreetNum();

			query = " insert into address (cityName, streetName, streetNum)" + " values (?,?,?,?)";
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, cityName);
			preparedStmt.setString(2, streetName);
			preparedStmt.setInt(3, streetNumber);
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("addClientInDb");
	}

	public static ResultSet getClientsDetail() {
		try {
			String query, firstName, lastName, password;
			Connection conn;
			Statement stmt;
			ResultSet rs;
			conn = getConn();
			query = "SELECT * from subscribers";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			conn.close();
			return rs;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public static void addDroneIntoDb(Drone drone) {
		try {
			Connection conn = getConn();

			int droneID = drone.getDroneID();
			boolean isAvailable = drone.getIsAvailable();
			int batteryLifePercentage = drone.getBatteryLifePercentage();

			String query = " insert into drones (droneID, isAvailable, batteryLifePercentage)" + " values (?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, droneID);
			preparedStmt.setBoolean(2, isAvailable);
			preparedStmt.setInt(3, batteryLifePercentage);
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void addOrderIntoDb(Order order) {
		try {
			Connection conn = getConn();

			int orderNum = order.getOrderNum();
			int requestingClient = order.getRequestingClient().getClientID();
			int destinedClient = order.getDestinedClient().getClientID();
			int missionDrone = order.getMissionDrone().getDroneID();
			Date dateCreated = Date.valueOf(order.getDateCreated());

			String query = " insert into orders (orderNum, requestingClient_fk, destinedClient_fk, missionDrone_fk, dateCreated)"
					+ " values (?,?,?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, orderNum);
			preparedStmt.setInt(2, requestingClient);
			preparedStmt.setInt(3, destinedClient);
			preparedStmt.setInt(4, missionDrone);
			preparedStmt.setDate (5, dateCreated);
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
