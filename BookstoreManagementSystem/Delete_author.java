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

import BookstoreManagementSystem.Search_author.MyActionListener;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Delete_author extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_author frame = new Delete_author();
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
	public Delete_author() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(10, 11, 424, 378);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(10, 323, 89, 44);
		panel.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(211, 323, 89, 44);
		panel.add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(94, 200, 246, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrAuthorId = new JTextArea();
		txtrAuthorId.setText("Author ID");
		txtrAuthorId.setBounds(10, 200, 74, 37);
		panel.add(txtrAuthorId);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Delete_author.class.getResource("/BookstoreManagementSystem/images/books.jpg")));
		lblNewLabel.setBounds(22, 11, 304, 142);
		panel.add(lblNewLabel);
		
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnSubmit.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
        	if("Submit".equals(ae.getActionCommand()))
        	{
        		if(textField.getText().isEmpty()  )
        		{
        			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
        		}
        		else
        		{
        			if(Author.check_id(textField.getText())==true ) 
        			{
        				
        					if(Author.delete_author(textField.getText())==true)
        					{
        						JOptionPane.showMessageDialog(null,"Author Deleted");
        					}
        					else
        					{
        						JOptionPane.showMessageDialog(null,"ID not found");
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
