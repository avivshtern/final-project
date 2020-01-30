package DronePost;
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

 

public class DroneOrderForm extends JFrame {
 
  DroneSystem droneSystem;
  private ArrayList<Client> clients = creatMockData();
  private JButton btnSend  = new JButton("Send Order");

  public DroneOrderForm(DroneSystem droneSystem){
    super();
    this.droneSystem = droneSystem;
    setTitle("Shipping Ordering Form");
    setFreamIcon();
    setBounds(800,10,600,800);
    setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));   
    setVisible(true);
    setResizable(false);
    initComponent();   
  }

  private void setFreamIcon() {
    ImageIcon img = new ImageIcon("images/icon4.png");
    // iconURL is null when not found
    this.setIconImage(img.getImage());
  }


  private  ArrayList<Client> creatMockData(){
	  
	  Client client1 = new Client("avi", "Dotan", "ako","ha-ganim", 35, "0453344494", 123, new Date(), eSubscriptionType.BIG_PACKAGE );
	  Client client2 = new Client("avi", "Dotan2", "ako","ha-ganim", 35, "0453344494", 123, new Date(), eSubscriptionType.BIG_PACKAGE );
	  Client client3 = new Client("avi", "Dotan3", "ako","ha-ganim", 35, "0453344494", 123, new Date(), eSubscriptionType.BIG_PACKAGE );
	  Client client4 = new Client("avi", "Dotan4", "ako","ha-ganim", 35, "0453344494", 123, new Date(), eSubscriptionType.BIG_PACKAGE );
	  Client client5 = new Client("avi", "Dotan5", "ako","ha-ganim", 35, "0453344494", 123, new Date(), eSubscriptionType.BIG_PACKAGE );
	  ArrayList<Client> clients = new ArrayList<Client>();
	  clients.add(client1);
	  clients.add(client2);
	  clients.add(client3);
	  clients.add(client4);
	  clients.add(client5);
  
	  return clients;
  } 


  private void initComponent(){
	  this.add(PageHeader("Select a User to send to"));
	  
	  this.add(clientCard(this.clients.get(0)));
  }
  
  private JLabel PageHeader(String str) {
 	 JLabel label = new JLabel (str);
 	 label.setFont(new Font("Serif", Font.BOLD, 24));
		 return label;
 }
  
  private JPanel clientCard(Client client) {
	 JPanel Ccard = new JPanel ();
	 Ccard.setLayout(new BoxLayout(Ccard, BoxLayout.PAGE_AXIS));
	 Ccard.add(new JLabel (client.getName()));
	 Ccard.add(new JLabel (client.getAddress().toString()));
	 return Ccard;
 }
  
}

