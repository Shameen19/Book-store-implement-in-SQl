package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.myAccount.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Placeorder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Placeorder frame = new Placeorder();
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
	public Placeorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(5, 5, 424, 433);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Placeorder.class.getResource("/BookstoreManagementSystem/images/coffe.jpg")));
		lblNewLabel.setBounds(10, 5, 289, 136);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(121, 156, 263, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 202, 263, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(121, 235, 263, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(121, 276, 263, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(121, 317, 263, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(121, 358, 263, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JTextArea txtrOrderId = new JTextArea();
		txtrOrderId.setText("Order ID");
		txtrOrderId.setBounds(10, 154, 101, 22);
		panel.add(txtrOrderId);
		
		JTextArea txtrQuantity = new JTextArea();
		txtrQuantity.setText("Quantity");
		txtrQuantity.setBounds(10, 200, 101, 22);
		panel.add(txtrQuantity);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setText("Username");
		txtrUsername.setBounds(10, 233, 101, 22);
		panel.add(txtrUsername);
		
		JTextPane txtpnCnic = new JTextPane();
		txtpnCnic.setText("CNIC");
		txtpnCnic.setBounds(10, 276, 101, 20);
		panel.add(txtpnCnic);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(92, 371, -75, 20);
		panel.add(textPane_1);
		
		JTextPane txtpnIsbn = new JTextPane();
		txtpnIsbn.setText("ISBN");
		txtpnIsbn.setBounds(10, 317, 101, 20);
		panel.add(txtpnIsbn);
		
		JTextPane txtpnTitle = new JTextPane();
		txtpnTitle.setText("Title");
		txtpnTitle.setBounds(10, 358, 101, 20);
		panel.add(txtpnTitle);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(79, 399, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(225, 399, 89, 23);
		panel.add(btnNewButton_1);
		
		MyActionListener n=new MyActionListener();
		btnNewButton .addActionListener(n);
		btnNewButton_1.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    	if("Submit".equals(ae.getActionCommand()))
	    	{
	    		if(textField.getText().isEmpty() && textField_1.getText().isEmpty()  &&  textField_3.getText().isEmpty() &&  textField_4.getText().isEmpty() &&  textField_5.getText().isEmpty() &&  textField_6.getText().isEmpty() )
	    		{
	    			JOptionPane.showMessageDialog(null,"Please fill all the text Feilds");
	    		}
	    		else
	    		{
	    			if(order.check_orderid(textField.getText())==true)
	    			{
	    				if(order.check_int(textField_1.getText())==true)
	    				{
	    					int a=Integer.parseInt(textField_1.getText());
	    					if(order.price_check(a)==true)
	    					{
	    						if(order.check_Isbn(textField_5.getText())==true)
	    						{
	    							if(order.check_name(textField_6.getText())==true)
	    							{
	    								if(order.book_check(textField_5.getText(),textField_6.getText())==true)
	    								{
	    									if(order.check_cnic(textField_4.getText())==true)
	    									{
	    										if(order.check_name(textField_3.getText())==true)
	    										{
	    											if(order.search_user(textField_3.getText(), textField_4.getText())==true)
	    											{
	    												order.place_order(textField.getText(), a,textField_3.getText(),textField_4.getText(), textField_5.getText(),textField_6.getText());
	    												JOptionPane.showMessageDialog(null,"Order stored");
	    											}
	    											else
	    											{
	    												JOptionPane.showMessageDialog(null,"You are not registered");
	    											}
	    											
	    										}
	    									}
	    									else
	    									{
	    										JOptionPane.showMessageDialog(null,"Invalid name");
	    									}
	    								}
	    								else
	    								{
	    									JOptionPane.showMessageDialog(null,"Enter books i-e xxxxxxxxxxxxx");
	    								}
	    							}
	    								else
	    								{
	    									JOptionPane.showMessageDialog(null,"Book not found");
	    								}
	    							}
	    							else
	    							{
	    								JOptionPane.showMessageDialog(null,"Enter only charachters");
	    							}
	    						}
	    						else
	    						{
	    							JOptionPane.showMessageDialog(null,"Enter in format i-e xxxxxxxx");
	    						}
	    					}
	    					else
	    					{
	    						JOptionPane.showMessageDialog(null,"Enter value greater than 0");
	    					}
	    				}
	    				else
	    				{
	    					JOptionPane.showMessageDialog(null,"Enter Digits only");
	    				}
	    			}
	    	}
	    	
	    	
	    	else if ("Back".equals(ae.getActionCommand()))
	    	{
	    		ordermenu c=new ordermenu();
	    		c.setVisible(true);
	    		dispose();
	    	}
		}
		}

}
