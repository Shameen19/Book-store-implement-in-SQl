package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Admin_login.MyActionListener;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
public class view_books extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_books frame = new view_books();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection connection=null;
	/**
	 * Create the frame.
	 */
	public view_books() {
		connection=connectionclass.dbConnector();
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add(l);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.RIGHT, TitledBorder.BELOW_TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.add(l);
		
		JButton btnNewButton = new JButton("display data ");
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.setForeground(new Color(0, 51, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setSelectedIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 try {
						String q=("Select * from books");
						PreparedStatement s=connection.prepareStatement(q);
						ResultSet r=s.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(r));
						if(!r.next())
						{
							JOptionPane.showMessageDialog(null, "Nothing more to display");
						}
						
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				 
			}
		});
		btnNewButton.setBounds(45, 65, 110, 38);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 381, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(153, 51, 204));
		btnNewButton_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(302, 65, 89, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Display Book Data ");
		lblNewLabel.setBackground(new Color(204, 255, 204));
		lblNewLabel.setForeground(new Color(0, 0, 204));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(114, 23, 174, 31);
		contentPane.add(lblNewLabel);
		
		MyActionListener n=new MyActionListener();
		btnNewButton_1.addActionListener(n);
		//add(l);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    if("Back".equals(ae.getActionCommand()))
	    	{
	    	Addbooks p=new Addbooks();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}
}
