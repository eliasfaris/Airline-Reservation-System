import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;



/**
 * @author Elias Faris
 * version 1.0 9/12/2020
 */

public class ReservationSystem {
	
	
	public static void main(String[] args) {
		
		Airplane airplane = new Airplane();
		
		
		File file = new File(args[0]); //grabs the text file from terminal

		airplane.checkFileExistence(file);

	

		boolean key = true;

		while(key) {
			System.out.println("Add [P]assenger, Add [G]roup, [C]ancel Reservations,"
					+ " Print Seating [A]vailability Chart, Print [M]anifest, [Q]uit");
			Scanner myObj = new Scanner(System.in);
			String input = myObj.nextLine();  // Read user input
			char letter = input.charAt(0); //convert string to character
			

			if(letter == 'Q') {
				airplane.saveInfoToTextFile(file);
				key = false;
				
			
			}
			else if(letter == 'P'){
				airplane.addPassenger();

			}
			else if(letter == 'G') {
				airplane.addGroup();
				
			}
			else if(letter == 'C') {
				airplane.cancelResveration();
			}
			else if(letter == 'A') {
				airplane.availabilityList();
			}
			else if (letter == 'M') {
				airplane.manifestList();

			}
			else{
				System.out.println("Input either P, G, C, A, M, Q");

			}
			

		}
		
	}

}
