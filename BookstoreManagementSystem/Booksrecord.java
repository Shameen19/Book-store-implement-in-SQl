package BookstoreManagementSystem;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Booksrecord {
	Scanner input=new Scanner(System.in);
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
	public static boolean check_leang(String lang)
	{
		boolean lang_check=false;
		for(int i=0;i<lang.length();i++)
		{
			if(!Character.isLetter(lang.charAt(i)))
			{
			    lang_check=false;
				break;
			}
			else
			{
				lang_check=true;
			}
		}
	return lang_check;
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
	public static boolean  repeat_isbn(String isbn)
	{
		boolean risbn=false;
		try
		{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		isbn="'"+isbn+"'";
		String q=("Select isbn from books where isbn= "+isbn);
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
		String q=("Select title from books where title= "+name);
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
	public static void writetodatabase(String b_isbn,String b_title,String b_lang,int b_price,int b_quan)
	{
		try {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		PreparedStatement book=con.prepareStatement("insert into books(isbn,title,language,price,quantity)" +" values (?,?,?,?,?)");
		book.setString(1, b_isbn);
		book.setString(2, b_title);
		book.setString(3, b_lang);
		book.setInt(4, b_price);
		book.setInt(5, b_quan);
		book.execute();
		System.out.println("Successfull");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
}
	
	public static boolean update_price(String b_isbn ,int p)
	{
		boolean upd_price=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		b_isbn="'"+b_isbn+"'";
		String q=("Select isbn from books where isbn= "+b_isbn);
		if(stmt.executeUpdate(q)!=0)
		{
			//System.out.println("Id found");
			
			PreparedStatement s=con.prepareStatement("UPDATE books SET price=? where isbn= "+b_isbn);
		    s.setInt(1, p);
		    s.execute();
		    upd_price=true;
		    //System.out.println("Successful");
		
	}
		else
		{
			upd_price=false;
		}
		}
		catch(Exception e )
		{
			System.out.println(e.toString());
		}
		return upd_price;
	}
	public static boolean update_quan(String b_isbn ,int quan)
	{
		boolean upd_price=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		b_isbn="'"+b_isbn+"'";
		String q=("Select isbn from books where isbn= "+b_isbn);
		if(stmt.executeUpdate(q)!=0)
		{
			//System.out.println("Id found");
			PreparedStatement s=con.prepareStatement("UPDATE books SET quantity=? where isbn= "+b_isbn);
		    s.setInt(1, quan);
		    s.execute();
		    upd_price=true;
		    //System.out.println("Successful");
		
	}
		else
		{
			//System.out.println("Not");
			upd_price=false;
		}
		}
		catch(Exception e )
		{
			System.out.println(e.toString());
		}
		return upd_price;
	}
	
	public static boolean update_lang(String b_isbn ,String lang)
	{
		boolean lan_check=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		b_isbn="'"+b_isbn+"'";
		String q=("Select isbn from books where isbn= "+b_isbn);
		if(stmt.executeUpdate(q)!=0)
		{
			//System.out.println("Id found");
			
			PreparedStatement s=con.prepareStatement("UPDATE books SET language=? where isbn= "+b_isbn);
		    s.setString(1, lang);
		    s.execute();
		    //System.out.println("Successful");
		    lan_check=true;
		
	}
		else
		{
			lan_check=false;
		}
		}
		catch(Exception e )
		{
			System.out.println(e.toString());
		}
		return lan_check;
	}
	public static boolean  search_book(String b_name)
	{
		boolean search_check=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		
			
		    b_name="'"+b_name+"'";
			String q1=("Select title from books where title= "+b_name);
			if(stmt.executeUpdate(q1)!=0)
			{
				search_check=true;
			}
			else
			{
				search_check=false;
			}
			
		
	}
		catch(Exception e )
		{
			System.out.println(e.toString());
		}
	return search_check;
}
	public static boolean delete_book(String name)
	{
		boolean search_check=false;
		try
		{
		Scanner input=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "databaseproject", "shahid");
		Statement stmt=con.createStatement();
		
			
		    name="'"+name+"'";
			String q1=("Select title from books where title= "+name);
			if(stmt.executeUpdate(q1)!=0)
			{
				String q=("delete from books where title= "+name);
				if(stmt.executeUpdate(q)!=0)
				{
					search_check=true;
				}
				else
				{
					search_check=false;
				}
				
			}
			else
			{
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
