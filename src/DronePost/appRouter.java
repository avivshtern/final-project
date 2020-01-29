package DronePost;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class appRouter {
    JFrame frame=new JFrame();
	private JPanel navBar;
	JButton registrationBtn = new JButton("Registration");
	JButton orderBtn = new JButton("Order");
	
	private CardLayout cardLayout;
	private JPanel viewPort = new JPanel();
	private JPanel ragistrationPage = new JPanel();
	private JPanel orderPage = new JPanel();
	appRouter() {
	    
    	setFreamIcon();
        createWindow();	
        setLocationAndSize();
//        actionEvent();
		addComponentsToFrame();
	}
	
	public void setLocationAndSize()
	{
		
		navBar = new JPanel(); 

		
//		navBar.setBounds(0,0,800,100);
		
		navBar.setLayout(new BoxLayout(navBar, BoxLayout.LINE_AXIS));
		navBar.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 20));
		navBar.setBackground(Color.BLUE);
		navBar.add(Box.createHorizontalGlue());
		navBar.add(registrationBtn);
		navBar.add(Box.createRigidArea(new Dimension(10, 0)));
		navBar.add(orderBtn); 
		
		cardLayout = new CardLayout(400,300);
		viewPort.setLayout(cardLayout);
		
		ragistrationPage.setBackground(Color.DARK_GRAY);
		viewPort.add(ragistrationPage);
		viewPort.add(orderPage);
		
		
	}
	   private void createWindow()
	    {
	    	frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
	        frame.setTitle("Mail Service");
	        frame.setBounds(120,120,800,400);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(false);
	    }
	   
	   public void addComponentsToFrame() {
		   frame.add(navBar);
		   frame.setContentPane(viewPort);
//		   cardLayout.show(viewPort, "ragistrationPage");

	   }
	   
	    private void setFreamIcon() {
	    	ImageIcon img = new ImageIcon("images/icon4.png");
	    	// iconURL is null when not found
	    	frame.setIconImage(img.getImage());
	    }

}
