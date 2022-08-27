package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Addbooks.MyActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;

public class customer_signup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer_signup frame = new customer_signup();
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
	public customer_signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 255));
		panel.setBounds(-13, 0, 667, 453);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(new Color(255, 204, 204));
		btnNewButton.setForeground(new Color(51, 0, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnNewButton.setBounds(85, 388, 89, 54);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(255, 204, 204));
		btnNewButton_1.setForeground(new Color(51, 0, 102));
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnNewButton_1.setBounds(361, 388, 89, 54);
		panel.add(btnNewButton_1);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setText("Username");
		txtrUsername.setBounds(26, 79, 79, 22);
		panel.add(txtrUsername);
		
		JTextArea txtrCnic = new JTextArea();
		txtrCnic.setText("CNIC");
		txtrCnic.setBounds(26, 120, 79, 22);
		panel.add(txtrCnic);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setText("Password");
		txtrPassword.setBounds(26, 168, 79, 22);
		panel.add(txtrPassword);
		
		JTextArea txtrPassword_1 = new JTextArea();
		txtrPassword_1.setText("Contact");
		txtrPassword_1.setBounds(26, 215, 79, 22);
		panel.add(txtrPassword_1);
		
		JTextArea txtrAddress = new JTextArea();
		txtrAddress.setText("Address");
		txtrAddress.setBounds(26, 269, 61, 22);
		panel.add(txtrAddress);
		
		textField = new JTextField();
		textField.setBounds(114, 75, 286, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 122, 291, 37);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(112, 217, 288, 43);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(115, 170, 285, 36);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sign up");
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(144, 11, 148, 63);
		panel.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(114, 271, 286, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(customer_signup.class.getResource("/BookstoreManagementSystem/images/log.jpg")));
		lblNewLabel_1.setBounds(455, 11, 202, 202);
		panel.add(lblNewLabel_1);
		
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
	    	if(textField.getText().isEmpty() && textField_1.getText().isEmpty() && textField_2.getText().isEmpty() && textField_3.getText().isEmpty() && textField_4.getText().isEmpty())
	    		{
	    		JOptionPane.showMessageDialog(null, "Please fill all the text feilds");
	    		}
	    	else
	    	{
	    		if(Customer.check_username(textField.getText())==true)
	    		{
	    			if(Customer.repeat_username(textField.getText())==true)
	    			{
	    				if(Customer.check_cnic(textField_1.getText())==true)
	    				{
	    					if(Customer.repeat_cnic(textField_1.getText())==true)
	    					{
	    						if(Customer.check_pass(textField_3.getText())==true)
	    						{
	    							if(Customer.check_contact(textField_2.getText())==true)
	    							{
	    								Customer.writetodatabase(textField.getText(),textField_1.getText(), textField_3.getText(), textField_2.getText(), textField_4.getText());
	    								JOptionPane.showMessageDialog(null, "Successfuly stored your data ");
	    								
	    							}
	    							else
	    							{
	    								JOptionPane.showMessageDialog(null, "Enter the correct number i-e xxxx-xxxxxxx");
	    							}
	    						}
	    						else
	    						{
	    							JOptionPane.showMessageDialog(null, "Enter the password of length 8 only ");
	    						}
	    					}
	    					else
	    					{
	    						JOptionPane.showMessageDialog(null, "This cnic is already taken ");
	    					}
	    				}
	    				else
	    				{
	    					JOptionPane.showMessageDialog(null, "Improper format of cninc:Enter in xxxxxxxxxxxxxxx");
	    				}
	    			}
	    			else
	    			{
	    				JOptionPane.showMessageDialog(null, "This username is already taken");
	    			}
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "Improper format of name:Enter only chracters");
	    		}
	    	}
	    		
	    	}
	    	else if("Back".equals(ae.getActionCommand()))
	    	{
	    		Home_page p=new Home_page();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}
}
