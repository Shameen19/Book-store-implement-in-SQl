package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Admin_menu.MyActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addbooks extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addbooks frame = new Addbooks();
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
	public Addbooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 492);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(5, 5, 229, 437);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book Record Here....");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 203, 186, 152);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(-60, 0, 350, 192);
		lblNewLabel.setIcon(new ImageIcon(Addbooks.class.getResource("/BookstoreManagementSystem/images/books.jpg")));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Books");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(265, 35, 117, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Books");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(265, 110, 117, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Books");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(265, 187, 117, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete Books");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(265, 266, 117, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Search Books");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(265, 343, 117, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Back");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_5.setBounds(265, 399, 117, 23);
		contentPane.add(btnNewButton_5);
		
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
		btnNewButton_2.addActionListener(n);
		btnNewButton_3.addActionListener(n);
		btnNewButton_4.addActionListener(n);
		btnNewButton_5.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    	if("Add Books".equals(ae.getActionCommand()))
	    	{
	    		sign_up s=new sign_up();
	    		s.setVisible(true);
	    		dispose();
	    	}
	    	else if("View Books".equals(ae.getActionCommand()))
	    	{
	    		view_books p=new view_books();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    	else if("Search Books".equals(ae.getActionCommand()))
	    	{
	    		search_bookgui p=new search_bookgui();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    	else if("Update Books".equals(ae.getActionCommand()))
	    	{
	    		update_menu p=new update_menu();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    	else if("Delete Books".equals(ae.getActionCommand()))
	    	{
	    		delete_book p=new delete_book();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    	else if("Back".equals(ae.getActionCommand()))
	    	{
	    		Admin_menu p=new Admin_menu();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}

}
