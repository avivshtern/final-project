package reg1;

	
	import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.event.*;
	import java.awt.*;
	import java.sql.*;

	public class RegistrationForm implements ActionListener {
	    JFrame frame;
	    String[] gender={"Male","Female"};
	    String[] country={};
	    String adress = "ADRESS";
	    JLabel fnameLabel=new JLabel("FIRST NAME");
	    JLabel lnameLabel=new JLabel("LAST NAME");
	    JLabel genderLabel=new JLabel("GENDER");   
	    JLabel passwordLabel=new JLabel("PASSWORD");
	    JLabel confirmPasswordLabel=new JLabel("CONFIRM PASSWORD");
	    JLabel adressLabel = new JLabel ("ADRESS");
	    JLabel StreetLabel=new JLabel("STREET");
	    JLabel POBLabel=new JLabel("POB");
	    JLabel cityLabel=new JLabel("CITY");
	    JLabel countryLabel=new JLabel("COUNTRY");
	    JLabel emailLabel=new JLabel("EMAIL");
	    JLabel ConfirmEmailLabel=new JLabel("CONFIRM EMAIL");
	    JTextField fnameTextField=new JTextField();
	    JTextField lnameTextField=new JTextField();
	    @SuppressWarnings("unchecked")
		JComboBox genderComboBox=new JComboBox(gender);
	    @SuppressWarnings("unchecked")
		JComboBox countryComboBox=new JComboBox(country);
	    JPasswordField passwordField=new JPasswordField();
	    JPasswordField confirmPasswordField=new JPasswordField();
	    JTextField StreetTextField=new JTextField();
	    JTextField POBTextField=new JTextField();	
	    JTextField cityTextField=new JTextField();
	    JTextField emailTextField=new JTextField();
	    JTextField confirmEmailTextField=new JTextField();
	    JButton registerButton=new JButton("REGISTER");
	    JButton resetButton=new JButton("RESET");


	    RegistrationForm()
	    {
	        createWindow();
	        setLocationAndSize();
	        addComponentsToFrame();
	        actionEvent();
	    }
	    public void createWindow()
	    {
	        frame=new JFrame();
	        frame.setTitle("Registration Form");
	        frame.setBounds(120,120,800,600);
	        frame.getContentPane().setBackground(Color.gray);
	        frame.getContentPane().setLayout(null);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(false);
	    }
	    public void setLocationAndSize()
	    {
	        fnameLabel.setBounds(40,40,90,20);
	        lnameLabel.setBounds(240,40,90,20);
	        fnameTextField.setBounds(120,40,90,20);
	        lnameTextField.setBounds(340,40,150,20);
	        //adressLabel.setBounds(80,80,90,20);
		    genderLabel.setBounds(40,70,80,70); 
		    genderComboBox.setBounds(120,93,85,20);
		    StreetLabel.setBounds(40,120,100,70);
		    StreetTextField.setBounds(120,145,160,20);
		    POBLabel.setBounds(300,145,60,20);
			POBTextField.setBounds(350,145,60,20);
			cityLabel.setBounds(440,120,100,70);
			cityTextField.setBounds(500,145,180,20);
			countryLabel.setBounds(250,170,70,70); 
			countryComboBox.setBounds(320,193,165,23);
			passwordLabel.setBounds(40,220,100,70);
			confirmPasswordLabel.setBounds(310,220,150,70);
			passwordField.setBounds(120,245,150,20);
			confirmPasswordField.setBounds(460,244,150,20);
			emailLabel.setBounds(40,320,90,20);
			emailTextField.setBounds(140,320,290,20);
	        ConfirmEmailLabel.setBounds(40,380,120,20);
		    confirmEmailTextField.setBounds(250,380,290,20);
	        registerButton.setBounds(70,450,100,35);
	        resetButton.setBounds(220,450,100,35);
	    }
	    public void addComponentsToFrame()
	    {
	        frame.add(fnameLabel);
	        frame.add(lnameLabel);
	        frame.add(genderLabel);
	        frame.add(countryLabel);
	        frame.add(StreetLabel);
	        frame.add(POBLabel);
	        frame.add(passwordLabel);
	        frame.add(confirmPasswordLabel);
	        frame.add(cityLabel);
	        frame.add(emailLabel);
	        frame.add(ConfirmEmailLabel);
	        frame.add(fnameTextField);
	        frame.add(lnameTextField);
	        frame.add(genderComboBox);
	        frame.add(countryComboBox);
	        frame.add(StreetTextField);
	        frame.add(POBTextField);
	        frame.add(passwordField);
	        frame.add(confirmPasswordField);
	        frame.add(cityTextField);
	        frame.add(emailTextField);
	        frame.add(confirmEmailTextField);
	        frame.add(registerButton);
	        frame.add(resetButton);
	    }
	    public void actionEvent()
	    {
	        registerButton.addActionListener(this);
	        resetButton.addActionListener(this);
	    }


	    @SuppressWarnings("null")
		@Override
	    public void actionPerformed(ActionEvent e) {
	        if(e.getSource()==registerButton)
	        {
	            try {
	                Connection  connection = null;
	                java.sql.Statement stmt = null;
	                connection=Connection.getConn();
	                PreparedStatement Pstatement=connection.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
	                Pstatement.setString(1,nameTextField.getText());
	                Pstatement.setString(2,genderComboBox.getSelectedItem().toString());
	                Pstatement.setString(3,StreetTextField.getText());
	                Pstatement.setString(4,passwordField.getText());
	                Pstatement.setString(5,confirmPasswordField.getText());
	                Pstatement.setString(6,cityTextField.getText());
	                Pstatement.setString(7,emailTextField.getText());
	                Pstatement.setString(8,POBTextField.getText());
	                if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
	                {

	                    Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null,"password did not match");
	                }

	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


	        }
	        if(e.getSource()==resetButton)
	        {
	            fnameTextField.setText("");
	            lnameTextField.setText("");
	            genderComboBox.setSelectedItem("Male");
	            countryComboBox.setSelectedItem("");
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
	


