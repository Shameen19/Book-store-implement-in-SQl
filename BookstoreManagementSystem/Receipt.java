package BookstoreManagementSystem;
import java.sql.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Receipt {
	
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
public static boolean add_recipt(String r_id,String order_id)
{
	boolean f_check=false;
	LocalDate x=java.time.LocalDate.now();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databaseproject","shahid");
		Statement stmt=con.createStatement();
		java.util.Date date=new java.util.Date();
		order_id="'"+order_id+"'";
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		
		ResultSet rs=stmt.executeQuery("select * from placeorder where order_id= "+order_id);
		while(rs.next())
		{
			if(rs.getString(1).equals(order_id))
			
			{
				
				System.out.println("Order found");
				String q=("insert into recipt values(?,?,?)");
				PreparedStatement p=con.prepareStatement(q);
				p.setString(1,r_id);
				p.setDate(2,sqlDate);
				p.setString(3,order_id);
				p.execute();
				System.out.println("Successfuly stored");
				f_check=true;
				break;
				
			}
			else
			{
				System.out.println("order not found");
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
	
}

