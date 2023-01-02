package sqlHotel;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Room_Type {

	
		public static void main(String[] args) {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
	        String user = "sa";
	        String pass = "root";
	        
	        String SchoolSql = "CREATE TABLE Room_Type " + "(id INTEGER PRIMARY KEY, " + " room_type_name VARCHAR(50) NOt NULL, "
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

}
