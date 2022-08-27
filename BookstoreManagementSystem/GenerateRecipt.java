package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Add_publisher.MyActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class GenerateRecipt extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateRecipt frame = new GenerateRecipt();
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
	public GenerateRecipt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 102));
		panel.setBounds(5, 5, 424, 428);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GenerateRecipt.class.getResource("/BookstoreManagementSystem/images/1.jpg")));
		lblNewLabel.setBounds(10, 5, 284, 141);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(113, 192, 301, 46);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 249, 301, 52);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea txtrReciptId = new JTextArea();
		txtrReciptId.setText("Recipt Id");
		txtrReciptId.setBounds(10, 192, 72, 46);
		panel.add(txtrReciptId);
		
		JTextArea txtrOrderId = new JTextArea();
		txtrOrderId.setText("Order id");
		txtrOrderId.setBounds(10, 249, 72, 52);
		panel.add(txtrOrderId);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(26, 366, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(193, 366, 89, 23);
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
	    	if(textField.getText().isEmpty() && textField_1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please fill all the textFields");
			}
			else
			{
	    	 if(Receipt.check_orderid(textField.getText())==true)
	    	 {
	    		 if(Receipt.check_orderid(textField_1.getText())==true)
	    		 {
	    			 if(Receipt.add_recipt(textField.getText(), textField_1.getText())==true)
	    			 {
	    				 JOptionPane.showMessageDialog(null, "Your recipt has been generated");
	    			 }
	    			 else
	    			 {
	    				 JOptionPane.showMessageDialog(null, "Your order is notfound try again");
	    			 }
	    		 } 
	    		 else
	    		 {
	    			 JOptionPane.showMessageDialog(null, "Enter in format i-e xxx");
	    		 }
	    	 }
	    	 else
	    	 {
	    		 JOptionPane.showMessageDialog(null, "Enter in format i-e xxx");
	    	 }
	    	}
	    	}
	    else if("Back".equals(ae.getActionCommand()))
    	{
	    	Publisher_menu p=new Publisher_menu();
    		p.setVisible(true);
    		dispose();
    	}
	    
		}
		}

}
