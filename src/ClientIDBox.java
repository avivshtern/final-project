import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
// this component is used as a popup to show to the registered user 
// hes client id in a disclosed way. 
public class ClientIDBox extends JFrame{
	DroneSystem droneSystem;
	JLabel messageLable = new JLabel(); 
	JPanel messagePanel = new JPanel();
	
	public ClientIDBox(DroneSystem droneSystem) {
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
	  
	  private void creatElements(){
		  messageLable.setText("Your client Id is: " + droneSystem.currentUser.getClientID());
		  messagePanel.setPreferredSize(new Dimension(300, 40));
		  messagePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		  messagePanel.add(messageLable);
	  } 
	  
	  private void initComponent(){
		  add(messagePanel);
	  }
	  

}
