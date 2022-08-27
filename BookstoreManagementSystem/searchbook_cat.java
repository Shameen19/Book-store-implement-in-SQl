package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.view_author.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class searchbook_cat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchbook_cat frame = new searchbook_cat();
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
	public searchbook_cat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(5, 5, 424, 448);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(searchbook_cat.class.getResource("/BookstoreManagementSystem/images/books2.jpg")));
		lblNewLabel.setBounds(10, 5, 291, 140);
		panel.add(lblNewLabel);
		
		JTextArea txtrIsbn = new JTextArea();
		txtrIsbn.setText("ISBN");
		txtrIsbn.setBounds(10, 233, 65, 35);
		panel.add(txtrIsbn);
		
		textField = new JTextField();
		textField.setBounds(102, 235, 248, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(29, 391, 89, 46);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit ");
		btnNewButton_1.setBounds(213, 391, 89, 46);
		panel.add(btnNewButton_1);
		
		MyActionListener n=new MyActionListener();
		btnNewButton_1.addActionListener(n);
		btnNewButton.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			if("Submit ".equals(ae.getActionCommand()))
	    	{
	    		if( textField.getText().isEmpty())
	    		{
	    			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
	    		}
	    		else
	    		{
	    			if(supplier.check_id(textField.getText())==true)
	    				{
	    					if(supplier.search_supplier(textField.getText())==true)
	    					{
	    						try {
	    			    			//Scanner input=new Scanner(System.in);
	    			    			Class.forName("oracle.jdbc.driver.OracleDriver");
	    			    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject","shahid");
	    			    			PreparedStatement pst =con.prepareStatement("SELECT category_name ,category_2,books_isbn,books_title from  category");
	    			    			String q=("SELECT category_name ,category_2,books_isbn,books_title  from  category where books_isbn= "+textField.getText());
	    			    			Statement stmt=con.createStatement();
	    			    			ResultSet rs = pst.executeQuery(q);
	    			    			 
	    			    				 JOptionPane.showMessageDialog(null,"Category1"+"  "+"Catgeory2"+"   "+"Isbn"+"  "+"Title");
	    			    			while(rs.next()) {
	    			    				
	    			    				JOptionPane.showMessageDialog(null,rs.getString(1)+"    " +rs.getString(2)+"    "+rs.getString(3)+"    " +rs.getString(4));
	    			    			}}
	    						catch(Exception e)
	    						{
	    							System.out.println(e.toString());
	    						}
	    					}
	    					else
	    					{
	    						JOptionPane.showMessageDialog(null,"No record to show");
	    					}
	    				}
	    				else
	    				{
	    					JOptionPane.showMessageDialog(null,"Enter correct id");
	    				}
	    			}
	    			
	    		}
	    
	    	else if("Back".equals(ae.getActionCommand()))
	    	{
	    		Categorymenu p=new Categorymenu();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
		}
}

