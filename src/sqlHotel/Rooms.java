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

public class Rooms {
	public static Connection con;
	public static void roomTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		String SchoolSql = "CREATE TABLE Rooms " + "(id INTEGER PRIMARY KEY IDENTITY(1,1), "
				+ " room_type_id INTEGER FOREIGN KEY REFERENCES Room_Type(id), "
				+ " hotel_id INTEGER FOREIGN KEY REFERENCES Hotels(id), " + " created_date date NOT NULL, "
				+ " updated_date date, " + " is_Active bit NOT NULL)";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			int m = st.executeUpdate(SchoolSql);
			if (m >= 0)
				System.out.println("Created table successfully");
			else
				System.out.println("Created table faild");

			con.close();
		}

		catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public static void getById() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			Scanner sa = new Scanner(System.in);
			System.out.println("Enter id: ");
			int idinput = sa.nextInt();
			int count = 0;
			String sql = "select * from Rooms where id='" + idinput + "'";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next() && count <= idinput) {

				int id = rs.getInt("id");
				String roomtypeid = rs.getString("room_type_id");
				String hotelid = rs.getString("hotel_id");
				Date createddate = rs.getDate("created_date");
				Date updateddate = rs.getDate("updated_date");
				String isActive = rs.getString("is_Active");
				System.out.println(
						id + " " + roomtypeid + " " + hotelid + " " + createddate + " " + updateddate + " " + isActive);
				count++;

			}
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void readFromTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			Scanner sa = new Scanner(System.in);
			System.out.println("How many User you want to read: ");
			int read = sa.nextInt();
			int count = 0;
			String sql = "select * from Rooms";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next() && count <= read) {

				int id = rs.getInt("id");
				String roomtypeid = rs.getString("room_type_id");
				String hotelid = rs.getString("hotel_id");
				Date createddate = rs.getDate("created_date");
				Date updateddate = rs.getDate("updated_date");
				String isActive = rs.getString("is_Active");
				System.out.println(
						id + " " + roomtypeid + " " + hotelid + " " + createddate + " " + updateddate + " " + isActive);
				count++;

			}
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void updateById() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			Scanner sa = new Scanner(System.in);
			System.out.println("Enter id: ");
			int idinput = sa.nextInt();
			int count = 0;
			String sql = "UPDATE Rooms SET updated_date = '2023-01-05', created_date = '2019-05-14' " + " WHERE id = '"
					+ idinput + "'";
			ResultSet rs = st.executeQuery(sql);

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void deleteById() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			Scanner sa = new Scanner(System.in);
			System.out.println("Enter id: ");
			int idinput = sa.nextInt();
			String sql = "DELETE FROM Rooms WHERE id = '" + idinput + "'";
			ResultSet rs = st.executeQuery(sql);

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void makeIsActiveFalseById() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			Scanner sa = new Scanner(System.in);
			System.out.println("Enter id: ");
			int idinput = sa.nextInt();
			int count = 0;
			String sql = "UPDATE Rooms SET is_Active = 'false' " + " WHERE id = '" + idinput + "'";
			ResultSet rs = st.executeQuery(sql);

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void insertIntoTable() {
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
		
		

			System.out.println("choose which hotel you want:\n 1-ANTANA \n 2-ROZANA \n 3-SEAZON INN ");
			int optios = sa.nextInt();
			String hotelName = "";
			if (optios > 0 && optios < 140) {
			if (optios == 7) {
				hotelName = "ALBALEED";
			} else if (optios == 67) {
				hotelName = "MYSK";
			} else if (optios == 102) {
				hotelName = "SHANGRILA";
			}
			}
			String sqlHotelId = "SELECT id From Hotels WHERE hotel_name =" + " '" + hotelName + " '";
			
			try {
				con = DriverManager.getConnection(url, user, pass);
				st = con.createStatement();
				ResultSet resultSet = st.executeQuery(sqlHotelId);
				while (resultSet.next()) {
					hotelid = resultSet.getInt("id");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			System.out.print("Choose Room_Type you want:\n  1-STANDARD \n 2-DELUXE \n 3-SUITE ");
			int optioss = sa.nextInt();
			String RoomType = "";
			if (optioss > 0 && optioss < 80) {
			if (optios == 27) {
				RoomType = "STANDARD";
			} else if (optios == 30) {
				RoomType = "DELUXE";
			} else if (optios == 67) {
				RoomType = "SUITE";
			}
			}
			for (int i = 0; i <= insert; i++) {
			String sqlRoomType = "SELECT id From Room_Type WHERE room_type_name =" + " '" + RoomType + " '";
			try {
				con = DriverManager.getConnection(url, user, pass);
				st = con.createStatement();
				ResultSet rs1 = st.executeQuery(sqlRoomType);
				while (rs1.next()) {

				roomTypeid = rs1.getInt("id");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		

			String sql = "insert into Rooms(room_type_id,hotel_id,created_date,is_Active)values(" + roomTypeid + ","
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


