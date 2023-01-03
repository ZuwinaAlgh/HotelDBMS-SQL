package sqlHotel;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Hotels {

	public static void CreateTable(String[] args) {
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

            String sql="select * from Hotels";
            ResultSet result=st.executeQuery(sql);
            
            while (result.next() ) {
      
            	 System.out.print("id: " + result.getInt("id"));
                 System.out.print(",hotel_name: " + result.getString("hotel_name"));
                 System.out.print(",hotel_location: " + result.getString("hotel_location"));
                 System.out.print(",created_date: " + result.getString("created_date"));
                 System.out.print(",updated_date: " + result.getDate("updated_date"));
                 System.out.print(",is_Active: " + result.getString("is_Active"));
           
            }
            con.close();
        }

        catch (Exception ex) {
            System.err.println(ex);
        }	
		}
	
	
	public static void getById(){
//		Scanner sa=new Scanner(System.in);
//    	System.out.println("Enter id: ");
//        int id =sa.nextInt();
//        
//        select * from
        
        	
	}
	
 
    
    public static void updateById(){
		
	}
    
    public static void deleteById(){
		
	}
    
    public static void makeIsActiveFalseById(){
		
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

	}
