package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Customer_login.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class myAccount extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myAccount frame = new myAccount();
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
	public myAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 243, 429);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(myAccount.class.getResource("/BookstoreManagementSystem/images/3.png")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("My Account ");
		lblNewLabel_1.setFont(new Font("Pristina", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_1.setBounds(282, 22, 232, 61);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Place order ");
		btnNewButton.setBounds(258, 94, 123, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("My information");
		btnNewButton_1.setBounds(306, 149, 123, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Log out");
		btnNewButton_2.setBounds(421, 261, 123, 61);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Feedback");
		btnNewButton_1_1.setBounds(408, 201, 123, 52);
		contentPane.add(btnNewButton_1_1);
		
		MyActionListener n=new MyActionListener();
		btnNewButton .addActionListener(n);
		btnNewButton_1.addActionListener(n);
		btnNewButton_1.addActionListener(n);
		btnNewButton_2 .addActionListener(n);
		btnNewButton_1_1.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    	if("My information".equals(ae.getActionCommand()))
	    	{
	    		My_info m=new My_info();
	    		m.setVisible(true);
	    		dispose();
	    	}
	    	else if ("Place order ".equals(ae.getActionCommand()))
	    	{
	    		ordermenu c=new ordermenu();
	    		c.setVisible(true);
	    		dispose();
	    	}
	    	else if ("Feedback".equals(ae.getActionCommand()))
	    	{
	    		 Feedbackadd c=new  Feedbackadd();
	    		c.setVisible(true);
	    		dispose();
	    	}
	    	else if ("Log out".equals(ae.getActionCommand()))
	    	{
	    		log_in c=new log_in();
	    		c.setVisible(true);
	    		dispose();
	    	}
		}
		}

}
