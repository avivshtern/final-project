
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DroneSystem droneSystem1=new DroneSystem();
		new RegistrationForm(droneSystem1);
		droneSystem1.addClient("Tamir", "Tubul", "Ashdod", "Hakinor", 26, "0546777483", eSubscriptionType.SMALL_PACKAGE);
		droneSystem1.addClient("Aviv", "Shtern", "Ramat Hasharon", "Sokolov", 65, "0526134630", eSubscriptionType.BIG_PACKAGE);
		Client c= droneSystem1.clientList.get(0);
		System.out.println(c.clientToString());
		Client d= droneSystem1.clientList.get(1);
		System.out.println(d.clientToString());
		droneSystem1.addOrder(0, 1);
		droneSystem1.addOrder(1, 0);
		droneSystem1.addOrder(1, 0);
		droneSystem1.addOrder(1, 0);
		droneSystem1.addOrder(1, 0);
	
		
		System.out.println(java.time.LocalDateTime.now());
		
	}

}
