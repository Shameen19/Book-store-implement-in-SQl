package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.updatecontact.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class updatepassword extends JFrame {

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
					updatepassword frame = new updatepassword();
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
	public updatepassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(5, 5, 463, 448);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update password");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel.setBounds(28, 5, 412, 97);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 136, 404, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setText("Username");
		txtrUsername.setBounds(10, 103, 75, 22);
		panel.add(txtrUsername);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setText("Password");
		txtrPassword.setBounds(20, 192, 65, 22);
		panel.add(txtrPassword);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setBounds(10, 225, 404, 33);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea txtrUpdatedPassword = new JTextArea();
		txtrUpdatedPassword.setText("Updated Password");
		txtrUpdatedPassword.setBounds(10, 286, 145, 22);
		panel.add(txtrUpdatedPassword);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 328, 404, 37);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(10, 393, 89, 44);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.setBounds(272, 393, 89, 44);
		panel.add(btnNewButton_1);
		
		MyActionListener n=new MyActionListener();
		btnNewButton .addActionListener(n);
		btnNewButton_1.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			if("Submit".equals(ae.getActionCommand()))
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
	    				if(Customer.check_pass(textField_2.getText())==true)
	    				{
	    					if(Customer.update_password(textField.getText(), textField_1.getText(), textField_2.getText())==true)
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
	    					JOptionPane.showMessageDialog(null, "Enter only 8 chrachter password");
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
	    	else if("back".equals(ae.getActionCommand()))
	    	{
	    		 My_info p=new  My_info();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}

}

}
