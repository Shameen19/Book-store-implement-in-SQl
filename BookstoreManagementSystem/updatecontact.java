package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.myAccount.MyActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;

public class updatecontact extends JFrame {

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
					updatecontact frame = new updatecontact();
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
	public updatecontact() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(10, 11, 424, 409);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(27, 347, 89, 51);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(219, 347, 89, 51);
		panel.add(btnNewButton_1);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setText("Username");
		txtrUsername.setBounds(10, 25, 106, 22);
		panel.add(txtrUsername);
		
		textField = new JTextField();
		textField.setBounds(10, 58, 351, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrContactNo = new JTextArea();
		txtrContactNo.setText("Contact no");
		txtrContactNo.setBounds(10, 216, 106, 22);
		panel.add(txtrContactNo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 244, 351, 45);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setText("Password");
		txtrPassword.setBounds(10, 112, 76, 22);
		panel.add(txtrPassword);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setBounds(10, 156, 351, 31);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
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
	    		if(Customer.check_pass(textField_2.getText())==true)
	    		{
	    				if(Customer.check_contact(textField_1.getText())==true)
	    				{
	    					if(Customer.update_contact(textField.getText(), textField_2.getText(), textField_1.getText())==true)
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
	    					JOptionPane.showMessageDialog(null, "Improper format of number i-e xxxx-xxxxxxx");
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