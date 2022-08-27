package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Admin_login.MyActionListener;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Customer_login extends JFrame {

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
					Customer_login frame = new Customer_login();
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
	public Customer_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(5, 5, 811, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(53, 391, 89, 43);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnBack.setBounds(183, 391, 89, 43);
		panel.add(btnBack);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setFont(new Font("Javanese Text", Font.BOLD | Font.ITALIC, 15));
		txtrUsername.setText("Username");
		txtrUsername.setBounds(10, 93, 117, 40);
		panel.add(txtrUsername);
		
		textField = new JTextField();
		textField.setBounds(10, 144, 265, 48);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setFont(new Font("Javanese Text", Font.BOLD | Font.ITALIC, 15));
		txtrPassword.setText("Password");
		txtrPassword.setBounds(10, 216, 89, 22);
		panel.add(txtrPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 253, 265, 43);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Customer Log IN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(new Color(102, 51, 204));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(78, 30, 293, 63);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(new Color(102, 153, 204));
		lblNewLabel_1.setIcon(new ImageIcon(Customer_login.class.getResource("/BookstoreManagementSystem/images/inn.jpg")));
		lblNewLabel_1.setBounds(10, 0, 791, 445);
		panel.add(lblNewLabel_1);
		
		MyActionListener n=new MyActionListener();
		btnNewButton .addActionListener(n);
		btnBack.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    	if("Submit".equals(ae.getActionCommand()))
	    	{
	    		if(textField.getText().isEmpty() && textField_1.getText().isEmpty())
	    		{
	    			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
	    		}
	    		else 
	    		{
	    			if(Customer.check_creditentialsc(textField.getText())==true && Customer.check_password(textField_1.getText())==true )
	    			{
	    				JOptionPane.showMessageDialog(null, "Access Granted");
	    				myAccount m=new myAccount();
	    				m.setVisible(true);
	    				dispose();
	    			}
	    			else
	    			{
	    				JOptionPane.showMessageDialog(null, "Access Denied");
	    			}
	    		}
	    	}
	    	else if ("Back".equals(ae.getActionCommand()))
	    	{
	    		log_in c=new log_in();
	    		c.setVisible(true);
	    		dispose();
	    	}
		}
		}
}
