package sqlHotel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Room_Type {

	
		public static void CreateTable(){
			String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
	        String user = "sa";
	        String pass = "root";
	        
	        String SchoolSql = "CREATE TABLE Room_Type " + "(id INTEGER PRIMARY KEY IDENTITY(1,1), " + " room_type_name VARCHAR(50) NOt NULL, "
					+ " created_date date, " + " updated_date date, " + " is_Active bit NOT NULL)";
	        
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
	            String sql="select * from Room_Type where id='"+idinput+"'";
	            ResultSet rs=st.executeQuery(sql);
	            
	            while (rs.next()&&count<=idinput) {
	      
	            	 int id=rs.getInt("id");
	                 String roomtypename=rs.getString("room_type_name");
	                 Date createddate= rs.getDate("created_date");
	                 Date updateddate= rs.getDate("updated_date");
	                 String isActive=rs.getString("is_Active");
	                 System.out.println(id +" "+roomtypename+" "+createddate+" "+updateddate+" " +isActive);
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
	            String sql="select * from Room_Type";
	            ResultSet rs=st.executeQuery(sql);
	            
	            while (rs.next()&&count<=read) {
	      
	            	 int id=rs.getInt("id");
	                 String roomtypename=rs.getString("room_type_name");
	                 Date createddate= rs.getDate("created_date");
	                 Date updateddate= rs.getDate("updated_date");
	                 String isActive=rs.getString("is_Active");
	                 System.out.println(id +" "+roomtypename+" "+createddate+" "+updateddate+" " +isActive);
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
	            String sql = "UPDATE Room_Type SET room_type_name = 'abc', updated_date='2023-01-03' "+" WHERE id = '"+idinput+"'";
	            ResultSet rs=st.executeQuery(sql);
	            
	                 
	           
	            }
	      
	        

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
	            String sql ="DELETE FROM Room_Type WHERE id = '"+idinput+"'";
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
	            String sql = "UPDATE Room_Type SET is_Active = 'false' "+" WHERE id = '"+idinput+"'";
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
	        Date date=new Date(System.currentTimeMillis());
	        
	        String room_type_name="SUITE";
	        String created_date="2023-01-08";
	        boolean is_Active=true;

	        
	        Random rn = new Random();
	        Integer numberToAdd = rn.nextInt(100);
	        
	        for(int i=0; i<=insert;i++) {
	            String sql="insert into Room_Type(room_type_name,created_date,is_Active)values('"+room_type_name+"','"+created_date+"','"+is_Active+"')";
	        
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
	        }
			
		}
	    

}
