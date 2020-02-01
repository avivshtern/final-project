
import java.sql.Connection;
import java.time.*;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// this class manage the connection to the DB 
public class DataBaseManager {

	private static final String DB_NAME = "final_project_db_1";

	//sets the connection to the DB in every request sent to the DB. connection closes after every request
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
	
	//creates all the tables
	public static boolean createTables() {
		try {
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			// creates clients
			stmt.execute("DROP TABLE IF EXISTS clients");
			stmt.execute("CREATE TABLE clients "
					+ "(clientID int, firstName varchar(100), lastName varchar(100), phoneNumber varchar(10), "
					+ "subscriptionType varchar(100), numOfShipmentsLeft int, dateOfRegistration Date)");
			// creates orders
			stmt.execute("DROP TABLE IF EXISTS orders");
			stmt.execute("CREATE TABLE orders "
					+ "(orderNum int, requestingClient int, destinedClient int, missionDrone int, dateCreated Date)");
			// creates drones
			stmt.execute("DROP TABLE IF EXISTS drones");
			stmt.execute("CREATE TABLE drones " + "(droneID int, isAvailable boolean, batteryLifePercentage int)");
			// creates address
			stmt.execute("DROP TABLE IF EXISTS address");
			stmt.execute("CREATE TABLE address " + "(cityName varchar(100) , streetName varchar(100), streetNum int)");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//adds currentClient to clients table in DB and its address to address table
	public static void addClient(Client currentClient) {
		try {
			Connection conn = getConn();
			
			//for client 
			int clientID = currentClient.getClientID();
			String firstName = currentClient.getFirstName();
			String lastName = currentClient.getLastName();
			String phoneNumber = currentClient.getPhoneNum();
			eSubscriptionType subscriptionType = currentClient.getSubscriptionType();
			int numOfShipmentsLeft = currentClient.getNumOfShipmentsLeft();
			Date dateOfRegistration = Date.valueOf(currentClient.getDateOfRegistration());
			String query = " insert into clients (clientID, firstName, lastName, phoneNumber, subscriptionType, numOfShipmentsLeft, dateOfRegistration)"
					+ " values (?,?,?,?,?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, clientID);
			preparedStmt.setString(2, firstName);
			preparedStmt.setString(3, lastName);
			preparedStmt.setString(4, phoneNumber);
			preparedStmt.setInt(5, subscriptionType.ordinal());
			preparedStmt.setInt(6, numOfShipmentsLeft);
			preparedStmt.setDate(7, dateOfRegistration);
			preparedStmt.execute();

			//for address
			String cityName = currentClient.getAddress().getCityName();
			String streetName = currentClient.getAddress().getStreetName();
			int streetNumber = currentClient.getAddress().getStreetNum();

			query = " insert into address (cityName, streetName, streetNum)" + " values (?,?,?)";
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

	//gives the client the option to get all its information
	public static ResultSet getClients() {
		try {
			String query, firstName, lastName, password;
			Connection conn;
			Statement stmt;
			ResultSet rs;
			conn = getConn();
			query = "SELECT * from clients";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			conn.close();
			return rs;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	//adds currentDrone to drones table in DB
	public static void addDrone(Drone currentDrone) {
		try {
			Connection conn = getConn();

			int droneID = currentDrone.getDroneID();
			boolean isAvailable = currentDrone.getIsAvailable();
			int batteryLifePercentage = currentDrone.getBatteryLifePercentage();

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
	//adds currentOrder to orders table in DB
	public static void addOrder(Order currentOrder) {
		try {
			Connection conn = getConn();

			int orderNum = currentOrder.getOrderNum();
			int requestingClient = currentOrder.getRequestingClient().getClientID();
			int destinedClient = currentOrder.getDestinedClient().getClientID();
			int missionDrone = currentOrder.getMissionDrone().getDroneID();
			Date dateCreated = Date.valueOf(currentOrder.getDateCreated());

			String query = " insert into orders (orderNum, requestingClient, destinedClient, missionDrone, dateCreated)"
					+ " values (?,?,?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, orderNum);
			preparedStmt.setInt(2, requestingClient);
			preparedStmt.setInt(3, destinedClient);
			preparedStmt.setInt(4, missionDrone);
			preparedStmt.setDate(5, dateCreated);
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
