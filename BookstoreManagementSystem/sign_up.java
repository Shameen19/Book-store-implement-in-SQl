package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sign_up extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sign_up frame = new sign_up();
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
	public sign_up() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 499);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 291, 455);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("We Keep Your books Safe Here .......");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(5, 253, 282, 59);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 11, 282, 243);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(sign_up.class.getResource("/BookstoreManagementSystem/images/1.jpg")));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Submit ");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(324, 405, 89, 32);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setBounds(458, 405, 89, 32);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setBounds(324, 32, 246, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(324, 103, 246, 37);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(324, 184, 246, 37);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(324, 265, 246, 37);
		contentPane.add(textField_3);
		
		JTextArea txtrIsbn = new JTextArea();
		txtrIsbn.setText(" ISBN");
		txtrIsbn.setBounds(324, 11, 67, 22);
		contentPane.add(txtrIsbn);
		
		JTextArea txtrTitle = new JTextArea();
		txtrTitle.setText("Title");
		txtrTitle.setBounds(334, 80, 67, 22);
		contentPane.add(txtrTitle);
		
		JTextArea txtrLanguage = new JTextArea();
		txtrLanguage.setText("Language");
		txtrLanguage.setBounds(334, 151, 67, 22);
		contentPane.add(txtrLanguage);
		
		JTextArea txtrPrice = new JTextArea();
		txtrPrice.setText("Price");
		txtrPrice.setBounds(324, 232, 67, 22);
		contentPane.add(txtrPrice);
		
		textField_4 = new JTextField();
		textField_4.setBounds(324, 346, 246, 33);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtQuantity.setText("Quantity ");
		txtQuantity.setBounds(324, 301, 86, 32);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		
		MyActionListener n=new MyActionListener();
		getContentPane().add(txtrIsbn);
		getContentPane().add(textField);
		getContentPane().add(txtrTitle);
		getContentPane().add(textField_1);
		getContentPane().add(txtrLanguage);
		getContentPane().add(textField_2 );
		getContentPane().add(txtrPrice);
		getContentPane().add(textField_3);
		getContentPane().add(txtQuantity);
		getContentPane().add(textField_4);
		btnNewButton.addActionListener(n);
		btnCancel.addActionListener(n);
		
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
        	if("Submit ".equals(ae.getActionCommand()))
        	{
        		if(textField.getText().isEmpty() && textField_1.getText().isEmpty() && textField_2.getText().isEmpty() && textField_3.getText().isEmpty())
        		{
        			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
        		}
        		else
        		{
        			if(Booksrecord.check_Isbn(textField.getText())==true) 
        			{
        				if(Booksrecord.repeat_isbn(textField.getText())==true)
        				{
        					if(Booksrecord.check_name(textField_1.getText())==true) 
        					{
        						if(Booksrecord.repeat_name(textField_1.getText())==true)
        						{
        							if(Booksrecord.check_leang(textField_2.getText())==true)
        							{
        								if(Booksrecord.check_int(textField_3.getText())==true)
        								{
        									int a=Integer.parseInt(textField_3.getText());
        									if(Booksrecord.price_check(a)==true)
        									{
        										if(Booksrecord.check_int(textField_4.getText())==true)
        										{
        											int b=Integer.parseInt(textField_4.getText());
        											if(Booksrecord.price_check(b)==true)
        											{
        												Booksrecord.writetodatabase(textField.getText(), textField_1.getText(), textField_3.getText(), a,b);
                										JOptionPane.showMessageDialog(null,"Successfully Stored your record");
        											}
        											else
        											{
        												JOptionPane.showMessageDialog(null,"Please enter Quantity greater than 0");
        											}
        										
        										
        									}
        										else
        										{
        											JOptionPane.showMessageDialog(null,"Enter digits only");
        										}
        									}
        									else
        									{
        										JOptionPane.showMessageDialog(null,"Please enter price greater than 0");
        									}
        				        		}
        								else
        								{
        									JOptionPane.showMessageDialog(null,"Please enter digits");
        				        		}
        								}
        							else
        							{
        								JOptionPane.showMessageDialog(null,"Please enter a correct language");
        							}
        						}
        						else
        						{
        							JOptionPane.showMessageDialog(null,"This book name  is already taken:Enter a unique one ");
        						}
        					}
        					else
        					{
        						JOptionPane.showMessageDialog(null,"Enter correct name ");
        					}
        				}
        			
        				else
        				{
        					JOptionPane.showMessageDialog(null,"This ISBN is already taken:Enter a unique one ");
        				}
        				
        			}
        			else {
        				JOptionPane.showMessageDialog(null,"Enter the correct format");
        			}
        		}
        	}
        	else if("Cancel".equals(ae.getActionCommand())) {
        		Addbooks h1=new Addbooks();
        		h1.setVisible(true);
        		dispose();
        	}
			
		}
		
	}
}
