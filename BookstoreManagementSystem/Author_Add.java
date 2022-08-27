package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.update_price.MyActionListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Author_Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Author_Add frame = new Author_Add();
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
	public Author_Add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 153));
		panel.setBounds(0, 11, 424, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Author_Add.class.getResource("/BookstoreManagementSystem/images/books2.jpg")));
		lblNewLabel.setBounds(10, 11, 287, 157);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(102, 197, 208, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 248, 208, 31);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(101, 305, 209, 31);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JTextArea txtrAuthorId = new JTextArea();
		txtrAuthorId.setText("Author ID ");
		txtrAuthorId.setBounds(10, 200, 82, 28);
		panel.add(txtrAuthorId);
		
		JTextArea txtrName = new JTextArea();
		txtrName.setText("Username ");
		txtrName.setBounds(10, 251, 82, 28);
		panel.add(txtrName);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setText("Password ");
		txtrPassword.setBounds(10, 305, 81, 31);
		panel.add(txtrPassword);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(31, 343, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit ");
		btnNewButton_1.setBounds(219, 347, 89, 23);
		panel.add(btnNewButton_1);
		
		MyActionListener n=new MyActionListener();
		//getContentPane().add(panel)
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
        	if("Submit ".equals(ae.getActionCommand()))
        	{
        		if(textField.getText().isEmpty() && textField_1.getText().isEmpty() && textField_2.getText().isEmpty() )
        		{
        			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
        		}
        		else
        		{
        			if(Author.check_id(textField.getText())==true ) 
        			{
        				if(Author.repeat_id(textField.getText())==true)
        				{
        					if(Author.check_authname(textField_1.getText())==true )
        					{
        						if(Author.repeat_username(textField_1.getText())==true)
        						{
        							if(Author.check_authpass(textField_2.getText())==true)
        							{
        								Author.writetodatabase(textField_1.getText(), textField_2.getText(), textField.getText());
        								JOptionPane.showMessageDialog(null,"Successfully stored");
        							}
        							else
        							{
        								JOptionPane.showMessageDialog(null,"Enter password of length 8 only ");
        							}
        						}
        						else
        						{
        							JOptionPane.showMessageDialog(null,"This username is already taken");
        						}
        					}
        					else
        					{
        						JOptionPane.showMessageDialog(null,"Enter the correct name");
        					}
        				}
        				else
        				{
        					JOptionPane.showMessageDialog(null,"This id is already taken");
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
