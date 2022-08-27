package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Search_supplier.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class search_pub extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search_pub frame = new search_pub();
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
	public search_pub() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 153));
		panel.setBounds(5, 5, 424, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(search_pub.class.getResource("/BookstoreManagementSystem/images/coffe.jpg")));
		lblNewLabel.setBounds(78, 13, 287, 197);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(93, 223, 287, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrId = new JTextArea();
		txtrId.setText("ID");
		txtrId.setBounds(20, 221, 63, 32);
		panel.add(txtrId);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(37, 310, 89, 44);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(218, 310, 89, 44);
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
	    		if( textField.getText().isEmpty())
	    		{
	    			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
	    		}
	    		else
	    		{
	    			if(Publisher.check_id(textField.getText())==true)
	    				{
	    					if(Publisher.search_publihser(textField.getText())==true)
	    					{
	    						try {
	    			    			//Scanner input=new Scanner(System.in);
	    			    			Class.forName("oracle.jdbc.driver.OracleDriver");
	    			    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject","shahid");
	    			    			PreparedStatement pst =con.prepareStatement("SELECT publisher_id ,pub_name from  publisher");
	    			    			String q=("SELECT publisher_id ,pub_name  from  publisher where publisher_id= "+textField.getText());
	    			    			Statement stmt=con.createStatement();
	    			    			ResultSet rs = pst.executeQuery(q);
	    			    			 
	    			    				 JOptionPane.showMessageDialog(null,"ID"+"  "+"Name");
	    			    			while(rs.next()) {
	    			    				
	    			    				JOptionPane.showMessageDialog(null,rs.getString(1)+"    " +rs.getString(2));
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
	    		Supplier_menu p=new Supplier_menu();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}

}
