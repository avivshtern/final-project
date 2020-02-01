import java.time.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DroneSystem droneSystem1=new DroneSystem();
		if (!droneSystem1.startSystem())
		{
			return;
		}
		droneSystem1.addClient("Tamir", "Tubul", "Ashdod", "Hakinor", 26, "0546777483", eSubscriptionType.SMALL_PACKAGE);
		droneSystem1.addClient("Aviv", "Shtern", "Ramat Hasharon", "Sokolov", 65, "0526134630", eSubscriptionType.BIG_PACKAGE);
		Client c= droneSystem1.clientList.get(0);
		System.out.println(c.clientToString());
	    /*LocalDate monthBehind = c.getDateOfPayment().minusMonths(2);
		c.setDateOfPayment(monthBehind);
		/*Client d= droneSystem1.clientList.get(1);
		System.out.println(d.clientToString());
		/*System.out.println(droneSystem1.clientList.get(0).clientToString());
		Client d= droneSystem1.clientList.get(1);
		System.out.println(d.clientToString());
		droneSystem1.sendingMessageBetweenClients(0, 1, "Hi how are you ?");
		droneSystem1.addOrder(0, 1);
		System.out.println(c.clientToString());
		/*droneSystem1.addOrder(1, 0);
		droneSystem1.addOrder(1, 0);
		droneSystem1.addOrder(1, 0);
		droneSystem1.addOrder(1, 0);*/
		}

}
