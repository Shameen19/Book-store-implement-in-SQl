package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.search_bookgui.MyActionListener;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class delete_book extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_book frame = new delete_book();
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
	public delete_book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(20, 361, 89, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(240, 374, 89, 41);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(121, 172, 208, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrName = new JTextArea();
		txtrName.setText("Name ");
		txtrName.setBounds(10, 180, 75, 22);
		contentPane.add(txtrName);
		
		JLabel lblNewLabel = new JLabel("Delete books here ...");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setBounds(20, 11, 358, 150);
		contentPane.add(lblNewLabel);
		
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
	    		if( textField.getText().isEmpty())
	    		{
	    			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
	    		}
	    		else
	    		{
	    			if(Booksrecord.check_name(textField.getText())==true)
	    				{
	    					
	    					if(Booksrecord.search_book(textField.getText())==true)
	    					{
	    						if(Booksrecord.delete_book(textField.getText())==true)
	    						{
	    							JOptionPane.showMessageDialog(null,"Successfull");
	    						}
	    						else
	    						{
	    							JOptionPane.showMessageDialog(null,"Record not found");
	    						}
	    					}
	    					else
	    					{
	    						JOptionPane.showMessageDialog(null,"No such book found");
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
