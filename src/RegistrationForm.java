
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.*;
import java.util.Date;
import java.awt.*;


	public class RegistrationForm implements ActionListener {
	    JFrame frame=new JFrame();
	    
	    JLabel fnameLabel=new JLabel("First Name");
	    JTextField fnameTextField=new JTextField(15);
	    JLabel lnameLabel=new JLabel("Last Name");
	    JTextField lnameTextField=new JTextField(15);

	    JLabel StreetLabel=new JLabel("Street");
	    JTextField StreetTextField=new JTextField(15);
	    JLabel streetNumLabel=new JLabel("Street num");
	    JTextField streetNumTextField=new JTextField(15);	
	    JLabel cityLabel=new JLabel("City");
	    JTextField cityTextField=new JTextField(15);

	    JLabel phoneLabel=new JLabel("Phone Number");
	    JTextField phoneNumber=new JTextField(15);

	    JLabel subscriptionTypeLabel=new JLabel("Select Subscription Type");
	    String[] subscriptionTypes = {"Big","Small", "Monthly" };
		JComboBox subscriptionTypeComboBox=new JComboBox(subscriptionTypes);

		JButton registerButton=new JButton("Register");
	    JButton resetButton=new JButton("Reset");
	    JButton logInButton=new JButton("LogIn");
	    JButton orderButton=new JButton("Order");
	    
	    
	    JPanel PnameContainer;
	    JPanel PAddressContainer;
	    JPanel PPhoneContainer;
	    JPanel PFooterContainer;
	    JPanel PSubscriptionTypeContainer;
	    JPanel buttonPane;
	    
	    JPanel appheader = headerContainer(new JLabel ("Welcome to Drone Post"), 24);
	    JPanel appDescription = headerContainer(new JLabel ("Enter the following information to signup"), 18);
	    JLabel addressLabel = new JLabel ("Address");
	    JPanel addressheader = headerContainer(addressLabel, 15);
	    
	    JPanel Subscriptionheader = CreatSubscriptionText();

	    DroneSystem droneSystem;
	    
	    RegistrationForm(DroneSystem droneSystem)
	    {
	    	super();
	    	this.droneSystem = droneSystem;
	    	setFreamIcon();
	        createWindow();
	        setLocationAndSize();
	        addComponentsToFrame();
	        actionEvent();
	    }
	    public void createWindow()
	    {
	    	frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
	        frame.setTitle("Registration Form");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setBounds(120,120,900,500);
	        frame.setVisible(true);
//	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(false);
	    }
	    public void setLocationAndSize()
	    {
	    	PnameContainer = BoxContainer(50);
	    	PnameContainer.add(LabelAndInput(fnameLabel, fnameTextField));
	    	PnameContainer.add(LabelAndInput(lnameLabel, lnameTextField));
	    	
	    	addressLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
	    	addressLabel.setPreferredSize(new Dimension(100, 30));
	    	addressLabel.setMaximumSize(new Dimension(100, 30));
	    	
	    	PAddressContainer = BoxContainer(50);
	    	PAddressContainer.add(LabelAndInput(StreetLabel, StreetTextField));
	    	PAddressContainer.add(LabelAndInput(streetNumLabel, streetNumTextField));
	    	PAddressContainer.add(LabelAndInput(cityLabel, cityTextField, 35));
	    	
	    	phoneNumber.setDocument(new JTextFieldLimit(10));
	    	PPhoneContainer = BoxContainer(50);
	    	PPhoneContainer.add(LabelAndInput(phoneLabel, phoneNumber, 90));
	    	
	    	PSubscriptionTypeContainer = BoxContainer(50);
	    	PSubscriptionTypeContainer.add(LabelAndInput(subscriptionTypeLabel, subscriptionTypeComboBox, 150));
	    	
	    	buttonPane = new JPanel();
	    	buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
	    	buttonPane.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 20));
	    	buttonPane.add(Box.createHorizontalGlue());
	    	
	    	buttonPane.add(logInButton);
	    	buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
	    	buttonPane.add(resetButton);
	    	buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
	    	buttonPane.add(registerButton);
	    	
	    }
	    public void addComponentsToFrame()
	    {
	    	frame.add(appheader);
	    	frame.add(appDescription);
	    	frame.add(PnameContainer);
	    	frame.add(addressheader);
	        frame.add(PAddressContainer);
	        frame.add(PPhoneContainer);
	        frame.add(Subscriptionheader);
	        frame.add(PSubscriptionTypeContainer);
	        frame.add(buttonPane);


	    }
	    
	    private void setFreamIcon() {
	    	ImageIcon img = new ImageIcon("images/icon4.png");
	    	// iconURL is null when not found
	    	frame.setIconImage(img.getImage());
	    }
	    
	    private JPanel BoxContainer(int maxHight) {
	    	 JPanel BoxContainer = new JPanel(new FlowLayout(0, 20, 10) );
	    	 BoxContainer.setBorder(new MatteBorder(0,0,1,0,Color.lightGray));
	    	 BoxContainer.setMaximumSize(new Dimension(Short.MAX_VALUE, maxHight));
	    	 return BoxContainer;
	    }
	    
	    private JPanel  LabelAndInput(JLabel label, JComponent textField) {
	    	JPanel PanelContainer = new JPanel(new FlowLayout(0, 10, 0) );
	    	label.setPreferredSize(new Dimension(70,25));
	    	PanelContainer.add(label);
	    	PanelContainer.add(textField);
	    	return PanelContainer;
	    }
	    
	    private JPanel  LabelAndInput(JLabel label, JComponent textField, int labelWidth) {
	    	JPanel PanelContainer = new JPanel(new FlowLayout(0, 10, 0) );
	    	label.setPreferredSize(new Dimension(labelWidth,25));
	    	PanelContainer.add(label);
	    	PanelContainer.add(textField);
	    	return PanelContainer;
	    }
	    
	    private JPanel headerContainer(JLabel label, int size) {
	    	JPanel PanelContainer = new JPanel(new FlowLayout(0, 30, 0) );
	    	PanelContainer.setMaximumSize(new Dimension(Short.MAX_VALUE, 20));
	    	label.setPreferredSize(new Dimension(900,25));
	    	label.setFont(new Font("Serif", Font.BOLD, size));
	    	PanelContainer.add(label);
	    	return PanelContainer;
	    }
	    
	    private JPanel CreatSubscriptionText() {
	    	JPanel PanelContainer = new JPanel(new FlowLayout(0, 30, 0));
	    	JPanel PanelContant = new JPanel();
	    	PanelContant.setMaximumSize(new Dimension(300, 200));
	    	PanelContant.setLayout(new BoxLayout(PanelContant, BoxLayout.Y_AXIS));
		    JLabel SubscriptionTextHeader = new JLabel ("Select your preferred subscriptions");
		    SubscriptionTextHeader.setFont(new Font("Serif", Font.BOLD, 18));
		    JLabel SubscriptionText = new JLabel ("You can choose between these three options:");
		    SubscriptionText.setFont(new Font("Serif", Font.BOLD, 15));
		    JLabel SubscriptionOption1 = new JLabel ("1. Big- 150 deliveries for only 179$");
		    JLabel SubscriptionOption2 = new JLabel ("2. Small- 50 deliveries for only 99$");
		    JLabel SubscriptionOption3 = new JLabel ("3. Monthly- Unlimited deliveries for only 199$");
		    
		    PanelContant.add(SubscriptionTextHeader);
		    PanelContant.add(SubscriptionText);
		    PanelContant.add(SubscriptionOption1);
		    PanelContant.add(SubscriptionOption2);
		    PanelContant.add(SubscriptionOption3);
		    PanelContainer.add(PanelContant);
		    
	    	return PanelContainer;
	    }
	    
	    private JLabel PageHeader() {
	    	 JLabel label = new JLabel ("Drone Post");
	    	 label.setFont(new Font("Serif", Font.BOLD, 24));
			 return label;
	    }
	    
	    public void actionEvent()
	    {
	        registerButton.addActionListener(this);
	        resetButton.addActionListener(this);
	        logInButton.addActionListener(this);
	    }
	    
	    boolean ChackFormValidation(){
	    	boolean formValid = false;
	    	if(
	    	fnameTextField.getText().length() > 0 &&
	    	lnameTextField.getText().length() > 0 &&
	    	StreetTextField.getText().length()> 0
	    	) {
	    		formValid = true;
	    	};
	    	return formValid;
	    }
	    
	    void resetFileds() {
	    	fnameTextField.setText("");
            lnameTextField.setText("");
            StreetTextField.setText("");
            streetNumTextField.setText("");
            cityTextField.setText("");
            subscriptionTypeComboBox.setSelectedItem("Big");
            phoneNumber.setText("");
	    }
	    
	    void addOrderBtn() {
	    	orderButton.addActionListener(this);
	    	buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
	    	buttonPane.add(orderButton);
	    	buttonPane.validate();
	    	buttonPane.repaint();
	    }


	    @SuppressWarnings("null")
		@Override
	    public void actionPerformed(ActionEvent e) {
	    	String buttontText = e.getActionCommand();
	    	if(buttontText == "Register") {
	    		System.out.println("Register");
	    		boolean isFormValid = ChackFormValidation(); 
	    		if(isFormValid) { 
	    		String serlectedItem = subscriptionTypeComboBox.getSelectedItem().toString();
	    		this.droneSystem.registerNewUser(fnameTextField.getText(),
	    				lnameTextField.getText(),
	    				cityTextField.getText(),
	    				StreetTextField.getText(),
	    				Integer.parseInt(streetNumTextField.getText()),
	    				phoneNumber.getText(),
	    				droneSystem.getSubscriptionEnum(serlectedItem)	    			
	    				);
	    		 resetFileds();
	    		 addOrderBtn();
	    		 new ClientIDBox(droneSystem);
	    		}
	    	}else if(buttontText == "Reset") {
	    		System.out.println("Reset");
	    		resetFileds();
	    	}else if(buttontText == "Order") {	 
	    		System.out.println(buttontText);
    			new DroneOrderForm(this.droneSystem, droneSystem.currentUser);
	    	}else if(buttontText == "LogIn") {	 
	    		System.out.println(buttontText);
    			new SignIn(this.droneSystem);
    
	    	}
	    }
	}
	


