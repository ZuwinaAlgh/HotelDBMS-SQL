package sqlHotel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Guests {
	public static Connection con;
	public static void createTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        
        String SchoolSql = "CREATE TABLE Guests " + "(id INTEGER PRIMARY KEY IDENTITY(1,1), " + " guest_name VARCHAR(50) NOT NULL, "
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
		
		

		Scanner sa = new Scanner(System.in);
		System.out.println("How many numbers of rows to be inserted");
		int insert = sa.nextInt();
		Date date = new Date(System.currentTimeMillis());

		String guest_name="Alice";
		int guest_phone=256841;
		int guest_accompanying_members=4;
		int guest_payment_amount=150;
		String created_date = "2023-01-10";
		boolean is_Active = true;
		Statement st = null;
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		Integer roomsid = 1;
		Integer hotelid = 1;
		Integer roomTypeid=1;
		
		

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
		

			String sql = "insert into Guests(guest_name,guest_phone,guest_accompanying_members,guest_payment_amount,room_id,hotel_id,created_date,is_Active)values('" + guest_name + "',"+guest_phone+","+guest_accompanying_members+","+guest_payment_amount+","+roomsid+","
					+ hotelid + ",'" + created_date + "','" + is_Active + "')";


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
		
		}}
    


