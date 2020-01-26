package DronePost;

import java.util.ArrayList;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) {
		
		java.sql.Date d1 = new java.sql.Date(System.currentTimeMillis());
		DataBaseManager dbManager = new DataBaseManager();
		Client client1 = new Client("Gadi", "Bari", "Karmiel", "Mivza Makabi", 35, "0524374149", 98885, d1,eSubscriptionType.BIG_PACKAGE);
		Client client2 = new Client("As", "Ar", "Karmiel", "Mivza Makabi", 35, "0524374149", 74335, d1,eSubscriptionType.BIG_PACKAGE);
		
		dbManager.addClientIntoDb(client1);
		dbManager.addClientIntoDb(client2);
		
		Drone drone1 = new Drone(38);
		dbManager.addDroneIntoDb(drone1);
		
		Order order = new  Order(37,client1,client2,d1,drone1);
		dbManager.addOrderIntoDb(order);
	}

}