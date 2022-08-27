package BookstoreManagementSystem;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Feedback {
	public static boolean check_cnic(String cnic)
	{
		boolean check_cnic=false;
		String format = ("\\d{13}");
		if(cnic.matches(format))
		{
			//System.out.println("correct format");
			check_cnic=true;
		}
		else
		{
			//System.out.println("Not correct format");
			check_cnic=false;
		}
		return check_cnic;
	}

	public static boolean check_username(String username)
	{
		boolean name_check=true;
		for(int i=0;i<username.length();i++)
		{
			if(Character.isLetter(username.charAt(i))|| Character.isDigit(username.charAt(i)))
			
			{
				name_check=true;
				
			}
			else
			{
				//System.out.println("Enter correct name");
				name_check=false;
			}
		}
		return name_check;
	}
	public static boolean givefeedback(String username1,String cnic1, String feedback)
	{
		boolean f_check=false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
			Statement stmt=con.createStatement();
			
			
			ResultSet rs=stmt.executeQuery("select * from customer");
			while(rs.next())
			{
				if(rs.getString(1).equals(username1) && rs.getString(2).equals(cnic1))
				
				{
					
					//System.out.println("Feedback submitted");
					String q=("insert into feedback values(?,?,?)");
					PreparedStatement p=con.prepareStatement(q);
					p.setString(1,feedback);
					p.setString(2,username1);
					p.setString(3,cnic1);
					p.execute();
					f_check=true;
					
				}
				else
				{
					//System.out.println("Feedback not submitted");
					f_check=false;
				}
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return f_check;
		
	}
	public static boolean delete_feedback(String username1,String cnic1)
	{
		
		boolean f_check=false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
			Statement stmt=con.createStatement();
			username1="'"+username1+"'";
			cnic1="'"+cnic1+"'";
			String q=("Delete from feedback where customer_username= "+username1 + "and customer_cnic= "+cnic1);
			if(stmt.executeUpdate(q)!=0)
			{
				//System.out.println("Successful");
				f_check=true;
			}
			else
			{
				//System.out.println("Nouser found");
				f_check=false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return f_check;
		
	}
	
	

}
