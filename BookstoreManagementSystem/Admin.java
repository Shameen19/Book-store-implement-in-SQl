package BookstoreManagementSystem;
import java.sql.*;
import java.util.Scanner;
public class Admin {
	
	public static boolean check_creditentials(String username)
	{
		boolean check_user=false;
		Scanner input=new Scanner(System.in);
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
			Statement stmt=con.createStatement();
			//System.out.println("established");
			username="'"+username+"'";
			String q=("Select admin_name from admin where admin_name= "+username);
			boolean b=true;
			
				if(stmt.executeUpdate(q)!=0)
				{
					//System.out.println("Matched");
					b=false;
					check_user=true;
					
				}
				else
				{
					b=true;
					check_user=false;
					//System.out.println("Unmatched");
					
				}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return check_user;
		
	}
	public static boolean check_pass(String pass)
	{
		boolean check_user=false;
		Scanner input=new Scanner(System.in);
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
			Statement stmt=con.createStatement();
			//System.out.println("established");
			pass="'"+pass+"'";
			String q=("Select admin_password from admin where admin_password= "+pass);
			boolean b=true;
			while(b==true)
			{
				if(stmt.executeUpdate(q)!=0)
				{
					//System.out.println("Matched");
					b=false;
					check_user=true;
					
				}
				else
				{
					b=true;
					check_user=false;
					//System.out.println("Unmatched");
					break;
				}
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return check_user;
		
	}

}
