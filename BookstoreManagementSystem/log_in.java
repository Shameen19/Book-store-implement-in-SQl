package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Admin_menu.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class log_in extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log_in frame = new log_in();
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
	public log_in() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 471);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 110, 240, 189);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(log_in.class.getResource("/BookstoreManagementSystem/images/1.jpg")));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Customer Login");
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(296, 110, 131, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admin Login");
		btnNewButton_1.setBackground(new Color(204, 204, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(382, 193, 131, 53);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Home");
		btnNewButton_1_1.setBackground(new Color(204, 204, 255));
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(442, 270, 131, 53);
		contentPane.add(btnNewButton_1_1);
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
		btnNewButton_1_1.addActionListener(n);
		
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    	if("Admin Login".equals(ae.getActionCommand()))
	    	{
	    		Admin_login l=new Admin_login();
	    		l.setVisible(true);
	    		dispose();
		}
	    	else if("Customer Login".equals(ae.getActionCommand()))
	    			{
	    		Customer_login c=new Customer_login();
	    		c.setVisible(true);
	    		dispose();
	    			}
	    	else if("Home".equals(ae.getActionCommand()))
			{
	    		Home_page p=new Home_page();
	    		p.setVisible(true);
	    		dispose();
			}
		}
		}
}
