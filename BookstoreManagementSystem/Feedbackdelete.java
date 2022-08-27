package BookstoreManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookstoreManagementSystem.Feedbackmenu.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Feedbackdelete extends JFrame {

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
					Feedbackdelete frame = new Feedbackdelete();
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
	public Feedbackdelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(10, 11, 424, 438);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Feedbackdelete.class.getResource("/BookstoreManagementSystem/images/books2.jpg")));
		lblNewLabel.setBounds(10, 5, 287, 160);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(81, 209, 287, 42);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(84, 290, 287, 42);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(29, 377, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(234, 377, 89, 23);
		panel.add(btnNewButton_1);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setText("Username");
		txtrUsername.setBounds(10, 209, 61, 22);
		panel.add(txtrUsername);
		
		JTextArea txtrCnic = new JTextArea();
		txtrCnic.setText("CNIC");
		txtrCnic.setBounds(10, 299, 64, 22);
		panel.add(txtrCnic);
		
		
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
	    	if(textField.getText().isEmpty() && textField_1.getText().isEmpty()   )
			{
				JOptionPane.showMessageDialog(null,"Please fill all the tesxt Feilds");
			}
			else
			{
				if(Feedback.check_cnic(textField.getText())==true)
				{
					if(Feedback.check_username(textField_1.getText())==true)
					{
						Feedback.delete_feedback(textField.getText(), textField_1.getText());
						JOptionPane.showMessageDialog(null,"Feedback Deleted ");
						
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
