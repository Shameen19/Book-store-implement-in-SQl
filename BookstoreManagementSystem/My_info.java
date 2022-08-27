package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.log_in.MyActionListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class My_info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					My_info frame = new My_info();
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
	public My_info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 223, 215);
		panel.setBackground(Color.PINK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-33, 24, 309, 194);
		lblNewLabel.setIcon(new ImageIcon(My_info.class.getResource("/BookstoreManagementSystem/images/log.jpg")));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("update contact");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(35, 276, 130, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("update address");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(186, 276, 125, 55);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update pasword");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(343, 276, 118, 55);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Log out ");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2_1.setBounds(294, 351, 89, 55);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Delete my account");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(127, 351, 157, 55);
		contentPane.add(btnNewButton_3);
		MyActionListener n=new MyActionListener();
		btnNewButton.addActionListener(n);
		btnNewButton_1.addActionListener(n);
		btnNewButton_2.addActionListener(n);
		btnNewButton_2_1.addActionListener(n);
		btnNewButton_3.addActionListener(n);
	}
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
	    	if("update contact".equals(ae.getActionCommand()))
	    	{
	    		updatecontact u=new updatecontact();
	    		u.setVisible(true);
	    		dispose();
		}
	    	else if("update address".equals(ae.getActionCommand()))
	    			{
	    		updateaddress c=new updateaddress();
	    		c.setVisible(true);
	    		dispose();
	    			}
	    	else if("Update pasword".equals(ae.getActionCommand()))
			{
	    		updatepassword c=new updatepassword();
		        c.setVisible(true);
		        dispose();
			}
	    	else if("Delete my account".equals(ae.getActionCommand()))
			{
	    		deletemyacoount c=new deletemyacoount();
		        c.setVisible(true);
		        dispose();
			}
	    	else if("Log out ".equals(ae.getActionCommand()))
			{
	    		Customer_login p=new Customer_login();
	    		p.setVisible(true);
	    		dispose();
			}
		}
		}

}
