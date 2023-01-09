package sqlHotel;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Employees {
	public static Connection con;
	public static void createTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        String SchoolSql = "CREATE TABLE Employees " + "(id INTEGER PRIMARY KEY IDENTITY(1,1), " + " employee_type_id INTEGER FOREIGN KEY REFERENCES Employee_Type(id), "
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
		
		

		Scanner sa = new Scanner(System.in);
		System.out.println("How many numbers of rows to be inserted");
		int insert = sa.nextInt();
		Date date = new Date(System.currentTimeMillis());

		String created_date = "2023-01-09";
		boolean is_Active = true;
		Statement st = null;
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		Integer empTypeId = 1;
		Integer roomId= 1;
		
		

			System.out.println("choose Employee_Type id between  1 & 83 ");
			int optios = sa.nextInt();
			int empid = 0;
			if (optios > 0 && optios < 83) {
			if (optios == 1) {
				empid = 1;
			} else if (optios == 2) {
				empid = 2;
			} else if (optios == 3) {
				empid = 3;
			}
			}
			String sqlHotelId = "SELECT id From Employee_Type WHERE id =" + " '" + empTypeId + " '";
			
			try {
				con = DriverManager.getConnection(url, user, pass);
				st = con.createStatement();
				ResultSet resultSet = st.executeQuery(sqlHotelId);
				while (resultSet.next()) {
					empTypeId = resultSet.getInt("id");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			System.out.print("Choose Rooms id between 1 and 154 ");
			int optioss = sa.nextInt();
			int Roomid =0;
			if (optioss > 0 && optioss < 154) {
			if (optios == 1) {
				Roomid = 1;
			} else if (optios == 2) {
				Roomid= 2;
			} else if (optios == 3) {
				Roomid = 3;
			}
			}
			for (int i = 0; i <= insert; i++) {
			String sqlRoomType = "SELECT id From Rooms WHERE id =" + " '" + Roomid + " '";
			try {
				con = DriverManager.getConnection(url, user, pass);
				st = con.createStatement();
				ResultSet rs1 = st.executeQuery(sqlRoomType);
				while (rs1.next()) {

					Roomid = rs1.getInt("id");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		

			String sql = "insert into Employees(employee_type_id,room_id,created_date,is_Active)values(" + empTypeId + ","+roomId+",'" + created_date + "','" + is_Active + "')";


			try {

				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);

				con = DriverManager.getConnection(url, user, pass);

				Statement st1 = con.createStatement();

				int m = st1.executeUpdate(sql);
				if (m >= 0)
					System.out.println("insert data successfully");
				else
					System.out.println("faild inserted");

				con.close();
			}

			catch (Exception ex) {
				System.err.println(ex);
			}
		}
    }
    
  
	}


