package BookstoreManagementSystem;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Customer {
	Scanner input=new Scanner(System.in);
	//public static String address_1;
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
	public static boolean check_pass(String password)
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
	public static boolean check_contact (String contact)
	{
		boolean check_contact=false;
		String formatt = ("\\d{4}-\\d{7}");
		if(contact.matches(formatt))
		{
			//System.out.println("Corrct number");
			check_contact=true;
		}
		else
		{
			//System.out.println("No correct number");
			check_contact=false;
		}
		return check_contact;
	}
	public static boolean  repeat_cnic(String c_cnic)
	{
		boolean rcnic=false;
		try
		{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		c_cnic="'"+c_cnic+"'";
		String q=("Select cnic from customer where cnic= "+c_cnic);
		//ResultSet rs= ps.executeQuery();
		if(stmt.executeUpdate(q)!=0)
		{
			//System.out.println("This cnic is already taken");
			rcnic=false;
		}
		else
		{
			//System.out.println("Valid id");
			rcnic=true;
		}
	}
		catch(Exception e )
		{
			System.out.println(e.toString());
		}
		return rcnic;
	}
	public static boolean repeat_username(String username)
	{
		boolean rname=false;
		try
		{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		username="'"+username+"'";
		String q=("Select username from customer where username= "+username);
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
			System.out.println(e.toString());
		}
		return rname;
	}
	public static void writetodatabase(String username,String cnic,String password,String contact,String address_1)
	{
		try {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		PreparedStatement book=con.prepareStatement("insert into customer(username,cnic,c_pass,contact,address)" +" values (?,?,?,?,?)");
		book.setString(1, username);
		book.setString(2, cnic);
		book.setString(3, password);
		book.setString(4, contact);
		book.setString(5, address_1);
		book.execute();
		//System.out.println("Successfull");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
}
	
	public static boolean update_contact(String username ,String password,String contact)
	{
		boolean upd_cont=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		username="'"+username+"'";
		String q=("Select username from customer where username= "+username);
		if(stmt.executeUpdate(q)!=0)
		{
			//System.out.println("Id found");
			password="'"+password+"'";
			String s1=("Select c_pass from customer where username= "+username + "and c_pass =" +password);
			if(stmt.executeUpdate(s1)!=0)
			{
			PreparedStatement s=con.prepareStatement("UPDATE customer SET contact=? where username= "+username);
		    s.setString(1, contact);
		    s.execute();
		    upd_cont=true;
		    System.out.println("Successful");
			}
			else
			{
				System.out.println("Not found");
				upd_cont=false;
			}
	}
		else
		{
			upd_cont=false;
		}
		}
		catch(Exception e )
		{
			System.out.println(e.toString());
		}
		return upd_cont;
	}
	public static boolean update_address(String username ,String password,String address)
	{
		boolean upd_cont=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		username="'"+username+"'";
		String q=("Select username from customer where username= "+username);
		if(stmt.executeUpdate(q)!=0)
		{
			//System.out.println("Id found");
			password="'"+password+"'";
			String s1=("Select c_pass from customer where username= "+username + "and c_pass =" +password);
			if(stmt.executeUpdate(s1)!=0)
			{
			PreparedStatement s=con.prepareStatement("UPDATE customer SET address=? where username= "+username);
		    s.setString(1, address);
		    s.execute();
		    upd_cont=true;
		    System.out.println("Successful");
			}
			else
			{
				System.out.println("Not found");
				upd_cont=false;
			}
	}
		else
		{
			System.out.println("No id found");
			upd_cont=false;
		}
		}
		catch(Exception e )
		{
			System.out.println(e.toString());
		}
		return upd_cont;
	}
	
	public static boolean update_password(String username ,String password,String pass)
	{
		boolean upd_cont=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		username="'"+username+"'";
		String q=("Select username from customer where username= "+username);
		if(stmt.executeUpdate(q)!=0)
		{
			System.out.println("Id found");
			password="'"+password+"'";
			String s1=("Select c_pass from customer where username= "+username + "and c_pass =" +password);
			if(stmt.executeUpdate(s1)!=0)
			{
			PreparedStatement s=con.prepareStatement("UPDATE customer SET c_pass=? where username= "+username);
		    s.setString(1, pass);
		    s.execute();
		    upd_cont=true;
		    System.out.println("Successful");
			}
			else
			{
				System.out.println("Not found");
				upd_cont=false;
			}
	}
		else
		{
			System.out.println("No id found");
			upd_cont=false;
		}
		}
		catch(Exception e )
		{
			System.out.println(e.toString());
		}
		return upd_cont;
	}
	public static boolean search_cust(String username)
	{
		boolean search_check=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		
			
		    username="'"+username+"'";
			String q1=("Select username from customer where username= "+username);
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
	public static boolean delete_cust(String username,String password)
	{
		boolean search_check=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		
			
		    username="'"+username+"'";
			String q1=("Select username from customer where username= "+username);
			if(stmt.executeUpdate(q1)!=0)
			{
				 password="'"+password+"'";
				String q=("Select c_pass from customer where username= "+username +"and c_pass =" +password);
				if(stmt.executeUpdate(q)!=0)
				{
					String q3=("delete from customer where username= "+username + "and c_pass= "+password);
					if(stmt.executeUpdate(q3)!=0)
					{
						//System.out.println("Deleted successful");
						search_check=true;
					}
					else
					{
						//System.out.println("Deleted unsuccessful");
						search_check=true;
					}
					
				}
				else
				{
					//System.out.println("INvalid password");
					search_check=false;
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
	public static boolean check_creditentialsc(String username1)
	{
		boolean check_user=false;
		Scanner input=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
			Statement stmt=con.createStatement();
			//System.out.println("established");
			//username1="'"+username1+"'";
			ResultSet r=stmt.executeQuery("select * from customer");
			boolean b=true;
			
				while(r.next())
				{
					
					if(r.getString(1).equals(username1))
					{
						check_user=true;
						break;
					}
					
				
				else
				{
					
					check_user=false;
					//System.out.println("Unmatched");
					
				}
				}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return check_user;
		
	}
	public static boolean check_password(String pass)
	{
		boolean check_user=false;
		Scanner input=new Scanner(System.in);
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
			Statement stmt=con.createStatement();
			//System.out.println("established");
			//pass="'"+pass+"'";
			ResultSet r=stmt.executeQuery("select * from customer");
			boolean b=true;
			while(r.next())
			{
				if(r.getString(3).equals(pass))
				{
					//System.out.println("Matched");
					b=false;
					check_user=true;
					break;
					
				}
				else
				{
					b=true;
					check_user=false;
					//System.out.println("Unmatched");
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
