package BookstoreManagementSystem;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Author {
	Scanner input=new Scanner(System.in);
	//public static String address_1;
	public static boolean check_id(String auth_id)
	{
		boolean check_id=false;
		String format = ("\\d{5}");
		if(auth_id.matches(format))
		{
			System.out.println("correct format of id");
			check_id=true;
		}
		else
		{
			System.out.println("Not correct format");
			System.out.println("Enter in xxxxx format");
			check_id=false;
		}
		return check_id;
	}

	public static boolean check_authname(String authname)
	{
		boolean name_check=true;
		for(int i=0;i<authname.length();i++)
		{
			if(Character.isLetter(authname.charAt(i))|| Character.isDigit(authname.charAt(i)))
			
			{
				name_check=true;
				
			}
			else
			{
				System.out.println("Enter correct name");
				name_check=false;
			}
		}
		return name_check;
	}
	public static boolean check_authpass(String password)
	{
		boolean pass_check=false;
		int length=password.length();
		if(length>8)
		{
			//System.out.println("Enter password of 8 chrachters only");
			pass_check=false;
		}
		else
		{
			//System.out.println("Correct password");
			pass_check=true;
		}
	return pass_check;
	}
	
	
	public static boolean repeat_username(String username)
	{
		boolean rname=false;
		try
		{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		username="'"+username+"'";
		String q=("Select auth_name from author where auth_name= "+username);
		//ResultSet rs= ps.executeQuery();
		if(stmt.executeUpdate(q)!=0)
		{
			//System.out.println("This username is already taken ");
			rname=false;
		}
		else
		{
			//System.out.println("Valid name");
			rname=true;
		}
	}
		catch(Exception e )
		{
			//System.out.println(e.toString());
		}
		return rname;
	}
	public static boolean repeat_id(String authid)
	{
		boolean rname=false;
		try
		{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		authid="'"+authid+"'";
		String q=("Select auth_id from author where auth_id= "+authid);
		//ResultSet rs= ps.executeQuery();
		if(stmt.executeUpdate(q)!=0)
		{
			//System.out.println("This username is already taken ");
			rname=false;
		}
		else
		{
			//System.out.println("Valid name");
			rname=true;
		}
	}
		catch(Exception e )
		{
			//System.out.println(e.toString());
		}
		return rname;
	}
	public static void writetodatabase(String auth_name,String auht_pass,String id)
	{
		try {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		PreparedStatement book=con.prepareStatement("insert into author(auth_name,auth_password,auth_id)" +" values (?,?,?)");
		book.setString(1, auth_name);
		book.setString(2, auht_pass);
		book.setString(3, id);
		book.execute();
		System.out.println("Successfull");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
}
	
		public static boolean search_author(String auth_id)
	{
		boolean search_check=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		
			
		    auth_id="'"+auth_id+"'";
			String q1=("Select auth_id from author where auth_id= "+auth_id);
			if(stmt.executeUpdate(q1)!=0)
			{
				
				//System.out.println("Successful searching");
				search_check=true;
			}
			else
			{
				//System.out.println("No user found");
				search_check=false;
			}
			
		
	}
		catch(Exception e )
		{
			System.out.println(e.toString());
		}
	return search_check;
}
	public static boolean delete_author(String auth_id)
	{
		boolean search_check=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		
			
		    auth_id="'"+auth_id+"'";
			String q1=("Select auth_id from author where auth_id= "+auth_id);
			if(stmt.executeUpdate(q1)!=0)
			{
				
				   
					String q3=("delete from author where auth_id= "+auth_id);
					if(stmt.executeUpdate(q3)!=0)
					{
					 //System.out.println("Successfull");
					 search_check=true;
					
					}
					else
					{
						search_check=false;
						//System.out.println("Cannot delete");
					}
					
				
			}
			else
			{
				//System.out.println("Id not found to delete");
				search_check=false;
			}
			
		
	}
		catch(Exception e )
		{
			System.out.println(e.toString());
		}
	return search_check;
	}
	
}
