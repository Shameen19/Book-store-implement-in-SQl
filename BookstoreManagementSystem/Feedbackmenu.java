package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Author_menu.MyActionListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Feedbackmenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea txtrCnic;
	private JTextArea txtrFeedback;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedbackmenu frame = new Feedbackmenu();
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
	public Feedbackmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(10, 11, 424, 451);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Feedbackmenu.class.getResource("/BookstoreManagementSystem/images/coffe.jpg")));
		lblNewLabel.setBounds(21, 5, 283, 161);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(103, 195, 311, 42);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 248, 311, 37);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(103, 302, 311, 59);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setText("Username");
		txtrUsername.setBounds(10, 204, 68, 22);
		panel.add(txtrUsername);
		
		txtrCnic = new JTextArea();
		txtrCnic.setText("CNIC");
		txtrCnic.setBounds(10, 254, 68, 22);
		panel.add(txtrCnic);
		
		txtrFeedback = new JTextArea();
		txtrFeedback.setText("Feedback");
		txtrFeedback.setBounds(10, 319, 73, 42);
		panel.add(txtrFeedback);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setBounds(242, 398, 89, 42);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setBounds(56, 398, 89, 42);
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
	    	if(textField.getText().isEmpty() && textField_1.getText().isEmpty() &&  textField_2.getText().isEmpty()  )
			{
				JOptionPane.showMessageDialog(null,"Please fill all the tesxt Feilds");
			}
			else
			{
				if(Feedback.check_cnic(textField.getText())==true)
				{
					if(Feedback.check_username(textField_1.getText())==true)
					{
						Feedback.givefeedback(textField_2.getText(), textField.getText(),textField_1.getText());
						JOptionPane.showMessageDialog(null,"Thank you for your feedback");
						
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Enter only charachters");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter correct format of cninc i-e xxxxxxxxxxxxx");
					}
				}
				
			}
	    
	    else if("Back".equals(ae.getActionCommand()))
    	{
	    	 Feedbackadd p=new  Feedbackadd();
    		p.setVisible(true);
    		dispose();
    	}
	    
		}
}

}
