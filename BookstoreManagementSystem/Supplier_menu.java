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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Supplier_menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supplier_menu frame = new Supplier_menu();
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
	public Supplier_menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(5, 5, 424, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Supplier_menu.class.getResource("/BookstoreManagementSystem/images/coffe.jpg")));
		lblNewLabel.setBounds(59, 42, 286, 150);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(22, 230, 89, 39);
		panel.add(btnNewButton);
		
		JButton btnViewSupplier = new JButton("View ");
		btnViewSupplier.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewSupplier.setBounds(144, 230, 89, 39);
		panel.add(btnViewSupplier);
		
		JButton btnSearchSupplier = new JButton("Search ");
		btnSearchSupplier.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearchSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearchSupplier.setBounds(275, 230, 89, 39);
		panel.add(btnSearchSupplier);
		
		JButton btnDelete = new JButton("Delete ");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(86, 295, 89, 39);
		panel.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(216, 295, 89, 39);
		panel.add(btnBack);
		
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnViewSupplier.addActionListener(n);
		btnSearchSupplier.addActionListener(n);
		btnDelete.addActionListener(n);
		btnBack.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    if("Add ".equals(ae.getActionCommand()))
	    	{
	    	Add_supplier p=new Add_supplier();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    else if("View ".equals(ae.getActionCommand()))
    	{
	    	view_supplier p=new view_supplier();
    		p.setVisible(true);
    		dispose();
    	}
	    else if("Search ".equals(ae.getActionCommand()))
    	{
	    	Search_supplier p=new Search_supplier();
    		p.setVisible(true);
    		dispose();
    	}
	    else if("Delete ".equals(ae.getActionCommand()))
    	{
	    	Delete_supplier p=new Delete_supplier();
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
