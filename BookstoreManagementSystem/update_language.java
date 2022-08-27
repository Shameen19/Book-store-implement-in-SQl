package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.update_price.MyActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class update_language extends JFrame {

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
					update_language frame = new update_language();
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
	public update_language() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(5, 5, 424, 428);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 67, 388, 54);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrIsbn = new JTextArea();
		txtrIsbn.setText("ISBN");
		txtrIsbn.setBounds(10, 34, 97, 22);
		panel.add(txtrIsbn);
		
		JTextArea txtrLanguage = new JTextArea();
		txtrLanguage.setText("Language");
		txtrLanguage.setBounds(10, 159, 97, 22);
		panel.add(txtrLanguage);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 159, 5, 22);
		panel.add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 204, 388, 48);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Back ");
		btnNewButton.setBounds(10, 346, 89, 43);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setBounds(218, 346, 89, 43);
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
			if("Submit".equals(ae.getActionCommand()))
        	{
        		if(textField.getText().isEmpty() && textField_1.getText().isEmpty() )
        		{
        			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
        		}
        		else
        		{
        			if(Booksrecord.check_Isbn(textField.getText())==true) 
        			{
        				if(Booksrecord.check_leang(textField_1.getText())==true)
        				{
        					if(Booksrecord.update_lang(textField.getText(), textField_1.getText())==true)
        					{
        						JOptionPane.showMessageDialog(null,"Successfully stored");
        					}
        					else
        					{
        						JOptionPane.showMessageDialog(null,"No id found");
        					}
							
        				}
        				else
        				{
        					JOptionPane.showMessageDialog(null,"Enter only chrachter");
        				}
        	         }
        			else
        			{
        				JOptionPane.showMessageDialog(null,"Enter the correct format of ISBN i-e xxxxxxxx");
        			}
        		}
        	}
        	
        	else if("Back ".equals(ae.getActionCommand())) {
        		update_menu h1=new update_menu();
        		h1.setVisible(true);
        		dispose();
        	}
			
		}
		
	}

}
