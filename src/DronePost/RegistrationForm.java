package DronePost;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.*;
import java.awt.*;


	public class RegistrationForm implements ActionListener {
	    JFrame frame=new JFrame();
	    String[] gender={"Male","Female"};
	    String[] countrys={"USA","Isreal", "France" };
	    String adress = "ADRESS";
	    JLabel fnameLabel=new JLabel("First Name");
	    JLabel lnameLabel=new JLabel("Last Name");
	    JLabel genderLabel=new JLabel("Gender");   
	    JLabel passwordLabel=new JLabel("Password");
	    JLabel confirmPasswordLabel=new JLabel("Confirm Password");
	    JLabel adressLabel = new JLabel ("Address");
	    JLabel StreetLabel=new JLabel("Street");
	    JLabel POBLabel=new JLabel("POB");
	    JLabel cityLabel=new JLabel("City");
	    JLabel countryLabel=new JLabel("Country");
	    JLabel emailLabel=new JLabel("Email");
	    JLabel ConfirmEmailLabel=new JLabel("Confirm Email");
	    JTextField fnameTextField=new JTextField(15);
	    JTextField lnameTextField=new JTextField(15);
	    @SuppressWarnings("unchecked")
		JComboBox genderComboBox=new JComboBox(gender);
	    @SuppressWarnings("unchecked")
		JComboBox countryComboBox=new JComboBox(countrys);
	    JPasswordField passwordField=new JPasswordField(15);
	    JPasswordField confirmPasswordField=new JPasswordField(15);
	    JTextField StreetTextField=new JTextField(15);
	    JTextField POBTextField=new JTextField(15);	
	    JTextField cityTextField=new JTextField(15);
	    JTextField emailTextField=new JTextField(15);
	    JTextField confirmEmailTextField=new JTextField(15);
	    JButton registerButton=new JButton("Register");
	    JButton resetButton=new JButton("Reset");
	    
	    JPanel PnameContainer;
	    JPanel PgenderContainer;
	    JPanel PAddressContainer;
	    JPanel PPasswordContainer;
	    JPanel PEmailContainer;
	    JPanel PFooterContainer;
	    JPanel buttonPane;

	    RegistrationForm()
	    {
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
	        frame.setBounds(120,120,800,400);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(false);
	    }
	    public void setLocationAndSize()
	    {
	    	PnameContainer = BoxContainer(50);
	    	PnameContainer.add(LabelAndInput(fnameLabel, fnameTextField));
	    	PnameContainer.add(LabelAndInput(lnameLabel, lnameTextField));
	    	
	    	
	    	PgenderContainer = BoxContainer(50);
	    	PgenderContainer.add(LabelAndInput(genderLabel, genderComboBox));
	    	
	    	PAddressContainer = BoxContainer(100);
	    	PAddressContainer.add(LabelAndInput(StreetLabel, StreetTextField));
	    	PAddressContainer.add(LabelAndInput(POBLabel, POBTextField));
	    	PAddressContainer.add(LabelAndInput(cityLabel, cityTextField));
	    	PAddressContainer.add(LabelAndInput(countryLabel, countryComboBox));
	    	
	    	
	    	PPasswordContainer = BoxContainer(50);
	    	PPasswordContainer.add(LabelAndInput(passwordLabel, passwordField));
	    	PPasswordContainer.add(LabelAndInput(confirmPasswordLabel, confirmPasswordField, 120));
	    	
	    	PEmailContainer = BoxContainer(50);
	    	PEmailContainer.add(LabelAndInput(emailLabel, emailTextField));
	    	PEmailContainer.add(LabelAndInput(ConfirmEmailLabel, confirmEmailTextField, 120));
	    	
	    	buttonPane = new JPanel();
	    	buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
	    	buttonPane.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 20));
	    	buttonPane.add(Box.createHorizontalGlue());

	    	buttonPane.add(resetButton);
	    	buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
	    	buttonPane.add(registerButton);
	    }
	    public void addComponentsToFrame()
	    {
	    	frame.add(PnameContainer);
	        frame.add(PgenderContainer);
	        frame.add(PAddressContainer);
	        frame.add(PPasswordContainer);
	        frame.add(PEmailContainer);
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
	    	label.setPreferredSize(new Dimension(60,25));
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
	    
	    public void actionEvent()
	    {
	        registerButton.addActionListener(this);
	        resetButton.addActionListener(this);
	    }


	    @SuppressWarnings("null")
		@Override
	    public void actionPerformed(ActionEvent e) {
	    	String buttontText = e.getActionCommand();
	    	if(buttontText == "Register") {
	    		System.out.println("Register");
//	    		new Client(fnameTextField.getText(),lnameTextField.getText(),StreetTextField.getText(),
//	    				, "phone-number", 		);
	    		
	    	}else if(buttontText == "Reset") {
	    		System.out.println("Reset");
	    		fnameTextField.setText("");
	            lnameTextField.setText("");
	            genderComboBox.setSelectedItem("Male");
	            countryComboBox.setSelectedItem("USA");
	            StreetTextField.setText("");
	            POBTextField.setText("");
	            passwordField.setText("");
	            confirmPasswordField.setText("");
	            cityTextField.setText("");
	            emailTextField.setText("");
	            confirmEmailTextField.setText("");
	            
	    	}
	    }
	}
	


