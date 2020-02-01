
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

public class DroneOrderForm extends JFrame implements ActionListener {
 
  DroneSystem droneSystem;
  Client user;
  private ArrayList<Client> clients = creatMockData();
  private JButton btnSend  = new JButton("Send Order");
  JPanel clientList  =  new JPanel ();
  JPanel clientListContainer  =  new JPanel ();
  JScrollPane jScrollPane = new JScrollPane(this.clientList);  
  JPanel resultBox = new JPanel (); 
  Client selectedClient;
  
  public DroneOrderForm(DroneSystem droneSystem, Client user){
    super();
    this.droneSystem = droneSystem;
    this.user = user;
    setTitle("Shipping Ordering Form");
    setFreamIcon();
    setBounds(800,10,600,800); 
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

	  Client client1 = new Client("avi", "Dotan", "ako","ha-ganim", 35, "0453344494", 123, eSubscriptionType.BIG_PACKAGE );
	  Client client2 = new Client("avi", "Dotan2", "ako","ha-ganim", 35, "0453344494", 124, eSubscriptionType.BIG_PACKAGE );
	  Client client3 = new Client("avi", "Dotan3", "ako","ha-ganim", 35, "0453344494", 125, eSubscriptionType.BIG_PACKAGE );
	  Client client4 = new Client("avi", "Dotan4", "ako","ha-ganim", 35, "0453344494", 126, eSubscriptionType.BIG_PACKAGE );
	  Client client5 = new Client("avi", "Dotan5", "ako","ha-ganim", 35, "0453344494", 127, eSubscriptionType.BIG_PACKAGE );
	  Client client6 = new Client("avi", "Dotan5", "ako","ha-ganim", 35, "0453344494", 128, eSubscriptionType.BIG_PACKAGE );
	  Client client7 = new Client("avi", "Dotan5", "ako","ha-ganim", 35, "0453344494", 129, eSubscriptionType.BIG_PACKAGE );
	  Client client8 = new Client("avi", "Dotan5", "ako","ha-ganim", 35, "0453344494", 130, eSubscriptionType.BIG_PACKAGE );
	  ArrayList<Client> clients = new ArrayList<Client>();
	  clients.add(client1);
	  clients.add(client2);
	  clients.add(client3);
	  clients.add(client4);
	  clients.add(client5);
	  clients.add(client6);
	  clients.add(client7);
	  clients.add(client8);
  
	  return clients;
  } 


  private void initComponent(){
	  this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	  this.add(PageHeader("Select a User to send to"));
	  this.add(resultBox);
	  this.add(creatClientList(this.clients));  
  }
  
  
  private JPanel creatClientList(ArrayList<Client> clients){
	  clientList.setPreferredSize(new Dimension(400, 500));
	  for(int i = 0; i < clients.size(); i++ ) {
		  clientList.add(clientCard(clients.get(i), "Select", true));
	  } 
	  jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  

	  clientListContainer.add(jScrollPane);
	  return clientListContainer;
  }
  
  private JPanel PageHeader(String str) {
	 JPanel headerPanel = panelWithPadding(0,10,0,10);
	 headerPanel.setPreferredSize(new Dimension(400, 10));
 	 JLabel label = new JLabel (str);
 	 label.setPreferredSize(new Dimension(400, 50));
 	 label.setFont(new Font("Serif", Font.BOLD, 24));
 	 headerPanel.add(label);
	 return headerPanel;
 }
  
  private JPanel clientCard(Client client, String btnText, boolean useClientIdAsActionCommand) {
	 JPanel Ccard = new JPanel ();
	 Ccard.setLayout(new BoxLayout(Ccard, BoxLayout.Y_AXIS));
	 Ccard.add(new JLabel (client.getName()));
	 Ccard.add(new JLabel (client.getAddress().toString()));
	 Ccard.setPreferredSize(new Dimension(250, 40));
	 JPanel paddingPanel = panelWithPadding(10,10,10,10);
	 paddingPanel.add(Ccard);
	 JPanel borderPanel =  panelWithBorder(1,11,1,1,Color.lightGray);
	 borderPanel.add(paddingPanel);
	 JButton selectBtn = new JButton(btnText);
	 if(useClientIdAsActionCommand) {
		 selectBtn.setActionCommand(String.valueOf(client.getClientID()));		 
	 }
	 selectBtn.addActionListener(this);
	 borderPanel.add(selectBtn);
	 return borderPanel;
 }
  
  private JPanel panelWithPadding(int top, int left ,int buttom, int right) {
	 JPanel paddingPanel = new JPanel ();
	 paddingPanel.setBorder(new EmptyBorder(top, left, buttom, right));
	 return paddingPanel;
 }
  
  private JPanel panelWithBorder(int top, int left ,int buttom, int right,  Color matteColor ) {
	 JPanel borderPanel = new JPanel ();
	 borderPanel.setBorder(new MatteBorder(top, left, buttom, right, matteColor));
	 return borderPanel;
 }
  
  private  Client getClientByID(int id) {
//	  boolean isFound = false;
	  for( int i = 0; i< clients.size() ; i++) {
		 Client client = clients.get(i);
		  if(client.getClientID() == id) {
			  return client;
		  }		  
	  }
	  return null;
  }

 
		@Override
	    public void actionPerformed(ActionEvent e) {
	  	System.out.println(e.getActionCommand());
	  	if(e.getActionCommand() == "Send Delivery") {
	  		
	  		droneSystem.addOrder(user.getClientID(), selectedClient.getClientID());
	  		
	  	}else {
	  		int id = Integer.parseInt(e.getActionCommand());
	  		selectedClient = getClientByID(id);
	  		resultBox.removeAll();
	  		resultBox.add(clientCard(selectedClient, "Send Delivery", false));
	  		resultBox.validate();
	  		resultBox.repaint();	  		
	  	}
	  
  }
  
}

