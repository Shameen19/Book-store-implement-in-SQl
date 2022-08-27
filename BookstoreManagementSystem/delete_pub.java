package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Delete_author.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class delete_pub extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_pub frame = new delete_pub();
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
	public delete_pub() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(5, 5, 424, 362);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(delete_pub.class.getResource("/BookstoreManagementSystem/images/coffe.jpg")));
		lblNewLabel.setBounds(68, 5, 285, 147);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(132, 215, 242, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(30, 310, 89, 41);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setBounds(224, 310, 89, 41);
		panel.add(btnNewButton_1);
		
		JTextArea txtrId = new JTextArea();
		txtrId.setText("ID");
		txtrId.setBounds(10, 213, 63, 22);
		panel.add(txtrId);
		
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
        		if(textField.getText().isEmpty()  )
        		{
        			JOptionPane.showMessageDialog(null,"Please fill all the text feilds");
        		}
        		else
        		{
        			if(Publisher.check_id(textField.getText())==true ) 
        			{
        				
        					if(Publisher.delete_publihser(textField.getText())==true)
        					{
        						JOptionPane.showMessageDialog(null,"Publisher Deleted");
        					}
        					else
        					{
        						JOptionPane.showMessageDialog(null,"ID not found");
        					}
        			}
        			else
        			{
        				JOptionPane.showMessageDialog(null,"Please enter in format xxxxx");
        			}
        				
        		}

}
        	else if("Back".equals(ae.getActionCommand()))
        	{
        		Publisher_menu a=new Publisher_menu();
        		a.setVisible(true);
        		dispose();
        	}
		}
	}

}
