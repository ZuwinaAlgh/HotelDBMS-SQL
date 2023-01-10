package sqlHotel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class HotelManagement {

	public static void guestname(){
		//Guests who's name end with 'E'
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
           
        
            String sql="SELECT guest_name FROM Guests WHERE guest_name LIKE '%E';" ;
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()) {
            	
            	 String guestname=rs.getString("guest_name");
                 System.out.println( guestname);
                 
           
            }}
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }	
	}
	
	public static void guestPayment(){
		//Rooms where guests are paying more than or equal 150
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
           
        
            String sql="SELECT guest_name FROM Guests INNER JOIN Rooms ON Guests.hotel_id=Rooms.hotel_id Where guest_payment_amount>=150;" ;
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()) {
            	
            	 String guestname=rs.getString("guest_name");
                 System.out.println( guestname);
                 
           
            }}
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }	
	}
	
	public static void Countguest(){
		//Count of guests who are staing in 'DELUXE' rooms
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
           
        
            String sql="SELECT  Count( * ) AS 'CountRoom' FROM Guests INNER JOIN Rooms ON Guests.hotel_id=Rooms.hotel_id  Where room_type_id=1;" ;
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()) {
            	
            	 int guestname=rs.getInt("CountRoom");
                 System.out.println( guestname);
                 
           
            }}
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }	
	}
	
	
	
	public static void GuestStyingInRoom(){
		//Guests who are staing in rooms and served by employee who have 'A' in their name
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
           
        
           String sql="SELECT guest_name FROM Guests WHERE guest_name LIKE '%A%';" ;
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()) {
            	
            	 String guestname=rs.getString("guest_name");
                 System.out.println( guestname);
                 
           
            }}
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }	
	}
	
	public static void RoomNotActive(){
		//All rooms which are not active but room type is 'Deluxe'
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
           
        
           String sql="SELECT * From  Room_Type where room_type_name='DELUXE' and is_Active=0 ;" ;
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()) {
            	
            	 int id=rs.getInt("id");
                 String roomtypename=rs.getString("room_type_name");
                 Date createddate= rs.getDate("created_date");
                 Date updateddate= rs.getDate("updated_date");
                 String isActive=rs.getString("is_Active");
                 System.out.println(id +" "+roomtypename+" "+createddate+" "+updateddate+" " +isActive);
                
                 
           
            }}
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }	
	}
	
	public static void AllRooomH(){
		//All room type in hotels who's name have 'H' or are active but have more than 5 rooms
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
           
        
           String sql="SELECT room_type_name From Room_Type JOIN Rooms ON Room_Type.id=Rooms.room_type_id  JOIN Hotels ON Rooms.hotel_id=Hotels.id where Hotels.hotel_name like '%H%' OR(Hotels.is_Active=1 and Rooms.id>5)" ;
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()) {
            	
            	 String roomtypename=rs.getString("room_type_name");
            	 System.out.println(roomtypename);
           
                
                 
           
            }}
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }	
	}

	}


