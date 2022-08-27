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

import BookstoreManagementSystem.view_author.MyActionListener;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view_cat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_cat frame = new view_cat();
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
	public view_cat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(5, 5, 424, 432);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(22, 25, 89, 47);
		panel.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String q=("Select * from category");
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
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubmit.setBounds(241, 25, 89, 47);
		panel.add(btnSubmit);
		
		table = new JTable();
		table.setBounds(10, 90, 404, 331);
		panel.add(table);
		
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    if("Back".equals(ae.getActionCommand()))
	    	{
	    	Categorymenu p=new Categorymenu();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}

}
