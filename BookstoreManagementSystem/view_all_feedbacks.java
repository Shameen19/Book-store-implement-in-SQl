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
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view_all_feedbacks extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_all_feedbacks frame = new view_all_feedbacks();
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
	public view_all_feedbacks() {
		connection=connectionclass.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(5, 5, 424, 441);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(28, 32, 89, 42);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String q=("Select * from feedback");
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(223, 32, 89, 42);
		panel.add(btnNewButton_1);
		
		table = new JTable();
		table.setBounds(10, 98, 404, 332);
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
	    	Admin_menu p=new Admin_menu();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}

}
