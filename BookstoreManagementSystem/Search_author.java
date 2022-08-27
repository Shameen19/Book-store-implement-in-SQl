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

import BookstoreManagementSystem.delete_book.MyActionListener;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Search_author extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_author frame = new Search_author();
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
	public Search_author() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 255));
		panel.setBounds(5, 5, 424, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(113, 175, 269, 44);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrAuthorId = new JTextArea();
		txtrAuthorId.setText("Author ID ");
		txtrAuthorId.setBounds(10, 175, 93, 44);
		panel.add(txtrAuthorId);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(14, 295, 89, 34);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit ");
		btnNewButton_1.setBounds(173, 295, 89, 34);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Search_author.class.getResource("/BookstoreManagementSystem/images/1.jpg")));
		lblNewLabel.setBounds(45, 26, 284, 126);
		panel.add(lblNewLabel);
		
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
        	if("Submit ".equals(ae.getActionCommand()))
        	{
        		if(textField.getText().isEmpty()  )
        		{
        			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
        		}
        		else
        		{
        			if(Author.check_id(textField.getText())==true ) 
        			{
        				
        					try {
    			    			//Scanner input=new Scanner(System.in);
    			    			Class.forName("oracle.jdbc.driver.OracleDriver");
    			    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject","shahid");
    			    			PreparedStatement pst =con.prepareStatement("SELECT auth_name ,auth_password,auth_id from  author");
    			    			String q=("SELECT auth_name ,auth_password,auth_id  from  author where auth_id= "+textField.getText());
    			    			Statement stmt=con.createStatement();
    			    			ResultSet rs = pst.executeQuery(q);
    			    			 
    			    				 JOptionPane.showMessageDialog(null,"Name"+"  "+"Password"+"  "+"ID");
    			    			while(rs.next()) {
    			    				
    			    				JOptionPane.showMessageDialog(null,rs.getString(1)+"    " +rs.getString(2)+"    "+rs.getString(3));
    			    			}}
    						catch(Exception e)
    						{
    							System.out.println(e.toString());
    						}
        				
        			}
        			else
        			{
        				JOptionPane.showMessageDialog(null,"Please enter in format xxxxx");
        			}
        				
        		}

}
        	else if("Back".equals(ae.getActionCommand()))
        	{
        		Author_menu a=new Author_menu();
        		a.setVisible(true);
        		dispose();
        	}
		}
	}

}
