
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
// In this component we order the drones.
// the client can select from a list another client to send to.
// If the Client has no shipments left in he's subscription then he will be asked to buy a new subscription. 
public class DroneOrderForm extends JFrame implements ActionListener {
 
  DroneSystem droneSystem;
  Client user;
  private ArrayList<Client> clients;
  private JButton btnSend  = new JButton("Send Order");
  JPanel clientList  =  new JPanel ();
  JPanel clientListContainer  =  new JPanel ();
  JScrollPane jScrollPane = new JScrollPane(this.clientList);  
  JPanel resultBox = new JPanel (); 
  Client selectedClient;
  JPanel pageHeader;
  String message;
  JPanel messageBox = new JPanel();
  
  JLabel shipmentsLeftLabel;
  
  JLabel subscriptionTypeLabel = new JLabel("Select Subscription Type");
  String[] subscriptionTypes = {"Big","Small", "Monthly" };
  JComboBox subscriptionTypeComboBox=new JComboBox(subscriptionTypes);
  JButton addSubscriptionBtn = new JButton("Buy Now");
  JPanel addSubscriptionTypesBox = new JPanel();
  
  public DroneOrderForm(DroneSystem droneSystem, Client user){
    super();
    this.droneSystem = droneSystem;
    this.user = user;
    this.clients = droneSystem.getClientsList();
    setTitle("Shipping Ordering Form");
    setFreamIcon();
    setDefaultCloseOperation(DISPOSE_ON_CLOSE );
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


  private void initComponent(){
	  this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	  pageHeader = PageHeader("Hallow "+ user.getName(), "Select a clients from the list...", "You Have " + user.getNumOfShipmentsLeft() + " shipments left");
	  this.add(pageHeader);
	  this.add(resultBox);
	  this.add(messageBox);
	  this.add(creatClientList(this.clients));
	 
  }
  
  // Creates the list of clients dynamically  
  private JPanel creatClientList(ArrayList<Client> clients){
	  clientList.setPreferredSize(new Dimension(400, 400));
	  for(int i = 0; i < clients.size(); i++ ) {
		  clientList.add(clientCard(clients.get(i), "Select", true));
	  } 
	  jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  

	  clientListContainer.add(jScrollPane);
	  return clientListContainer;
  }
  
  // Creates the Page header
  private JPanel PageHeader(String header, String description, String shipmentsLeftText) {
	 JPanel headerPanel = panelWithPadding(0,10,0,10);
	 headerPanel.setPreferredSize(new Dimension(400, 90));
 	 JLabel label = new JLabel (header);
 	 label.setPreferredSize(new Dimension(400, 30));
 	 label.setFont(new Font("Serif", Font.BOLD, 24));
	 
 	 shipmentsLeftLabel = new JLabel (shipmentsLeftText);
	 shipmentsLeftLabel.setPreferredSize(new Dimension(400, 30));
	 shipmentsLeftLabel.setFont(new Font("Serif", Font.BOLD, 16));
	 
 	 JLabel descriptionLabel = new JLabel (description);
 	 descriptionLabel.setPreferredSize(new Dimension(400, 30));
 	 descriptionLabel.setFont(new Font("Serif", Font.BOLD, 16));
 	 headerPanel.add(label);
 	 headerPanel.add(shipmentsLeftLabel);
 	 headerPanel.add(descriptionLabel);
	 return headerPanel;
 }
  // The Client card create a card component this is used to create the list dynamically 
  private JPanel clientCard(Client client, String btnText, boolean useClientIdAsActionCommand) {
	 JPanel Ccard = new JPanel ();
	 Ccard.setLayout(new BoxLayout(Ccard, BoxLayout.Y_AXIS));
	 Ccard.add(new JLabel (client.getName()));
	 Ccard.add(new JLabel (client.getAddress().addressToString()));
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
  // panelWithPadding panelWithBorder and to methods are used for stilling the card element
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
  // This is a method to show the message after ordering. 
  private void showMessage() {
	  messageBox.removeAll();
	 JLabel messageLabel = new JLabel("<html>"+message+"</html>");
	 messageLabel.setPreferredSize(new Dimension(400, 40));
	  messageBox.add(messageLabel);
	  messageBox.validate();
	  messageBox.repaint();
  }
  
  // This method re-renders the header component every time the number of "subscription left" changes
  private void rerenderHeader() {
	shipmentsLeftLabel.setText( "You Have " + user.getNumOfShipmentsLeft() + " left");
	shipmentsLeftLabel.validate();
	shipmentsLeftLabel.repaint();
	 
  }
  
  private  Client getClientByID(int id) {
	  for( int i = 0; i< clients.size() ; i++) {
		 Client client = clients.get(i);
		  if(client.getClientID() == id) {
			  return client;
		  }		  
	  }
	  return null;
  }
  
  // This Panel renders when the user needs to renew his subscription.
  private void creatAddSubscriptionPanel() {
	  addSubscriptionBtn.addActionListener(this);
	  addSubscriptionTypesBox.add(subscriptionTypeLabel);
	  addSubscriptionTypesBox.add(subscriptionTypeComboBox);
	  addSubscriptionTypesBox.add(addSubscriptionBtn);
	  add(addSubscriptionTypesBox);
	  
  }

 
  @Override
  public void actionPerformed(ActionEvent e) {
	// Sends the delivery based on the selectedClient
	if(e.getActionCommand() == "Send Delivery") {
	message = droneSystem.addOrder(user.getClientID(), selectedClient.getClientID());
	this.user = droneSystem.currentUser;
	// If subscription has ended render the "Add Subscription Panel" 
	if(this.user.getNumOfShipmentsLeft() == 0 ) {
		creatAddSubscriptionPanel();
	}
	rerenderHeader();
	showMessage();
	// Renews the Subscription
	}else if(e.getActionCommand() == "Buy Now") {
		droneSystem.newSubscription(this.user, droneSystem.getSubscriptionEnum(subscriptionTypeComboBox.getSelectedItem().toString()));
		rerenderHeader();
	// Select the Client to send to
	} else {
		int id = Integer.parseInt(e.getActionCommand());
		selectedClient = getClientByID(id);
		resultBox.removeAll();
		resultBox.add(clientCard(selectedClient, "Send Delivery", false));
		  		resultBox.validate();
		  		resultBox.repaint();	  		
		  	}
		  
  }
  
}

