package BookstoreManagementSystem;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
public class supplier {
	Scanner input=new Scanner(System.in);
	//public static String address_1;
	public static boolean check_id(String sup_id)
	{
		boolean check_id=false;
		String format = ("\\d{5}");
		if(sup_id.matches(format))
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

	public static boolean check_supname(String sname)
	{
		boolean name_check=true;
		for(int i=0;i<sname.length();i++)
		{
			if(Character.isLetter(sname.charAt(i))|| Character.isDigit(sname.charAt(i)))
			
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
	public static boolean repeat_id(String sid)
	{
		boolean rname=false;
		try
		{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		sid="'"+sid+"'";
		String q=("Select supplier_id from supplier where supplier_id= "+sid);
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
	
	
	public static void writetodatabase(String sup_name,String sup_id)
	{
		try {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		PreparedStatement book=con.prepareStatement("insert into supplier(suppliername,supplier_id)" +" values (?,?,)");
		book.setString(1, sup_name);
		book.setString(2, sup_name);
		book.execute();
		System.out.println("Successfull");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
}
	
		public static boolean search_supplier(String sid)
	{
		boolean search_check=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		
			
		    sid="'"+sid+"'";
			String q1=("Select supplier_id from supplier where supplier_id= "+sid);
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
	public static boolean delete_supplier(String sid)
	{
		boolean search_check=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		
			
		    sid="'"+sid+"'";
			String q1=("Select supplier_id from supplier where supplier_id= "+sid);
			if(stmt.executeUpdate(q1)!=0)
			{
				
				   
					String q3=("delete from supplier where supplier_id= "+sid);
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
