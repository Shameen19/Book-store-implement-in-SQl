package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.sign_up.MyActionListener;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Admin_menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_menu frame = new Admin_menu();
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
	public Admin_menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 483);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 285, 410);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Admin_menu.class.getResource("/BookstoreManagementSystem/images/3.png")));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Books");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(329, 26, 105, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Author");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(329, 81, 105, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supplier");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_2.setBounds(329, 130, 105, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Publisher ");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_3.setBounds(329, 180, 105, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Log out");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(329, 366, 105, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_3_1 = new JButton("Category");
		btnNewButton_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setBounds(329, 230, 105, 23);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("View Feedback");
		btnNewButton_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_3_1_1.setBackground(Color.WHITE);
		btnNewButton_3_1_1.setBounds(314, 274, 120, 23);
		contentPane.add(btnNewButton_3_1_1);
		
		JButton btnNewButton_3_1_1_1 = new JButton("View Order");
		btnNewButton_3_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_3_1_1_1.setBackground(Color.WHITE);
		btnNewButton_3_1_1_1.setBounds(314, 319, 120, 23);
		contentPane.add(btnNewButton_3_1_1_1);
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
		btnNewButton_2.addActionListener(n);
		btnNewButton_3.addActionListener(n);
		btnNewButton_4.addActionListener(n);
		btnNewButton_3_1.addActionListener(n);
		btnNewButton_3_1_1.addActionListener(n);
		btnNewButton_3_1_1_1.addActionListener(n);
		
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    	if("Books".equals(ae.getActionCommand()))
	    	{
	    		Addbooks a=new Addbooks();
	    		a.setVisible(true);
	    		dispose();
	    	}
	    	else if("Author".equals(ae.getActionCommand()))
	    	{
	    		Author_menu p=new Author_menu();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    	else if("Supplier".equals(ae.getActionCommand()))
	    	{
	    		Supplier_menu p=new Supplier_menu();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    	else if("Publisher ".equals(ae.getActionCommand()))
	    	{
	    		Publisher_menu p=new Publisher_menu();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    	else if("Category".equals(ae.getActionCommand()))
	    	{
	    		Categorymenu p=new Categorymenu();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    	else if("View Feedback".equals(ae.getActionCommand()))
	    	{
	    		view_all_feedbacks p=new view_all_feedbacks();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    	else if("View Order".equals(ae.getActionCommand()))
	    	{
	    		view_all_orders p=new view_all_orders();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    	else if("Log out".equals(ae.getActionCommand()))
	    	{
	    		Home_page p=new Home_page();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}
}
