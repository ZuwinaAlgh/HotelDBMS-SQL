package sqlHotel;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Guests {

	public static void createTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        String SchoolSql = "CREATE TABLE Guests " + "(id INTEGER PRIMARY KEY, " + " guest_name VARCHAR(50) NOT NULL, "
				+ " guest_phone VARCHAR(50) NOT NULL, " + " guest_accompanying_members INTEGER NOT NULL, " + " guest_payment_amount INTEGER NOT NULL,"
						+ " room_id INTEGER FOREIGN KEY REFERENCES Rooms(id), "
						+ " hotel_id INTEGER FOREIGN KEY REFERENCES Hotels(id), "+" created_date date NOT NULL, "+" updated_date date, "+" is_Active bit NOT NULL)";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();

            int m = st.executeUpdate(SchoolSql );
            if (m >=0)
                System.out.println( "Created table successfully");
            else
                System.out.println("Created table faild");

            con.close();
        }

        catch (Exception ex) {
            System.err.println(ex);
        }

	}
	
    public static void getById(){
    	String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
           
            Scanner sa=new Scanner(System.in);
        	System.out.println("Enter id: ");
            int idinput =sa.nextInt();
            int count=0;
            String sql="select * from Guests where id='"+idinput+"'";
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()&&count<=idinput) {
      
         	    int id=rs.getInt("id");
                String guestname=rs.getString("guest_name");
                String guestphone= rs.getString("guest_phone");
                int guestaccompanyingmembers=rs.getInt("guest_accompanying_members");
                int guestpaymentamount=rs.getInt("guest_payment_amount");
                int roomid=rs.getInt("room_id");
                int hotelid =rs.getInt("hotel_id ");
                Date createddate= rs.getDate("created_date");
                Date updateddate= rs.getDate("updated_date");
                String isActive=rs.getString("is_Active");
                System.out.println(id +" "+guestname+" "+guestphone+" "+guestaccompanyingmembers+" "+guestpaymentamount+" "+roomid+" "+hotelid+" "+createddate+" "+updateddate+" " +isActive);
                count++;
                
           
            }}
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }
		
	}
	
    public static void readFromTable(){
    	String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
           
            Scanner sa=new Scanner(System.in);
        	System.out.println("How many User you want to read: ");
            int read =sa.nextInt();
            int count=0;
            String sql="select * from Guests";
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()&&count<=read) {
      
            	int id=rs.getInt("id");
                String guestname=rs.getString("guest_name");
                String guestphone= rs.getString("guest_phone");
                int guestaccompanyingmembers=rs.getInt("guest_accompanying_members");
                int guestpaymentamount=rs.getInt("guest_payment_amount");
                int roomid=rs.getInt("room_id");
                int hotelid =rs.getInt("hotel_id ");
                Date createddate= rs.getDate("created_date");
                Date updateddate= rs.getDate("updated_date");
                String isActive=rs.getString("is_Active");
                System.out.println(id +" "+guestname+" "+guestphone+" "+guestaccompanyingmembers+" "+guestpaymentamount+" "+roomid+" "+hotelid+" "+createddate+" "+updateddate+" " +isActive);
                count++;
                
                 
           
            }}
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }
		
	}
    
    public static void updateById(){
    	String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
           
            Scanner sa=new Scanner(System.in);
        	System.out.println("Enter id: ");
            int idinput =sa.nextInt();
            int count=0;
            String sql="select * from Guests where id='"+idinput+"'";
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()&&count<=idinput) {
      
            	int id=rs.getInt("id");
                String guestname=rs.getString("guest_name");
                String guestphone= rs.getString("guest_phone");
                int guestaccompanyingmembers=rs.getInt("guest_accompanying_members");
                int guestpaymentamount=rs.getInt("guest_payment_amount");
                int roomid=rs.getInt("room_id");
                int hotelid =rs.getInt("hotel_id ");
                Date createddate= rs.getDate("created_date");
                Date updateddate= rs.getDate("updated_date");
                String isActive=rs.getString("is_Active");
                System.out.println(id +" "+guestname+" "+guestphone+" "+guestaccompanyingmembers+" "+guestpaymentamount+" "+roomid+" "+hotelid+" "+createddate+" "+updateddate+" " +isActive);
                count++;
                 
           
            }}
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }	
		
	}
    
    public static void deleteById(){
    	String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
           
            Scanner sa=new Scanner(System.in);
        	System.out.println("Enter id: ");
            int idinput =sa.nextInt();
            String sql ="DELETE FROM Guests WHERE id = '"+idinput+"'";
            ResultSet rs=st.executeQuery(sql);
            
                 
           
            }
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }	
		
	}
    
    public static void makeIsActiveFalseById(){
    	String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
           
            Scanner sa=new Scanner(System.in);
        	System.out.println("Enter id: ");
            int idinput =sa.nextInt();
            int count=0;
            String sql = "UPDATE Guests SET is_Active = 'false' "+" WHERE id = '"+idinput+"'";
            ResultSet rs=st.executeQuery(sql);
            
                 
           
            }
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }	
		
	}
    
    public static void insertIntoTable(){
    	String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Scanner sa=new Scanner(System.in);
    	System.out.println("How many numbers of rows to be inserted");
        int insert =sa.nextInt();
        
        
        String guest_name="Taima";
        int guest_phone=3359;
        int guest_accompanying_members=50;
        int guest_payment_amount=850;
        int room_id=182;
        int hotel_id=178;
        String created_date="2018-08-11";
        String updated_date="2022-12-15";
        int is_Active=0;
        
        
        Random rn = new Random();
        Integer numberToAdd = rn.nextInt(100);
        
        for(int i=0; i<=insert;i++) {
        	String sql = "insert into Guests values ("+i+numberToAdd+", '"+guest_name+i+"',"+guest_phone+", "+guest_accompanying_members+", "+guest_payment_amount+","
        			+ " "+room_id+", "+hotel_id+","+created_date+",'"+updated_date+"',"+is_Active+")";
        
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();

            int m = st.executeUpdate(sql);
            if (m >=0)
                System.out.println( "insert data successfully");
            else
                System.out.println("faild inserted ");

            con.close();
        }

        catch (Exception ex) {
            System.err.println(ex);
        }
		
        }}}
    


