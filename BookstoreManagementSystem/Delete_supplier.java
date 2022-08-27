package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Supplier_menu.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Delete_supplier extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_supplier frame = new Delete_supplier();
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
	public Delete_supplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 380);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Delete_supplier.class.getResource("/BookstoreManagementSystem/images/books2.jpg")));
		lblNewLabel.setBounds(10, 5, 291, 183);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(98, 225, 255, 39);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrId = new JTextArea();
		txtrId.setText("ID");
		txtrId.setBounds(10, 223, 78, 41);
		panel.add(txtrId);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(24, 317, 89, 39);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(187, 317, 89, 39);
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
	    	if(textField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please fill all feilds");
			}
			else
			{
	    	 if(supplier.check_id(textField.getText())==true)
	    	 {
	    		 
	    	     if(supplier.delete_supplier(textField.getText())==true)
	    	     {
	    	    	 
	    	    	 JOptionPane.showMessageDialog(null, "Deleted");
	    			 
	    		 }
	    	     else {
	    	    	 JOptionPane.showMessageDialog(null, "No id found");
	    	     }
	    	 }
	    		 else
	    		 {
	    			 JOptionPane.showMessageDialog(null, "Invalid format of id i-e xxxxx");
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


