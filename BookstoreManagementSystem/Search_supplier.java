package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.search_bookgui.MyActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Search_supplier extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_supplier frame = new Search_supplier();
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
	public Search_supplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 102));
		panel.setBounds(5, 5, 424, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(106, 202, 270, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrId = new JTextArea();
		txtrId.setText("ID");
		txtrId.setBounds(10, 202, 86, 26);
		panel.add(txtrId);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(36, 281, 89, 43);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(224, 281, 89, 43);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(204, 153, 153));
		lblNewLabel.setIcon(new ImageIcon(Search_supplier.class.getResource("/BookstoreManagementSystem/images/1.jpg")));
		lblNewLabel.setBounds(73, 22, 283, 157);
		panel.add(lblNewLabel);
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
	    			if(supplier.check_id(textField.getText())==true)
	    				{
	    					if(supplier.search_supplier(textField.getText())==true)
	    					{
	    						try {
	    			    			//Scanner input=new Scanner(System.in);
	    			    			Class.forName("oracle.jdbc.driver.OracleDriver");
	    			    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject","shahid");
	    			    			PreparedStatement pst =con.prepareStatement("SELECT suppliername ,supplier_id from  supplier");
	    			    			String q=("SELECT suppliername ,supplier_id  from  supplier where supplier_id= "+textField.getText());
	    			    			Statement stmt=con.createStatement();
	    			    			ResultSet rs = pst.executeQuery(q);
	    			    			 
	    			    				 JOptionPane.showMessageDialog(null,"Name"+"  "+"ID");
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
