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
		Integer roomTypeid = 1;
		Integer hotelid = 1;
		Integer roomsid =1;
		Integer employeetypeid=1;
		//get employee type
		System.out.println(" which Employee type you want: 1/ ATTENDANT 2/MANAGER 3/VALET 4/BUTLER : ");
		int optios1 = sa.nextInt();
		String employeeTypeName = "";
		if (optios1 > 84 && optios1 < 106) {
		if (optios1 == 1) {
			employeeTypeName = "ATTENDANT";
		} else if (optios1 == 2) {
			employeeTypeName = "MANAGER";
		} else if (optios1 == 3) {
			employeeTypeName = "VALET";
		}
		else if (optios1 == 4) {
			employeeTypeName = "BUTLER";
		}
		}
		String sqlEmployeeTypelId = "SELECT id From Employee_Type WHERE id =" + " '" + employeeTypeName + " '";
		try {
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			ResultSet rs1 = st.executeQuery(sqlEmployeeTypelId);
			while (rs1.next()) {

				employeetypeid= rs1.getInt("id");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//get hotel id
		System.out.println(" which hotels you want: 1/ ALBALEED 2/MYSK 3/SHANGRILA : ");
		int optios = sa.nextInt();
		String hotelName = "";
		if (optios > 0 && optios < 140) {
		if (optios == 1) {
			hotelName = "ALBALEED";
		} else if (optios == 2) {
			hotelName = "MYSK";
		} else if (optios == 3) {
			hotelName = "SHANGRILA";
		}
		}
	
		String sqlHotelId = "SELECT id From Hotels WHERE hotel_name =" + " '" + hotelName + " '";
		try {
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			ResultSet rs1 = st.executeQuery(sqlHotelId);
			while (rs1.next()) {

			hotelid= rs1.getInt("id");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//get room type id
		System.out.println(" which Room Type you want: 1/ STANDARD 2/DELUXE 3/SUITE  : ");
		int optioss = sa.nextInt();
		String RoomType = "";
		if (optioss > 0 && optioss < 80) {
		if (optios == 1) {
			RoomType = "STANDARD";
		} else if (optios == 2) {
			RoomType = "DELUXE";
		} else if (optios == 3) {
			RoomType = "SUITE";
		}
		}
		
		String sqlRoomtypeId = "SELECT id From Room_Type WHERE room_type_name =" + " '" + RoomType + " '";
		try {
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			ResultSet rs1 = st.executeQuery(sqlRoomtypeId);
			while (rs1.next()) {

			roomTypeid = rs1.getInt("id");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}

			
		
			for (int i = 0; i <= insert; i++) {
			String sqlRoomType = "SELECT id From Rooms WHERE  hotel_id="+hotelid+" AND room_type_id="+roomTypeid+"";
			try {
				con = DriverManager.getConnection(url, user, pass);
				st = con.createStatement();
				ResultSet rs1 = st.executeQuery(sqlRoomType);
				while (rs1.next()) {

				roomsid = rs1.getInt("id");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		

			String sql = "insert into Employees(employee_type_id,room_id,created_date,is_Active)values(" + employeetypeid + ","
					+ roomsid+ ",'" + created_date + "','" + is_Active + "')";


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
		
    
    
  
	


