package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.sign_up.MyActionListener;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Home_page() {
		setTitle("Book STore Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 503);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(5, 5, 287, 435);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(0, 11, 287, 177);
		lblNewLabel.setIcon(new ImageIcon(Home_page.class.getResource("/BookstoreManagementSystem/images/books2.jpg")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to Online Book Store ");
		lblNewLabel_1.setBackground(new Color(255, 255, 153));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(0, 239, 287, 109);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(204, 255, 204));
		btnNewButton.setBounds(342, 182, 89, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log IN");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(255, 255, 153));
		btnNewButton_1.setBounds(495, 182, 89, 44);
		contentPane.add(btnNewButton_1);
		
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
		
		setVisible(true);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
        	if("Sign up".equals(ae.getActionCommand()))
        	{
        		customer_signup c=new customer_signup();
        		c.setVisible(true);
        		dispose();
        	}
        	else if("Log IN".equals(ae.getActionCommand()))
        	{
        		log_in l=new log_in();
        		l.setVisible(true);
        		dispose();
        	}
			
		}
		
	}
}
