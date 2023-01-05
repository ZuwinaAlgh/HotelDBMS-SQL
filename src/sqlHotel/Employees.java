package sqlHotel;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Employees {

	public static void createTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        String SchoolSql = "CREATE TABLE Employees " + "(id INTEGER PRIMARY KEY, " + " employee_type_id INTEGER FOREIGN KEY REFERENCES Employee_Type(id), "
				+ " room_id INTEGER FOREIGN KEY REFERENCES Rooms(id), " + " created_date date NOT NULL, " + " updated_date date, "+" is_Active bit NOT NULL)";
        
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
           String sql="select * from Employees where id='"+idinput+"'";
           ResultSet rs=st.executeQuery(sql);
           
           while (rs.next()&&count<=idinput) {
     
        	   int id=rs.getInt("id");
               int employeetypeid=rs.getInt("employee_type_id");
               int roomid=rs.getInt("room_id");
               Date createddate= rs.getDate("created_date");
               Date updateddate= rs.getDate("updated_date");
               String isActive=rs.getString("is_Active");
               System.out.println(id +" "+employeetypeid+" "+roomid+" "+createddate+" "+updateddate+" " +isActive);
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
            String sql="select * from Employees";
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()&&count<=read) {
      
            	int id=rs.getInt("id");
                int employeetypeid=rs.getInt("employee_type_id");
                int roomid=rs.getInt("room_id");
                Date createddate= rs.getDate("created_date");
                Date updateddate= rs.getDate("updated_date");
                String isActive=rs.getString("is_Active");
                System.out.println(id +" "+employeetypeid+" "+roomid+" "+createddate+" "+updateddate+" " +isActive);
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
            
            String sql = "UPDATE Employees SET room_id = '85', updated_date='2023-01-05' "+" WHERE id = '"+idinput+"'";
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
            String sql ="DELETE FROM Employees WHERE id = '"+idinput+"'";
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
            String sql = "UPDATE Employees SET is_Active = 'false' "+" WHERE id = '"+idinput+"'";
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
        
        
        int employee_type_id=432;
        int room_id=5;
        String created_date="2015-01-15";
        String updated_date="2022-01-19";
        boolean is_Active=true;
        
        
        Random rn = new Random();
        Integer numberToAdd = rn.nextInt(100);
        
        for(int i=0; i<=insert;i++) {
        	String sql = "insert into Employees values ("+i+numberToAdd+", "+employee_type_id+", "+room_id+",'"+created_date+"', '"+updated_date+"', '"+is_Active+"')";
        
        
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


