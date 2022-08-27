package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.sign_up.MyActionListener;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Admin_login extends JFrame {

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
					Admin_login frame = new Admin_login();
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
	public Admin_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 484);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 295, 429);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Admin_login.class.getResource("/BookstoreManagementSystem/images/3.png")));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(320, 111, 476, 51);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit ");
		btnNewButton.setBounds(349, 357, 112, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(575, 357, 122, 35);
		contentPane.add(btnNewButton_1);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtrUsername.setText("Username");
		txtrUsername.setBounds(320, 78, 122, 22);
		contentPane.add(txtrUsername);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setText("Password");
		txtrPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtrPassword.setBounds(320, 214, 97, 22);
		contentPane.add(txtrPassword);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Login");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(426, 23, 231, 35);
		contentPane.add(lblNewLabel_2);
		
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(320, 247, 476, 60);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		MyActionListener n=new MyActionListener();
		getContentPane().add(txtrUsername);
		getContentPane().add(textField);
		getContentPane().add(txtrPassword);
		getContentPane().add(textField_1);
		btnNewButton .addActionListener(n);
		btnNewButton_1.addActionListener(n);
	}
	
	

public class MyActionListener implements ActionListener
{
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
    	if("Submit ".equals(ae.getActionCommand()))
    	{
    		if(textField.getText().isEmpty() || textField_1.getText().isEmpty())
    		{
    			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
    		}
    		else {
    			if(Admin.check_creditentials(textField.getText())==true && Admin.check_pass(textField_1.getText())==true )
    			{
    				Admin_menu m=new Admin_menu();
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

