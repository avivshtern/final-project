package DronePost;
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

 

public class DroneOrderForm extends JFrame {
 
  private JButton btnSend  = new JButton("Order");

  private JButton btnClear = new JButton("Clear");

  private JTextField txtPickup = new JTextField();

  private JTextField txtSender = new JTextField();

  private JTextField txtRes = new JTextField();

  private JTextField txtA = new JTextField();

  private JTextField txtA1 = new JTextField();

  private JTextField txtB = new JTextField();

  private JTextField txtB1 = new JTextField();

  private JTextField txtC = new JTextField();

  private JTextField txtC1 = new JTextField();

  private JTextField txtD = new JTextField();

  private JTextField txtD1 = new JTextField();

 

  private JLabel lblPickup = new JLabel("Pickup Loaction:");

  private JLabel lblDrop = new JLabel("Drop Loaction:");

  private JLabel lblSender = new JLabel("Sender:");

  private JLabel lblRes = new JLabel("Recipient:");

  private JLabel lblA = new JLabel("Country:");

  private JLabel lblB = new JLabel("City:");

  private JLabel lblC = new JLabel("Address:");

  private JLabel lblD = new JLabel("Zip Code:");

  DroneSystem droneSystem;

  public DroneOrderForm(DroneSystem droneSystem){
    super();
    this.droneSystem = droneSystem;
    setTitle("Shipping Ordering Form");
    setSize(600,350);
    setLocation(new Point(350,300));
    setLayout(null);   
    setVisible(true);
    setResizable(false);
    initComponent();   
    initEvent();   
  }

  private void initComponent(){

    btnSend.setBounds(300,230, 80,25);

    btnClear.setBounds(400,230, 110,25);

    txtA.setBounds(150,25,100,20);

    txtA1.setBounds(350,25,100,20);

    txtB.setBounds(150,55,100,20);

    txtB1.setBounds(350,55,100,20);

    txtC.setBounds(150,85,100,20);

    txtC1.setBounds(350,85,100,20);

    txtD.setBounds(150,115,100,20);

    txtD1.setBounds(350,115,100,20);

    txtSender.setBounds(150,145,100,20);

    txtRes.setBounds(350,145,100,20);

    lblA.setBounds(20,25,100,20);

    lblB.setBounds(20,55,100,20);

    lblC.setBounds(20,85,100,20);

    lblD.setBounds(20,115,100,20);

    lblPickup.setBounds(5,0,100,20);

    lblDrop.setBounds(320,0,100,20);

    lblSender.setBounds(20,145,100,20);

    lblRes.setBounds(280,145,100,20);

    add(btnSend);

    add(btnClear);

    add(lblA);

    add(lblB);

    add(lblC);

    add(lblD);

    add(lblPickup);

    add(lblSender);

    add(lblDrop);

    add(lblRes);

    add(txtA);

    add(txtB);

    add(txtC);

    add(txtD);

    add(txtSender);

    add(txtA1);

    add(txtB1);

    add(txtC1);

    add(txtD1);

    add(txtRes);

  }

  private void initEvent(){

    this.addWindowListener(new WindowAdapter() {

     public void windowClosing(WindowEvent e){

     System.exit(1);

      }

    });

 

    btnSend.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        btnSendClick(e);

      }

    });

 

    btnClear.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        btnClearClick(e);

      }

    });

  }

 

  private void btnSendClick(ActionEvent evt){

    System.exit(0);

  }

 

  private void btnClearClick(ActionEvent evt){

  }

}

