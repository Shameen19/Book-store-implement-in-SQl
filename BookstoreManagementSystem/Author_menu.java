package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.view_books.MyActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Author_menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Author_menu frame = new Author_menu();
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
	public Author_menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(10, 76, 424, 178);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Author_menu.class.getResource("/BookstoreManagementSystem/images/books.jpg")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Authors .....");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(51, 0, 153));
		lblNewLabel_1.setBounds(49, 11, 301, 54);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add Author");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(10, 283, 102, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Author");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(160, 283, 102, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search ");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(314, 283, 110, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete ");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_3.setBounds(89, 351, 102, 37);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(248, 351, 89, 37);
		contentPane.add(btnNewButton_4);
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
		btnNewButton_2.addActionListener(n);
		btnNewButton_3.addActionListener(n);
		btnNewButton_4.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    if("Add Author".equals(ae.getActionCommand()))
	    	{
	    	Author_Add p=new Author_Add();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    else if("View Author".equals(ae.getActionCommand()))
    	{
	    	view_author p=new view_author();
    		p.setVisible(true);
    		dispose();
    	}
	    else if("Search ".equals(ae.getActionCommand()))
    	{
	    	Search_author p=new Search_author();
    		p.setVisible(true);
    		dispose();
    	}
	    else if("Delete ".equals(ae.getActionCommand()))
    	{
	    	Delete_author p=new Delete_author();
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
