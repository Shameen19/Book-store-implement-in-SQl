package BookstoreManagementSystem;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Publisher {
	Scanner input=new Scanner(System.in);
	//public static String address_1;
	public static boolean check_id(String pub_id)
	{
		boolean check_id=false;
		String format = ("\\d{5}");
		if(pub_id.matches(format))
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

	public static boolean check_pubname(String pname)
	{
		boolean name_check=true;
		for(int i=0;i<pname.length();i++)
		{
			if(Character.isLetter(pname.charAt(i))|| Character.isDigit(pname.charAt(i)))
			
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
	public static boolean repeat_id(String pid)
	{
		boolean rname=false;
		try
		{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		pid="'"+pid+"'";
		String q=("Select publisher_id from pblisher where publisher_id= "+pid);
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
	
	
	public static void writetodatabase(String pub_name,String pub_id)
	{
		try {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		PreparedStatement book=con.prepareStatement("insert into pblisher(publisher_id,pub_name)" +" values (?,?,)");
		book.setString(1, pub_id);
		book.setString(2, pub_name);
		book.execute();
		System.out.println("Successfull");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
}
	
		public static boolean search_publihser(String pid)
	{
		boolean search_check=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		
			
		    pid="'"+pid+"'";
			String q1=("Select publisher_id from pblisher where publisher_id= "+pid);
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
	public static boolean delete_publihser(String pid)
	{
		boolean search_check=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseprject", "shahid");
		Statement stmt=con.createStatement();
		
			
		    pid="'"+pid+"'";
			String q1=("Select publisher_id from pblisher where publisher_id= "+pid);
			if(stmt.executeUpdate(q1)!=0)
			{
				
				   
					String q3=("delete from pblisher where publisher_id= "+pid);
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
