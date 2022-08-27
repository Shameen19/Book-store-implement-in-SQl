package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.GenerateRecipt.MyActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class shippingmeny extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shippingmeny frame = new shippingmeny();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public shippingmeny() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 424, 442);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(99, 5, 301, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 80, 293, 51);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(104, 182, 292, 51);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(96, 275, 304, 51);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea txtrPayment = new JTextArea();
		txtrPayment.setText("payment");
		txtrPayment.setBounds(10, 12, 79, 22);
		panel.add(txtrPayment);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setText("Username");
		txtrUsername.setBounds(10, 93, 83, 22);
		panel.add(txtrUsername);
		
		JTextArea txtrCnic = new JTextArea();
		txtrCnic.setText("Cnic");
		txtrCnic.setBounds(10, 195, 84, 22);
		panel.add(txtrCnic);
		
		JTextArea txtrOrderId = new JTextArea();
		txtrOrderId.setText("Order id ");
		txtrOrderId.setBounds(10, 288, 76, 22);
		panel.add(txtrOrderId);
		
		JButton btnNewButton = new JButton("Submit ");
		btnNewButton.setBounds(211, 391, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(21, 391, 89, 23);
		panel.add(btnNewButton_1);
		
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
	}
	
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			
	    if("Submit".equals(ae.getActionCommand()))
	    	{
	    	if(textField.getText().isEmpty() && textField_1.getText().isEmpty() && textField_2.getText().isEmpty() && textField_3.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please fill all the textFields");
			}
			else
			{
	    	 if(shipping.check_cnic(textField_1.getText())==true)
	    	 {
	    		 if(shipping.check_username(textField_2.getText())==true)
	    		 {
	    			 
	    			 if(shipping.check_orderid(textField_3.getText())==true) {
	    				 shipping.shippingdays(textField.getText(), textField_1.getText(), textField_2.getText(),textField_3.getText());
	    				 JOptionPane.showMessageDialog(null, "YOUR ORDER WILL BE SHIPPED IN TWO THREE DAYS");
	    				 
	    			 }
	    			 else
	    			 {
	    				 JOptionPane.showMessageDialog(null, "Enter in the format xxx");
	    			 }
	    		 } 
	    		 else
	    		 {
	    			 JOptionPane.showMessageDialog(null, "Enter only chrchters");
	    		 }
	    	 }
	    	 else
	    	 {
	    		 JOptionPane.showMessageDialog(null, "Enter in format i-e xxxxxxxxxxxxx");
	    	 }
	    	}
	    	}
	    else if("Back".equals(ae.getActionCommand()))
    	{
	    	myAccount p=new myAccount();
    		p.setVisible(true);
    		dispose();
    	}
	    
		}
		}


}
