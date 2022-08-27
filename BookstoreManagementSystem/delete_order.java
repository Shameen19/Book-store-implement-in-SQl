package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Placeorder.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;

public class delete_order extends JFrame {

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
					delete_order frame = new delete_order();
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
	public delete_order() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 153));
		panel.setBounds(5, 5, 424, 444);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(delete_order.class.getResource("/BookstoreManagementSystem/images/books2.jpg")));
		lblNewLabel.setBounds(33, 5, 288, 149);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(141, 182, 240, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 245, 240, 31);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(10, 352, 89, 23);
		panel.add(btnNewButton);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setText("Username");
		txtrUsername.setBounds(10, 180, 89, 22);
		panel.add(txtrUsername);
		
		JTextArea txtrCnic = new JTextArea();
		txtrCnic.setText("CNIC");
		txtrCnic.setBounds(10, 243, 76, 22);
		panel.add(txtrCnic);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(213, 352, 89, 23);
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
	    		if(textField.getText().isEmpty() && textField_1.getText().isEmpty() )
	    		{
	    			JOptionPane.showMessageDialog(null,"Please fill all the text Feilds");
	    		}
	    		else
	    		{
	    			if(order.check_name(textField.getText())==true)
	    			{
	    				if(order.check_cnic(textField_1.getText())==true)
	    				{
	    					if(order.delete(textField.getText(), textField_1.getText())==true)
	    					{
	    						JOptionPane.showMessageDialog(null,"Order deleted");
	    					}
	    					else
	    					{
	    						JOptionPane.showMessageDialog(null,"You are not registered");
	    					}
	    				}
	    				else
	    				{
	    					JOptionPane.showMessageDialog(null,"Enter correct format i-e xxxxxxxxxxxxx");
	    				}
	    			}
	    			else
	    			{
	    				JOptionPane.showMessageDialog(null,"Enter only chrachters");
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
