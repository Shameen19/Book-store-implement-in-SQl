package BookstoreManagementSystem;
import java.sql.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
public class shipping {
	
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
public static void shippingdays(String p,String username,String cnic,String order_id)
{
	boolean f_check=false;
	//LocalDate x=java.time.LocalDate.now();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from customer");
		while(rs.next())
		{
			if(rs.getString(1).equals(username) && rs.getString(2).equals(cnic))
			
			{
				String address=rs.getString(5);
				System.out.println("Customer found");
				ResultSet res=stmt.executeQuery("select * from placeorder");
				while(res.next())
				{
					if(res.getString(1).equals(order_id))
					{
						System.out.println("Your order is found");
						String q=("insert into  shipping values(?,?,?,?,?)");
						PreparedStatement p1=con.prepareStatement(q);
						p1.setString(1,p);
						p1.setString(2,address);
						p1.setString(3,username);
						p1.setString(4,cnic);
						p1.setString(5
								,order_id);
						p1.execute();
						System.out.println("Successfuly stored");
						f_check=true;
						break;
					}
					else
					{
						System.out.println("Not found");
					}
			}
			}
			else
			{
				System.out.println("Customer not found");
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
}

