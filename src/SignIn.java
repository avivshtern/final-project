import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignIn  extends JFrame implements ActionListener{
	JLabel signInLable = new JLabel("Sign-In to Drone Post"); 
	JPanel signInPanel =  new JPanel();
	
	JLabel fullNameLable = new JLabel("Enter Full Name"); 
	JTextField fullName = new JTextField(15);
	JPanel fullNamePanel = new JPanel();
	
	JLabel clientIDLable = new JLabel("Enter your client ID"); 
	JTextField clientID = new JTextField(15);
	JPanel clientIDPanel = new JPanel();
	
	JPanel btnPanel = new JPanel();
	JButton signInBtn = new JButton("Sign-In");
	
	JLabel messageLable = new JLabel(); 
	JPanel messagePanel = new JPanel();
	
	DroneSystem droneSystem;
	public SignIn(DroneSystem droneSystem) {
		 	this.droneSystem = droneSystem;
		    setTitle("SignIn");
		    setFreamIcon();
		    setDefaultCloseOperation(DISPOSE_ON_CLOSE );
		    setBounds(400,100,400,300); 
		    setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		    setVisible(true);
		    setResizable(false);
		    creatElements();
		    initComponent();   
	}

  private void setFreamIcon() {
		    ImageIcon img = new ImageIcon("images/icon4.png");
		    this.setIconImage(img.getImage());
	}
  
  void creatElements() {
	  signInLable.setFont(new Font("Serif", Font.BOLD, 24));
	  signInPanel .setBorder(new EmptyBorder(10, 20, 10, 10));
	  signInPanel.add(signInLable);
	  
	  fullNamePanel.setPreferredSize(new Dimension(300, 40));
	  fullNamePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	  fullNamePanel.add(fullNameLable);
	  fullNamePanel.add(fullName);
	  
	  
	  clientIDPanel.setPreferredSize(new Dimension(300, 40));
	  clientIDPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	  clientIDPanel.add(clientIDLable);
	  clientIDPanel.add(clientID);
	  
	  signInBtn.addActionListener(this);
	  btnPanel.add(signInBtn);
  }
  
  void initComponent(){
	  
	  add(signInPanel);
	  add(fullNamePanel);
	  add(clientIDPanel);
	  add(btnPanel);
	  add(messagePanel);
  }
  
  void addMessage(String msg) {
	  messagePanel.removeAll();
	  messageLable.setText(msg);
	  messagePanel.add(messageLable);
	  messagePanel.validate();
	  messagePanel.repaint();
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
	  if(e.getActionCommand() == "Sign-In") {
			System.out.println(e.getActionCommand());
			Client currentUser =  droneSystem.logIn(fullName.getText().trim(), clientID.getText().trim());
			System.out.println(currentUser);
			if(currentUser != null) {
				new DroneOrderForm(this.droneSystem, droneSystem.currentUser);
				addMessage("Welcome " + currentUser.getName());
			}else {
				addMessage("The enterd name or password is incorrect");
			}
	  }
  }
}