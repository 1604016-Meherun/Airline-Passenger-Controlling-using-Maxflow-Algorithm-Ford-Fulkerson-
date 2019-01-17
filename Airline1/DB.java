/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airline1;

/**
 *
 * @author MeherunNesaShraboni
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.text.html.HTML.Tag.SELECT;
/*
public class DB {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","","");
		}catch(Exception e){System.out.println(e);} 
		return con;
	}

}
*/
public class DB{
	public static int save(String firstname,String lastname,String username,String password,String emailid,String weburl){
		int status=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
                        PreparedStatement ps=con.prepareStatement("INSERT INTO `user_details`(`firstname`, `lastname`, `username`, `password`, `email_id`, `web_url`) VALUES (?,?,?,?,?,?)");
			ps.setString(1,firstname);
			ps.setString(2,lastname);
			ps.setString(3,username);
			ps.setString(4,password);
			ps.setString(5,emailid);
			ps.setString(6,weburl);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
        public static boolean match(String username,String password)
{
    boolean status=false;
    try{
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
        PreparedStatement ps=con.prepareStatement("SELECT `firstname`, `lastname`, `username`, `password`, `email_id`, `web_url` FROM `user_details` WHERE `username`=? AND `password`=?");
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        con.close();
    }
    catch(Exception e){System.out.println(e);}
    return status;
 }
      public static boolean fatch(String username,String password)
{
    boolean status=false;
    try{
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
       PreparedStatement ps=con.prepareStatement("SELECT  `name`, `username`, `password` FROM `admin_details` WHERE `username`=? AND `password`=?");
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        con.close();
    }
    catch(Exception e){System.out.println(e);}
    return status;
 }
      public static int graph_input(int one,int two,int three,int four,int five,int six,int seven,int eight,int nine,int ten){
		int status=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
                        PreparedStatement ps=con.prepareStatement("INSERT INTO `graph_capacity`(`onetotwo`, `onetothree`, `twotothree`, `twotofour`, `threetotwo`, `threetofive`, `fourtothree`, `fourtosix`, `fivetofour`, `fivetosix`) VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,one);
			ps.setInt(2,two);
			ps.setInt(3,three);
			ps.setInt(4,four);
			ps.setInt(5,five);
			ps.setInt(6,six);
                        ps.setInt(7,seven);
                        ps.setInt(8,eight);
                        ps.setInt(9,nine);
                        ps.setInt(10,ten);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
     /* public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}*/
        public static int datch(String username,String password){
		int status=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
                        PreparedStatement ps=con.prepareStatement("INSERT INTO `booking_details`(`username`, `password`) VALUES (?,?)");
			ps.setString(1,username);
			ps.setString(2,password);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
        public static int datch_2(int fromAirport,int toAirport, String dateAndTime)
        {
            int status=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
                        PreparedStatement ps=con.prepareStatement("INSERT INTO `booking_path`(`FromAirport`, `ToAirport`, `DateAndTime`) VALUES (?,?,?)");
			ps.setInt(1,fromAirport);
			ps.setInt(2,toAirport);
                        ps.setString(3, dateAndTime);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
            return status;
        }
}