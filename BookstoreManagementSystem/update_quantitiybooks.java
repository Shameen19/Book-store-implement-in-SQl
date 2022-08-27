package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.update_price.MyActionListener;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class update_quantitiybooks extends JFrame {

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
					update_quantitiybooks frame = new update_quantitiybooks();
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
	public update_quantitiybooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 255));
		panel.setBounds(5, 5, 424, 429);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(29, 239, 89, 42);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(200, 239, 89, 42);
		panel.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(89, 160, 213, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrIsbn = new JTextArea();
		txtrIsbn.setText("ISBN");
		txtrIsbn.setBounds(10, 94, 69, 34);
		panel.add(txtrIsbn);
		
		JTextArea txtrQuantity = new JTextArea();
		txtrQuantity.setText("Quantity");
		txtrQuantity.setBounds(10, 164, 69, 34);
		panel.add(txtrQuantity);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(89, 90, 213, 32);
		panel.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Update Quantity");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(29, 28, 351, 42);
		panel.add(lblNewLabel);
		
		MyActionListener n=new MyActionListener();
		//getContentPane().add(panel)
		btnNewButton.addActionListener(n);
		 btnBack.addActionListener(n);
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
        			if(Booksrecord.check_Isbn(textField_1.getText())==true) 
        			{
        				if(Booksrecord.check_int(textField.getText())==true)
        				{
        					int a=Integer.parseInt(textField.getText());
							if(Booksrecord.price_check(a)==true)
							{
								if(Booksrecord.update_quan(textField_1.getText(), a)==true)
								{
									JOptionPane.showMessageDialog(null,"Successfully stored data");
								}
								else
								{
									JOptionPane.showMessageDialog(null,"No id found");
								}
								
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Please enter price greater than 0");
							}
        				}
        				else
        				{
        					JOptionPane.showMessageDialog(null,"Enter only digits");
        				}
        	         }
        			else
        			{
        				JOptionPane.showMessageDialog(null,"Enter the correct format of ISBN i-e xxxxxxxx");
        			}
        		}
        	}
        	else if("Back".equals(ae.getActionCommand())) {
        		update_menu h1=new update_menu();
        		h1.setVisible(true);
        		dispose();
        	}
			
		}
		
	}
}
