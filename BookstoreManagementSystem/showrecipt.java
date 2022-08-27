package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.reciptmenu.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

public class showrecipt extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showrecipt frame = new showrecipt();
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
	public showrecipt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 153));
		panel.setBounds(5, 5, 424, 428);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(showrecipt.class.getResource("/BookstoreManagementSystem/images/books.jpg")));
		lblNewLabel.setBounds(10, 5, 303, 168);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(105, 236, 256, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrReciptId = new JTextArea();
		txtrReciptId.setText("Recipt id");
		txtrReciptId.setBounds(10, 234, 85, 22);
		panel.add(txtrReciptId);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(41, 355, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(247, 355, 89, 23);
		panel.add(btnNewButton_1);
		
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
		
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    if("Submit".equals(ae.getActionCommand()))
	    	{
	    	if(textField.getText().isEmpty())
	    	{
	    		JOptionPane.showMessageDialog(null, "Please fill the text Field");
	    	}
	    	else
	    	{
	    	try {
				//Scanner input=new Scanner(System.in);
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
				PreparedStatement pst =con.prepareStatement("SELECT recipt_id ,date,placeorder_order_id  from  recipt");
				String q=("SELECT recipt_id ,date,placeorder_order_id  from  recipt where recipt_id= "+textField.getText());
				Statement stmt=con.createStatement();
				ResultSet rs = pst.executeQuery();
				 if(stmt.executeUpdate(q)==0) {
					 JOptionPane.showMessageDialog(null, "no record to show\n");
		           }
				 else {
					 JOptionPane.showMessageDialog(null, "Recipt_id" + "     "+"Date"+"     "+ "Order id");
				
				while(rs.next()) {
					JOptionPane.showMessageDialog(null,rs.getString(1)+"    "+rs.getDate(2)+"    "+ rs.getString(3));
					
				}}
			}
			
			catch(Exception e) {
				System.out.println("EXCEPTION!!\n"+e.toString());
			
	    		
	    	}
	    	}
	   
	    	}
	    
	    else if("Back".equals(ae.getActionCommand()))
    	{
	    	reciptmenu p=new reciptmenu();
    		p.setVisible(true);
    		dispose();
    	}
	    
		}
}
}
