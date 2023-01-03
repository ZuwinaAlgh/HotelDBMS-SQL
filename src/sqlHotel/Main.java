package sqlHotel;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Main {
	Hotels hotels=new Hotels();
    Room_Type roomType=new Room_Type();
    Rooms room=new Rooms();
	public static void main(String[] args) {
		 Scanner sa=new Scanner(System.in);
		    boolean menuExit = true;
		    	
		    	while (menuExit) {
					System.out.println("######.. MENUE..######");
					System.out.println("1.Insert 10,000 hotels ");
					System.out.println("2.Insert 1 hotel");
					System.out.println("3.Print 10 hotels");
					System.out.println("4.Make first 10 hotels 'is_Active' = false");
					System.out.println("5.Print hotel information by user input");
					System.out.println("#####################");
					String menu = sa.next();
					int option = Integer.parseInt(menu);
					switch (option) {
					case 1:
						Hotels.insert10000Hotels();
					
						break;
					case 2:
						Hotels.insertOneHotel();
		
						break;
					case 3:
						Hotels.print10Hotels();
						break;
					case 4:
						Hotels.print10Active();
						break;

					case 5:
						Hotels.printHotelInformation();
						 menuExit = false;
			    	
			        }}}

	}


