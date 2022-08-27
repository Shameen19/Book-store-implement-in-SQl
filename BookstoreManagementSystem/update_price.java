package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.sign_up.MyActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class update_price extends JFrame {

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
					update_price frame = new update_price();
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
	public update_price() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(10, 11, 424, 420);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtrIsbn = new JTextArea();
		txtrIsbn.setText("ISBN");
		txtrIsbn.setBounds(10, 128, 58, 22);
		panel.add(txtrIsbn);
		
		textField = new JTextField();
		textField.setBounds(111, 125, 159, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrPrice = new JTextArea();
		txtrPrice.setText("Price");
		txtrPrice.setBounds(23, 203, 58, 22);
		panel.add(txtrPrice);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setBounds(111, 200, 159, 31);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Back ");
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setBounds(23, 311, 89, 45);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit ");
		btnNewButton_1.setBounds(201, 311, 89, 45);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Price  Update.....");
		lblNewLabel.setForeground(new Color(51, 0, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(66, 30, 204, 45);
		panel.add(lblNewLabel);
		
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
        		if(textField.getText().isEmpty() && textField_1.getText().isEmpty() )
        		{
        			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
        		}
        		else
        		{
        			if(Booksrecord.check_Isbn(textField.getText())==true) 
        			{
        				if(Booksrecord.check_int(textField_1.getText())==true)
        				{
        					int a=Integer.parseInt(textField_1.getText());
							if(Booksrecord.price_check(a)==true)
							{
								if(Booksrecord.update_price(textField.getText(), a)==true)
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
        	else if("Back ".equals(ae.getActionCommand())) {
        		update_menu h1=new update_menu();
        		h1.setVisible(true);
        		dispose();
        	}
			
		}
		
	}
}
