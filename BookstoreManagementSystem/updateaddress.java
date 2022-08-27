package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.updatecontact.MyActionListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class updateaddress extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateaddress frame = new updateaddress();
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
	public updateaddress() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(0, 0, 424, 449);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Address");
		lblNewLabel.setBackground(new Color(204, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(55, 5, 309, 53);
		panel.add(lblNewLabel);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setText("Username");
		txtrUsername.setBounds(10, 102, 115, 22);
		panel.add(txtrUsername);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(137, 102, 205, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setText("Password");
		txtrPassword.setBounds(10, 181, 81, 22);
		panel.add(txtrPassword);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setBounds(137, 181, 205, 40);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea txtrAddress = new JTextArea();
		txtrAddress.setText("Address");
		txtrAddress.setBounds(10, 247, 81, 22);
		panel.add(txtrAddress);
		
		textField_2 = new JTextField();
		textField_2.setBounds(137, 239, 205, 40);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(15, 398, 89, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(253, 398, 89, 40);
		panel.add(btnNewButton_1);
		
		MyActionListener n=new MyActionListener();
		btnNewButton .addActionListener(n);
		btnNewButton_1.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			if("Submit ".equals(ae.getActionCommand()))
	    	{
	    	if(textField.getText().isEmpty() && textField_1.getText().isEmpty() && textField_2.getText().isEmpty())
	    		{
	    		JOptionPane.showMessageDialog(null, "Please fill all the text feilds");
	    		}
	    	else
	    	{
	    		if(Customer.check_username(textField.getText())==true)
	    		{
	    		if(Customer.check_pass(textField_1.getText())==true)
	    		{
	    				
	    					if(Customer.update_address(textField.getText(), textField_1.getText(), textField_2.getText())==true)
	    					{
	    						JOptionPane.showMessageDialog(null, "Successfully updated");
	    					}
	    					else
	    					{
	    						JOptionPane.showMessageDialog(null, "No Id found");
	    					}
	    				}
	    				
	    	
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "Enter only charachter of length 8");
	    		}
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "Improper format of name");
	    		}
	    	}
	    	}
	    	else if("Back".equals(ae.getActionCommand()))
	    	{
	    		 My_info p=new  My_info();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}

}

}
