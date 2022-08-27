package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Author_menu.MyActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ordermenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ordermenu frame = new ordermenu();
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
	public ordermenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setBounds(5, 5, 424, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ordermenu.class.getResource("/BookstoreManagementSystem/images/1.jpg")));
		lblNewLabel.setBounds(10, 5, 291, 158);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Place order");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(22, 194, 112, 43);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete order");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(103, 248, 118, 36);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(271, 383, 89, 36);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Receipt");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(187, 308, 114, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Shipping");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(271, 349, 89, 23);
		panel.add(btnNewButton_4);
		
		
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
		btnNewButton_3.addActionListener(n);
		btnNewButton_2.addActionListener(n);
		btnNewButton_4.addActionListener(n);
		
		
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    if("Place order".equals(ae.getActionCommand()))
	    	{
	    	Placeorder p=new Placeorder();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    else if("Delete order".equals(ae.getActionCommand()))
    	{
	    	delete_order p=new delete_order();
    		p.setVisible(true);
    		dispose();
    	}
	    else if("Receipt".equals(ae.getActionCommand()))
    	{
	    	reciptmenu p=new reciptmenu();
    		p.setVisible(true);
    		dispose();
    	}
	    else if("Shipping".equals(ae.getActionCommand()))
    	{
	    	shippingmeny p=new shippingmeny();
    		p.setVisible(true);
    		dispose();
    	}
	    
	    else if("Back".equals(ae.getActionCommand()))
    	{
	    	myAccount p=new myAccount();
    		p.setVisible(true);
    		dispose();
    	}
	    
		}
}
}
