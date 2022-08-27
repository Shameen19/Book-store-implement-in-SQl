package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Add_publisher.MyActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;

public class reciptmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reciptmenu frame = new reciptmenu();
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
	public reciptmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 204));
		panel.setBounds(5, 5, 424, 398);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(reciptmenu.class.getResource("/BookstoreManagementSystem/images/1.jpg")));
		lblNewLabel.setBounds(10, 5, 288, 132);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Generate Receipt");
		btnNewButton.setBounds(30, 180, 122, 41);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show recipt");
		btnNewButton_1.setBounds(112, 232, 156, 41);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBounds(209, 288, 136, 41);
		panel.add(btnNewButton_2);
		
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
		btnNewButton_2.addActionListener(n);
	}
	
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    if("Generate Receipt".equals(ae.getActionCommand()))
	    	{
	    	GenerateRecipt p=new GenerateRecipt();
	    		p.setVisible(true);
	    		dispose();
	    	}
	   
	    else if("Show recipt".equals(ae.getActionCommand()))
    	{
	    	showrecipt p=new showrecipt();
    		p.setVisible(true);
    		dispose();
    	}
	    
	    else if("Back".equals(ae.getActionCommand()))
    	{
	    	ordermenu p=new ordermenu();
    		p.setVisible(true);
    		dispose();
    	}
	    
		}
}
}
