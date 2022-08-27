package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Feedbackmenu.MyActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Feedbackadd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedbackadd frame = new Feedbackadd();
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
	public Feedbackadd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 102));
		panel.setBounds(5, 5, 424, 423);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Feedbackadd.class.getResource("/BookstoreManagementSystem/images/coffe.jpg")));
		lblNewLabel.setBounds(10, 5, 290, 143);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Give Feedback");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(24, 185, 128, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Feedback");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(118, 241, 139, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(211, 308, 89, 40);
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
	    if("Give Feedback".equals(ae.getActionCommand()))
	    	{
	    	Feedbackmenu p=new Feedbackmenu();
	    		p.setVisible(true);
	    		dispose();
	    	}
	    else if("Delete Feedback".equals(ae.getActionCommand()))
    	{
	    	Feedbackdelete p=new Feedbackdelete();
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
