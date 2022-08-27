package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;

import BookstoreManagementSystem.view_books.MyActionListener;
public class view_author extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_author frame = new view_author();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	public view_author() {
		connection=connectionclass.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 507);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 102));
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Display Authors");
		btnNewButton.setForeground(new Color(0, 0, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String q=("Select * from author");
					PreparedStatement s=connection.prepareStatement(q);
					ResultSet r=s.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(r));
					if(!r.next())
					{
						JOptionPane.showMessageDialog(null, "Nothing more to display");
					}
				} 
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(20, 11, 164, 52);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 443, 383);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("back");
		btnBack.setForeground(new Color(0, 0, 102));
		btnBack.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnBack.setBounds(268, 11, 120, 52);
		contentPane.add(btnBack);
		
		MyActionListener n=new MyActionListener();
		 btnBack.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    if("back".equals(ae.getActionCommand()))
	    	{
	    	Author_menu p=new Author_menu();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}
}
