package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Publisher_menu.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_publisher extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_publisher frame = new Add_publisher();
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
	public Add_publisher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(5, 5, 424, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Add_publisher.class.getResource("/BookstoreManagementSystem/images/books.jpg")));
		lblNewLabel.setBounds(61, 0, 305, 201);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(97, 212, 294, 41);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 278, 294, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea txtrId = new JTextArea();
		txtrId.setText("ID");
		txtrId.setBounds(10, 212, 77, 41);
		panel.add(txtrId);
		
		JTextArea txtrName = new JTextArea();
		txtrName.setText("Name");
		txtrName.setBounds(10, 266, 77, 41);
		panel.add(txtrName);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(208, 347, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(38, 347, 89, 23);
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
	    	if(textField.getText().isEmpty() && textField_1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please fill all the textFields");
			}
			else
			{
	    	 if(Publisher.check_id(textField.getText())==true)
	    	 {
	    		 if(Publisher.repeat_id(textField.getText())==true)
	    		 {
	    			 if(Publisher.check_pubname(textField_1.getText())==true)
	    			 {
	    				 Publisher.writetodatabase(textField.getText(), textField_1.getText());
	    				 JOptionPane.showMessageDialog(null, "Successfully stores");
	    				 
	    			 }
	    			 else
	    			 {
	    				 JOptionPane.showMessageDialog(null, "Enter only charachetrs");
	    			 }
	    		 }
	    		 else
	    		 {
	    			 JOptionPane.showMessageDialog(null, "This id is already taken");
	    		 }
	    	 }
	    	 else
	    	 {
	    		 JOptionPane.showMessageDialog(null, "Enter in format i-e xxxxx");
	    	 }
	    	}
	    	}
	    else if("Back".equals(ae.getActionCommand()))
    	{
	    	Publisher_menu p=new Publisher_menu();
    		p.setVisible(true);
    		dispose();
    	}
	    
		}
		}

}
