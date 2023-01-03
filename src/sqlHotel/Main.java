package sqlHotel;

import java.util.Scanner;

public class Main {
	Hotels hotels=new Hotels();

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
						
						break;
					case 2:
						
						break;
					case 3:
					
						break;
					case 4:
					
						break;

					case 5:
						
						 menuExit = false;
			    	
			        }}}

	}


