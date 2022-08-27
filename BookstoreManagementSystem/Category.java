package BookstoreManagementSystem;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Category {
	public static boolean check_Isbn(String isbn)
	{
		boolean check_isbn=false;
		String format = ("\\d{8}");
		if(isbn.matches(format))
		{
			check_isbn=true;
		}
		else
		{
			check_isbn=false;
		}
		return check_isbn;
	}
	public static boolean check_name(String name)
	{
		boolean name_chec=true;
		for(int i=0;i<name.length();i++)
		{
			if(!Character.isLetter(name.charAt(i)))
			{
				name_chec=false;
				break;
			}
			else
			{
				name_chec=true;
			}
		}
		return name_chec;
	}
	public static boolean  repeat_isbn(String isbn)
	{
		boolean risbn=false;
		try
		{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		isbn="'"+isbn+"'";
		String q=("Select books_isbn from category where books_isbn= "+isbn);
		//ResultSet rs= ps.executeQuery();
		if(stmt.executeUpdate(q)!=0)
		{
			//System.out.println("This id is already taken");
			risbn=false;
		}
		else
		{
			//System.out.println("Valid id");
			risbn=true;
		}
	}
		catch(Exception e )
		{
			System.out.println(e.toString());
		}
		return risbn;
	}
	public static boolean repeat_name(String name)
	{
		boolean rname=false;
		try
		{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		name="'"+name+"'";
		String q=("Select books_title from category where books_title= "+name);
		//ResultSet rs= ps.executeQuery();
		if(stmt.executeUpdate(q)!=0)
		{
			//System.out.println("This name is already taken ");
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
	public static void add_ctegory(String isbn1,String title1, String cat1,String cat2)
	{
		boolean f_check=false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
			Statement stmt=con.createStatement();
			System.out.println("Successful");
			ResultSet rs=stmt.executeQuery("select * from books");
			while(rs.next())
			{
				if(rs.getString(1).equals(isbn1) && rs.getString(2).equals(title1))
				
				{
					
					System.out.println("Matched");
					String q=("insert into category values(?,?,?,?)");
					PreparedStatement p=con.prepareStatement(q);
					p.setString(1,cat1);
					p.setString(2,cat2);
					p.setString(3,isbn1);
					p.setString(4,title1);
					p.execute();
					f_check=true;
					break;
					
				}
				else
				{
					System.out.println("Not matched");
					f_check=false;
				}
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		//return f_check;
		
	}
	public static boolean search_category(String isbn)
	{
		boolean f_check=false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
			Statement stmt=con.createStatement();
			isbn="'"+isbn+"'";
			//cnic1="'"+cnic1+"'";
			String q=("Select books_isbn from category where books_isbn= "+isbn);
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


