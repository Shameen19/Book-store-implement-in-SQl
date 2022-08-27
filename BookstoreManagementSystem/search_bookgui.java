package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Addbooks.MyActionListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class search_bookgui extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search_bookgui frame = new search_bookgui();
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
	public search_bookgui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 204));
		panel.setBounds(0, 0, 424, 444);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Books Here....");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(new Color(255, 153, 153));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(20, 32, 333, 120);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(48, 391, 89, 42);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(255, 204, 255));
		btnNewButton_1.setBounds(287, 391, 89, 42);
		panel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(24, 185, 367, 49);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea txtrName = new JTextArea();
		txtrName.setText("Name");
		txtrName.setBounds(20, 152, 110, 22);
		panel.add(txtrName);
		
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
	    		if( textField_1.getText().isEmpty())
	    		{
	    			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
	    		}
	    		else
	    		{
	    			if(Booksrecord.check_name(textField_1.getText())==true)
	    				{
	    					if(Booksrecord.search_book(textField_1.getText())==true)
	    					{
	    						try {
	    			    			//Scanner input=new Scanner(System.in);
	    			    			Class.forName("oracle.jdbc.driver.OracleDriver");
	    			    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject","shahid");
	    			    			PreparedStatement pst =con.prepareStatement("SELECT isbn ,title,language,price,quantity  from  books");
	    			    			String q=("SELECT isbn ,title,langugae,price,quantity  from  books where title= "+textField_1.getText());
	    			    			Statement stmt=con.createStatement();
	    			    			ResultSet rs = pst.executeQuery(q);
	    			    			 
	    			    				 JOptionPane.showMessageDialog(null,"ISBN"+"  "+"Title"+"  "+"Language"+"  "+"Price"+"  "+"Quantity");
	    			    			while(rs.next()) {
	    			    				
	    			    				JOptionPane.showMessageDialog(null,rs.getString(1)+"    " +rs.getString(2)+"    "+rs.getString(3)+"      "+rs.getString(4)+"       "+rs.getString(5));
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
	    					JOptionPane.showMessageDialog(null,"Enter correct name");
	    				}
	    			}
	    			
	    		}
	    
	    	else if("Back".equals(ae.getActionCommand()))
	    	{
	    		Addbooks p=new Addbooks();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}

}
