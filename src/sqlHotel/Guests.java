package sqlHotel;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Guests {

	public static void main(String[] args) {
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
		
	}
	
    public static void readFromTable(){
		
	}
    
    public static void updateById(){
		
	}
    
    public static void deleteById(){
		
	}
    
    public static void makeIsActiveFalseById(){
		
	}
    
    public static void insertIntoTable(){
		
	}
    

}
