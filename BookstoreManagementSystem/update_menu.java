package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.update_language.MyActionListener;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class update_menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_menu frame = new update_menu();
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
	public update_menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(5, 5, 424, 441);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Update Price");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(31, 111, 108, 58);
		panel.add(btnNewButton);
		
		JButton btnUpdateLanguage = new JButton("Update Language");
		btnUpdateLanguage.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateLanguage.setBounds(116, 180, 146, 58);
		panel.add(btnUpdateLanguage);
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1_1.setBounds(306, 372, 108, 58);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("Update Books Here......");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(56, 21, 333, 67);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Update Quantity");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(249, 275, 140, 48);
		panel.add(btnNewButton_1);
		
		MyActionListener n=new MyActionListener();
		//getContentPane().add(panel)
		btnNewButton.addActionListener(n);
		btnUpdateLanguage.addActionListener(n);
		btnNewButton_1_1.addActionListener(n);
		btnNewButton_1.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    	if("Update Price".equals(ae.getActionCommand()))
	    	{
	    		update_price u=new update_price();
	    		u.setVisible(true);
	    		dispose();
	    	}
	    	
	    	else if("Update Language".equals(ae.getActionCommand()))
	    	{
	    		update_language p=new update_language();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    	else if("Update Quantity".equals(ae.getActionCommand()))
	    	{
	    		update_quantitiybooks p=new update_quantitiybooks();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    	else if("Back".equals(ae.getActionCommand()))
	    	{
	    		Addbooks p=new Addbooks();
	    		p.setVisible(true);
	    		dispose();
	    	}
		}
}
}
