package BookstoreManagementSystem;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class order {
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
	public static boolean check_orderid(String id)
	{
		boolean checko=false;
		String format = ("\\d{3}");
		if(id.matches(format))
		{
			checko=true;
		}
		else
		{
			checko=false;
		}
		return checko;
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
	public static boolean check_int( String p)
	{
		boolean check_p1=false;
	    String s=String.valueOf(p);
	    
	    	for(int i=0;i<s.length();i++)
	    	{
	    		if(!Character.isDigit(s.charAt(i)))
	    		{
	    			check_p1=false;
	    			break;
	    		}
	    		else
	    		{
	    			check_p1=true;
	    		}
	    	}
	    return check_p1;
}
	public static boolean price_check(int p)
	{
		boolean p_check=false;
		if(p>0)
		{
			p_check=true;
		}
		else
		{
			p_check=false;
		}
		return p_check;
	}
	public static boolean search_user(String username,String cnic)
	{
		boolean check=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery("select * from customer");
			while(res.next())
			{
				if(res.getString(1).equals(username) && res.getString(2).equals(cnic))
				{
					check=true;
					break;
				}
				else
				{
					check=false;
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return check;
		}
	public static boolean book_check(String isbn,String title)
	{
		boolean check=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
			//isbn="'"+isbn+"'";
			//title="'"+title+"'";
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery("select * from books");
			while(res.next())
			{
				if(res.getString(1).equals(isbn) && res.getString(2).equals(title))
				{
					check=true;
					break;
				}
				else
				{
					check=false;
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return check;
	}
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
	public static boolean check_quan(String isbn,String title,int quan)
	{
		boolean quan_check=true;
		int quan1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
			Statement stmt=con.createStatement();
			System.out.println("Successful");
			ResultSet rs=stmt.executeQuery("select * from books");
			while(rs.next())
			{
				if(rs.getString(1).equals(isbn) &&  rs.getString(2).equals(title))
				{
					quan1=rs.getInt(5);
					if(quan<=quan1)
					{
						quan_check=true;
						int left=quan1-quan;
						String p2=("Update books SET quantity=? where isbn= "+isbn);
						PreparedStatement pst=con.prepareStatement(p2);
						pst=con.prepareStatement(p2);
						pst.setInt(1, left);
						pst.executeUpdate();
						break;
					}
					else if(quan1==0)
					{
						Booksrecord.delete_book(title);
						//System.out.println("Record deleted");
						quan_check=false;
						
					}
					else
					{
						quan_check=false;
					}
				}
				else {
					quan_check=false;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return quan_check;
	}
	
	public static void place_order(String order_id,int quan,String isbn,String title,String username,String cnic)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
			Statement stmt=con.createStatement();
			System.out.println("Successful");
			ResultSet rs=stmt.executeQuery("select * from books");
			while(rs.next())
			{
				if(rs.getString(1).equals(isbn) &&  rs.getString(2).equals(title))
				{
					int price=rs.getInt(4);
					int total=price*quan;
					PreparedStatement s=con.prepareStatement("insert into placeorder(order_id,quantity,price,customer_username,customer_cnic,books_isbn,books_title)"+"values(?,?,?,?,?,?,?)");		
					s.setString(1, order_id);
					s.setInt(2, quan);
					s.setInt(3, total);
					s.setString(4, username);
					s.setString(5,cnic);
					s.setString(6, isbn);
					s.setString(7, title);
					s.executeUpdate();
					System.out.println("ORDER IS PLACED");
					break;
				}
				else
				{
					System.out.println("Not found");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		}
	
public static boolean delete(String username, String cnic )
{
	boolean f_check=false;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		username="'"+username+"'";
		cnic="'"+cnic+"'";
		String q=("Delete from placeorder where customer_username= "+username + "and customer_cnic= "+cnic);
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


