package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Author_menu.MyActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Categorymenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categorymenu frame = new Categorymenu();
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
	public Categorymenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setBounds(5, 5, 424, 433);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Categorymenu.class.getResource("/BookstoreManagementSystem/images/1.jpg")));
		lblNewLabel.setBounds(10, 5, 288, 179);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(28, 229, 89, 39);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(169, 229, 89, 39);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(307, 229, 89, 39);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(150, 312, 89, 39);
		panel.add(btnNewButton_3);
		
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
		btnNewButton_2.addActionListener(n);
		btnNewButton_3.addActionListener(n);
		
	}
	
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    if("Add".equals(ae.getActionCommand()))
	    	{
	    	add_cat p=new add_cat();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    else if("Search".equals(ae.getActionCommand()))
    	{
	    	searchbook_cat p=new searchbook_cat() ;
    		p.setVisible(true);
    		dispose();
    	}
	    else if("View".equals(ae.getActionCommand()))
    	{
	    	view_cat p=new view_cat();
    		p.setVisible(true);
    		dispose();
    	}
	    else if("Back".equals(ae.getActionCommand()))
    	{
	    	Delete_author p=new Delete_author();
    		p.setVisible(true);
    		dispose();
    	}
	   
	    
		}
}


}
