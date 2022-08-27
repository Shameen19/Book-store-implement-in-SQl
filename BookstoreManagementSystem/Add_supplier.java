package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Supplier_menu.MyActionListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_supplier extends JFrame {

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
					Add_supplier frame = new Add_supplier();
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
	public Add_supplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 102));
		panel.setBounds(5, 5, 424, 379);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Add_supplier.class.getResource("/BookstoreManagementSystem/images/1.jpg")));
		lblNewLabel.setBounds(71, 11, 285, 207);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(144, 229, 212, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 275, 211, 34);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea txtrName = new JTextArea();
		txtrName.setText("Name");
		txtrName.setBounds(10, 229, 97, 35);
		panel.add(txtrName);
		
		JTextArea txtrId = new JTextArea();
		txtrId.setText("ID ");
		txtrId.setBounds(10, 275, 97, 34);
		panel.add(txtrId);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(43, 320, 89, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(196, 320, 89, 35);
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
	    	 if(supplier.check_supname(textField.getText())==true)
	    	 {
	    		 if(supplier.check_id(textField_1.getText())==true)
	    		 {
	    			 if(supplier.repeat_id(textField_1.getText())==true)
	    			 {
	    				 supplier.writetodatabase(textField.getText(), textField_1.getText());
	    				 JOptionPane.showMessageDialog(null, "Successfully stores");
	    				 
	    			 }
	    			 else
	    			 {
	    				 JOptionPane.showMessageDialog(null, "This id is already taken");
	    			 }
	    		 }
	    		 else
	    		 {
	    			 JOptionPane.showMessageDialog(null, "Invalid format of id i-e xxxxx");
	    		 }
	    	 }
	    	 else
	    	 {
	    		 JOptionPane.showMessageDialog(null, "Enter only charachters");
	    	 }
	    	}
	    	}
	    else if("Back".equals(ae.getActionCommand()))
    	{
	    	Supplier_menu p=new Supplier_menu();
    		p.setVisible(true);
    		dispose();
    	}
	    
		}
		}
}

