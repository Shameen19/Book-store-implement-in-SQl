package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Author_menu.MyActionListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Publisher_menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Publisher_menu frame = new Publisher_menu();
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
	public Publisher_menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 153));
		panel.setBounds(5, 5, 424, 376);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Publisher_menu.class.getResource("/BookstoreManagementSystem/images/coffe.jpg")));
		lblNewLabel.setBounds(74, 22, 281, 166);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(22, 217, 89, 44);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(144, 217, 89, 44);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(266, 217, 89, 44);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(78, 272, 89, 44);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(211, 272, 89, 44);
		panel.add(btnNewButton_4);
		
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
	    if("Add ".equals(ae.getActionCommand()))
	    	{
	    	Add_publisher p=new Add_publisher();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    else if("View".equals(ae.getActionCommand()))
    	{
	    	 view_publisher p=new  view_publisher();
    		p.setVisible(true);
    		dispose();
    	}
	    else if("Delete".equals(ae.getActionCommand()))
    	{
	    	delete_pub p=new delete_pub();
    		p.setVisible(true);
    		dispose();
    	}
	    else if("Search".equals(ae.getActionCommand()))
    	{
	    	search_pub p=new search_pub();
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
