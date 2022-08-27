package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.view_books.MyActionListener;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view_supplier extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_supplier frame = new view_supplier();
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
	Connection connection=null;
	private JTable table;
	public view_supplier() {
		connection=connectionclass.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(5, 5, 424, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String q=("Select * from supplier");
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
		btnNewButton.setBounds(24, 11, 89, 35);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(220, 11, 89, 35);
		panel.add(btnBack);
		
		table = new JTable();
		table.setBounds(10, 67, 404, 303);
		panel.add(table);
		
		MyActionListener n=new MyActionListener();
		btnBack.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    if("Back".equals(ae.getActionCommand()))
	    	{
	    	Supplier_menu p=new Supplier_menu();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}
}
