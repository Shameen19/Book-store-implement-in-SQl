package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.view_author.MyActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class add_cat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextArea txtrCategory_1;
	private JTextArea txtrBookIsbn;
	private JTextArea txtrTitle;
	private JTextArea txtrCategory;
	private JTextField textField_1;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_cat frame = new add_cat();
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
	public add_cat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 484, 453);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(137, 54, 248, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 125, 248, 32);
		panel.add(textField_2);
		
		txtrCategory_1 = new JTextArea();
		txtrCategory_1.setText("Category 2");
		txtrCategory_1.setBounds(10, 129, 108, 22);
		panel.add(txtrCategory_1);
		
		txtrBookIsbn = new JTextArea();
		txtrBookIsbn.setText("Book ISBN");
		txtrBookIsbn.setBounds(0, 197, 108, 22);
		panel.add(txtrBookIsbn);
		
		txtrTitle = new JTextArea();
		txtrTitle.setText("Title");
		txtrTitle.setBounds(10, 268, 108, 22);
		panel.add(txtrTitle);
		
		txtrCategory = new JTextArea();
		txtrCategory.setText("Category1");
		txtrCategory.setBounds(0, 58, 108, 22);
		panel.add(txtrCategory);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 187, 248, 32);
		panel.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(137, 252, 248, 32);
		panel.add(textField_3);
		
		btnNewButton = new JButton("Submit ");
		btnNewButton.setBounds(244, 370, 89, 23);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(44, 370, 89, 23);
		panel.add(btnNewButton_1);
		
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1 .addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			if("Submit ".equals(ae.getActionCommand()))
			{
				if(textField.getText().isEmpty() && textField_1.getText().isEmpty() &&  textField_2.getText().isEmpty() && textField_3.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null,"Please fill all the tesxt Feilds");
				}
				else
				{
					if(Category.check_name(textField.getText())==true)
					{
						if(Category.check_name(textField_2.getText())==true)
						{
							if(Category.check_Isbn(textField_1.getText())==true)
							{
								if(Category.check_name(textField_3.getText())==true)
								{
									Category.add_ctegory(textField.getText(), textField_2.getText(), textField_1.getText(), textField_3.getText());
									JOptionPane.showMessageDialog(null,"Successfull");
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Enter only charachters");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Enter correct format i-e xxxxxxxx");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Enter only charachters");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter only charachters");
					}
				}
			}
			// TODO Auto-generated method stub
		else if("Back".equals(ae.getActionCommand()))
	    	{
	    	Categorymenu p=new Categorymenu();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}
}
