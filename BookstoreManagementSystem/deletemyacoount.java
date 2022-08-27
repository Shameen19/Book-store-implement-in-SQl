package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.updateaddress.MyActionListener;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class deletemyacoount extends JFrame {

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
					deletemyacoount frame = new deletemyacoount();
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
	public deletemyacoount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(5, 5, 424, 437);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete My account");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setBounds(22, 11, 376, 61);
		panel.add(lblNewLabel);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setFont(new Font("MS Gothic", Font.BOLD | Font.ITALIC, 16));
		txtrUsername.setText("Username");
		txtrUsername.setBounds(22, 118, 79, 22);
		panel.add(txtrUsername);
		
		textField = new JTextField();
		textField.setBounds(15, 161, 369, 61);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setFont(new Font("MS Gothic", Font.BOLD | Font.ITALIC, 16));
		txtrPassword.setText("Password");
		txtrPassword.setBounds(22, 250, 79, 22);
		panel.add(txtrPassword);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setBounds(10, 296, 374, 70);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(22, 391, 89, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(230, 391, 89, 35);
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
	    	if(textField.getText().isEmpty() && textField_1.getText().isEmpty() )
	    		{
	    		JOptionPane.showMessageDialog(null, "Please fill all the text feilds");
	    		}
	    	else
	    	{
	    		if(Customer.check_username(textField.getText())==true)
	    		{
	    		if(Customer.check_pass(textField_1.getText())==true)
	    		{
	    				
	    					if(Customer.delete_cust(textField.getText(), textField_1.getText())==true)
	    					{
	    						JOptionPane.showMessageDialog(null, "Successfully Deleted");
	    						log_in l=new log_in();
	    						l.setVisible(true);
	    						dispose();
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
