package sqlHotel;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Hotels {

	public static void CreateTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        String SchoolSql = "CREATE TABLE Hotels " + "(id INTEGER PRIMARY KEY, " + " hotel_name VARCHAR(50) NOt NULL, "
				+ " hotel_location VARCHAR(50), " + " created_date date NOT NULL, " + " updated_date date, "+"is_Active bit NOT NULL)";
        
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
            String sql="select * from Hotels";
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()&&count<=read) {
      
            	int id=rs.getInt("id");
                 String hotelname=rs.getString("hotel_name");
                 String hotellocation= rs.getString("hotel_location");
                 Date createddate= rs.getDate("created_date");
                 Date updateddate= rs.getDate("updated_date");
                 String isActive=rs.getString("is_Active");
                 System.out.println(id +" "+hotelname+" "+hotellocation+" "+createddate+" "+updateddate+" " +isActive);
                 count++;
                 
           
            }}
      
        

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
            String sql="select * from Hotels where id='"+idinput+"'";
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()&&count<=idinput) {
      
            	 int id=rs.getInt("id");
                 String hotelname=rs.getString("hotel_name");
                 String hotellocation= rs.getString("hotel_location");
                 Date createddate= rs.getDate("created_date");
                 Date updateddate= rs.getDate("updated_date");
                 String isActive=rs.getString("is_Active");
                 System.out.println(id +" "+hotelname+" "+hotellocation+" "+createddate+" "+updateddate+" " +isActive);
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
            String sql = "UPDATE Hotels SET hotel_name = 'intercontenantil', hotel_location = 'alqurm', updated_date='2023-01-03' "+" WHERE id = '"+idinput+"'";
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
            String sql ="DELETE FROM Hotels WHERE id = '"+idinput+"'";
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
            String sql = "UPDATE Hotels SET is_Active = 'false' "+" WHERE id = '"+idinput+"'";
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
        
        
        String hotel_name="w";
        String hotel_location="Alqurm";
        String created_date="2022-01-05";
        String updated_date="2023-01-02";
        boolean is_Active=true;
        
        
        Random rn = new Random();
        Integer numberToAdd = rn.nextInt(100);
        
        for(int i=0; i<=insert;i++) {
        	String sql = "insert into Hotels values ("+i+numberToAdd+", '"+hotel_name+i+"', '"+hotel_location+i+"', '"+created_date+"', '"+updated_date+"', '"+is_Active+"')";
        
        
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
    
    public static void insertOneHotel(){
    	String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
       
        
        String hotel_name="intercontinantel";
        String hotel_location="Alqurm";
        String created_date="2010-11-08";
        String updated_date="2022-12-08";
        boolean is_Active=true;
        
        
        Random rn = new Random();
        Integer numberToAdd = rn.nextInt(100);
        
        for(int i=0; i<=1;i++) {
        	String sql = "insert into Hotels values ("+i+numberToAdd+", '"+hotel_name+i+"', '"+hotel_location+i+"', '"+created_date+"', '"+updated_date+"', '"+is_Active+"')";
        
        
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
    
    public static void insert10000Hotels(){
    	String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
    
        String hotel_name="w";
        String hotel_location="Alqurm";
        String created_date="2022-01-05";
        String updated_date="2023-01-02";
        boolean is_Active=true;
        
        
        Random rn = new Random();
        Integer numberToAdd = rn.nextInt(100);
        
        for(int i=0; i<=10000;i++) {
        	String sql = "insert into Hotels values ("+i+numberToAdd+", '"+hotel_name+i+"', '"+hotel_location+i+"', '"+created_date+"', '"+updated_date+"', '"+is_Active+"')";
        
        
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
    public static void print10Hotels(){
    	String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
           
           
            int count=0;
            String sql="select * from Hotels";
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()&&count<=10) {
      
            	int id=rs.getInt("id");
                 String hotelname=rs.getString("hotel_name");
                 String hotellocation= rs.getString("hotel_location");
                 Date createddate= rs.getDate("created_date");
                 Date updateddate= rs.getDate("updated_date");
                 String isActive=rs.getString("is_Active");
                 System.out.println(id +" "+hotelname+" "+hotellocation+" "+createddate+" "+updateddate+" " +isActive);
                 count++;
                 
           
            }}
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }	
    }
    public static void printHotelInformation(){
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
            String sql="select * from Hotels where id='"+idinput+"'";
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()&&count<=idinput) {
      
            	 int id=rs.getInt("id");
                 String hotelname=rs.getString("hotel_name");
                 String hotellocation= rs.getString("hotel_location");
                 Date createddate= rs.getDate("created_date");
                 Date updateddate= rs.getDate("updated_date");
                 String isActive=rs.getString("is_Active");
                 System.out.println(id +" "+hotelname+" "+hotellocation+" "+createddate+" "+updateddate+" " +isActive);
                 count++;
                 
           
            }}
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }	
    }
    public static void print10Active() {
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
            System.out.println("Enter id that you want to Actived: ");
            int idinput =sa.nextInt();
            for (int i=0; i<=idinput;i++) {
            String sql = "UPDATE Hotels SET is_Active = 'true' where id<='"+idinput+"'";
            ResultSet rs=st.executeQuery(sql);
           }
                 
           
            }
      
        

        catch (Exception ex) {
            System.err.println(ex);
        }	}
        public static void print10UnActive() {
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
                System.out.println("Enter id that you want to Actived: ");
                int idinput =sa.nextInt();
                for (int i=0; i<=idinput;i++) {
                String sql = "UPDATE Hotels SET is_Active = 'true' where id<='"+idinput+"'";
                ResultSet rs=st.executeQuery(sql);
               }
                     
                }
          
            

            catch (Exception ex) {
                System.err.println(ex);
            }	
    	
    	
    }
	}
