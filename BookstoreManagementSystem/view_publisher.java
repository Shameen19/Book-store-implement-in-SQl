package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.view_books.MyActionListener;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class view_publisher extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_publisher frame = new view_publisher();
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
	public view_publisher() {
		
		connection=connectionclass.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String q=("Select * from pubisher");
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
		btnNewButton.setBounds(25, 29, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(211, 29, 89, 23);
		panel.add(btnNewButton_1);
		
		table = new JTable();
		table.setBounds(10, 71, 404, 301);
		panel.add(table);
		MyActionListener n=new MyActionListener();
		btnNewButton_1.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    if("Back".equals(ae.getActionCommand()))
	    	{
	    	Publisher_menu p=new Publisher_menu();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}

}
