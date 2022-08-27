package BookstoreManagementSystem;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class connectionclass {
	Connection conn=null;
	public static Connection dbConnector()
	{
		try {
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
			JOptionPane.showMessageDialog(null, "Connection established successfuly");
			return conn;
			}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
