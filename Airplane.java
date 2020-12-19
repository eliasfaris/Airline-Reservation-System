import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;



/**
 * @author Elias Faris
 * version 1.0 9/12/2020
 */

/**
 * 
 * This airplane class is where all the methods that does adding a passenger,
 *  adding a group, canceling reservations, showing a manifest list, and showing
 *  availability. Also, the airplane class sets up both the first class and 
 *  economy class, that are inherited from the ClassPreference class, and 
 *  sets up the 2D array data structure with each seat being an object to 
 *  store information.
 * 
 *
 */
public class Airplane{

	first[][] firstclass = new first[4][2]; // 2d array of objects for first class
	economy[][] econclass = new economy[6][20]; // 2d array of object for economy class

	public Airplane() {

		//this sets up the entire airplane to have each seat as an object to store information
		setupFirst(firstclass);
		setupEcon(econclass);

	}



	/**
	 * Adds a group to our airplane
	 */
	public void addGroup() {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);

		System.out.print("Group Name: ");
		String groupName = userInput.nextLine();

		System.out.print("Names: ");
		String inputNames = userInput.nextLine();


		String names[] = inputNames.split("\\s*,\\s*");




		System.out.print("Service Class: ");
		String classChoice = userInput.nextLine();


		if(classChoice.equals("First") || classChoice.equals("first")) {

			for(int col = 0; col < 2; col++) {
				int[] rowIndex = new int[4];
				int count = 0;
				for(int row = 0; row < 4; row++) {			
					if(firstclass[row][col].getAvailability() == 'Y') {
						rowIndex[count] = row;
						count++;

					}
					else {
						count = 0;
					}

					if(names.length == count) {
						for(int x = 0; x < names.length; x++) {
							System.out.print(firstclass[rowIndex[x]][col].getSeatLetter());
							System.out.println(firstclass[rowIndex[x]][col].getSeatNumber());

							firstclass[rowIndex[x]][col].setAvailability('N');
							firstclass[rowIndex[x]][col].setName(names[x]);
							firstclass[rowIndex[x]][col].setGroupName(groupName);


						}

						return;


					}

				}

			}

			System.out.println("Request Failed.");

		}

		else if(classChoice.equals("Economy") || classChoice.equals("economy")) {
			for(int col = 0; col < 20; col++) {
				int[] rowIndex = new int[6];
				int count = 0;
				for(int row = 0; row < 6; row++) {			
					if(econclass[row][col].getAvailability() == 'Y') {
						rowIndex[count] = row;
						count++;

					}
					else {
						count = 0;
					}

					if(names.length == count) {
						for(int x = 0; x < names.length; x++) {
							System.out.print(econclass[rowIndex[x]][col].getSeatLetter());
							System.out.println(econclass[rowIndex[x]][col].getSeatNumber());

							econclass[rowIndex[x]][col].setAvailability('N');
							econclass[rowIndex[x]][col].setName(names[x]);
							econclass[rowIndex[x]][col].setGroupName(groupName);

						}
						return;

					}

				}

			}
			System.out.println("Request Failed.");
		}


	}


	/**
	 * Cancels reservation of individual or group.
	 */
	public void cancelResveration() {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);

		System.out.print("Cancel [I]ndividual or [G]roup? ");

		String choice = userInput.nextLine();


		if(choice.equals("I")) {
			System.out.print("Names: ");
			String nameInputs = userInput.nextLine();
			String names[] = nameInputs.split("\\s*,\\s*");


			for(int i = 0; i < names.length; i++){
				for(int row = 0; row < firstclass.length; row++) {
					for( int col = 0; col < firstclass[row].length; col++){
						if(firstclass[row][col].getName().equals(names[i])) {
							firstclass[row][col].setName("");
							firstclass[row][col].setAvailability('Y');
						}
					}
				}




				for(int row = 0; row < econclass.length; row++) {
					for( int col = 0; col < econclass[row].length; col++){
						if(econclass[row][col].getName().equals(names[i])) {
							econclass[row][col].setName("");
							econclass[row][col].setAvailability('Y');
						}
					}
				}
			}

		}//end outer if

		if(choice.equals("G")) {
			System.out.print("Group Name: ");
			String nameInput = userInput.nextLine();

			for(int row = 0; row < firstclass.length; row++) {
				for( int col = 0; col < firstclass[row].length; col++){
					if(firstclass[row][col].getGroupName().equals(nameInput)) {
						firstclass[row][col].setName("");
						firstclass[row][col].setGroupName("");
						firstclass[row][col].setAvailability('Y');
					}
				}
			}

			for(int row = 0; row < econclass.length; row++) {
				for( int col = 0; col < econclass[row].length; col++){
					if(econclass[row][col].getGroupName().equals(nameInput)) {
						econclass[row][col].setName("");
						econclass[row][col].setGroupName("");
						econclass[row][col].setAvailability('Y');
					}
				}
			}




		}





	}


	/**
	 * Adds an individual passenger
	 */
	public void addPassenger() {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);


		System.out.print("Name: ");
		String nameInput = userInput.nextLine();
		System.out.print("Service Class: ");
		String classInput = userInput.nextLine();
		System.out.print("Seat Preference: ");

		String stringSeatInput = userInput.nextLine();



		char seatInput = stringSeatInput.charAt(0);


		if(classInput.equals("first") || classInput.equals("First")) {
			for(int row = 0; row < firstclass.length; row ++) {
				for(int col = 0; col < firstclass[row].length; col++) {
					if(firstclass[row][col].getAvailability() == 'Y' && firstclass[row][col].getSeat() == seatInput){
						firstclass[row][col].setName(nameInput);
						firstclass[row][col].setAvailability('N');

						System.out.print(firstclass[row][col].getSeatNumber());
						System.out.print(firstclass[row][col].getSeatLetter());
						System.out.println();
						return;
					}

				}//inner for

			}//outer for
			System.out.println("Request Failed.");
		} //end if

		if(classInput.equals("economy") || classInput.equals("Economy")) {
			for(int row = 0; row < econclass.length; row ++) {
				for(int col = 0; col < econclass[row].length; col++) {
					if(econclass[row][col].getAvailability() == 'Y' && econclass[row][col].getSeat() == seatInput){
						econclass[row][col].setName(nameInput);
						econclass[row][col].setAvailability('N');

						System.out.print(econclass[row][col].getSeatNumber());
						System.out.print(econclass[row][col].getSeatLetter());
						System.out.println();
						return;
					}

				}//inner for

			}//outer for
			System.out.println("Request Failed.");
		} //end if


	}


	/**
	 * Portrays a manifest list that provides a list of passengers
	 * on what seats are taken and who is seating on the designated seat.
	 */
	public void manifestList() {
		// TODO Auto-generated method stub

		//print out first class manifest list
		System.out.println("First");
		System.out.println();

		for(int col = 0; col < 2; col++) {
			for(int row = 0; row < 4; row++) {

				if(firstclass[row][col].getAvailability() == 'N') {
					System.out.print(firstclass[row][col].getSeatNumber());
					System.out.print(firstclass[row][col].getSeatLetter() + ": ");
					System.out.print(firstclass[row][col].getName());
					System.out.println();

				}//end if
			}//inner for

		} //outer for
		System.out.println();
		System.out.println();
		System.out.println("Economy");
		System.out.println();

		for(int x = 0; x < 20; x++) {
			for(int y = 0; y < 6; y++) {

				if (econclass[y][x].getAvailability() == 'N') {
					System.out.print(econclass[y][x].getSeatNumber());
					System.out.print(econclass[y][x].getSeatLetter() + ": ");
					System.out.print(econclass[y][x].getName());
					System.out.println();

				}//end if
			}//inner for


		}//outer for
		System.out.println();


	}


	/**
	 * Portrays an availability list of the airplane.
	 */
	public void availabilityList() {
		// TODO Auto-generated method stub

		System.out.println("Availability List:");
		System.out.println();
		System.out.println("First");
		System.out.println();


		//prints out first class availability
		for(int col = 0; col < 2; col++) {
			System.out.print(col + 1 + ": ");
			for(int row = 0; row < 4; row++) {
				if(firstclass[row][col].getAvailability() == 'Y') {

					System.out.print(firstclass[row][col].getSeatLetter());
					if(row != 3) {
						System.out.print(",");
					}//end inner if

				}//end if
			}//inner for
			System.out.println();

		}//outer for

		System.out.println();
		System.out.println("Economy");
		System.out.println();

		//prints out economy class availability
		for(int col = 0; col < 20; col++) {
			System.out.print(col + 10 + ": ");
			for(int row = 0; row < 6; row++) {
				if(econclass[row][col].getAvailability() == 'Y') {

					System.out.print(econclass[row][col].getSeatLetter());
					if(row != 5) {
						System.out.print(",");
					}//end inner if

				}//end if
			}//inner for
			System.out.println();
		}//outer for



	}


	/**
	 * Checks if a file exists from the terminal
	 * @param file - an argument on command line
	 */
	public void checkFileExistence(File file) {
		// TODO Auto-generated method stub
		//check if text file exists
		try {
			boolean createfile = file.createNewFile();

			if (createfile){
				System.out.println("File has been created.");
			}
			else{
				//read file here and input data from txt file into data structure
				System.out.println("File already exists, using data in file.");
				readTextFile(file);

			}

		} 
		catch (IOException e) {
			System.out.println("Exception Occurred:");
			e.printStackTrace();
		}
	}

	
	/**
	 * Reads the text file inputed from terminal
	 * @param file
	 * @throws FileNotFoundException
	 */
	private void readTextFile(File file) throws FileNotFoundException {
		// TODO Auto-generated method stub

		String filename = file.getName();
		Scanner scanner = new Scanner(new File(filename));
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String info[] = line.split("\\s*,\\s*");
			String seatNum = info[0].replaceAll("[^0-9]", "");
			String seatLet = info[0].replaceAll("[^A-Za-z]", ""); 
			int seatNumber = Integer.parseInt(seatNum);
			char seatLetter = seatLet.charAt(0);



			if(seatNumber < 10) {
				for(int col = 0 ; col < 2; col++) {
					for(int row = 0; row < 4; row++) {
						if(firstclass[row][col].getSeatNumber() == seatNumber && firstclass[row][col].getSeatLetter() == seatLetter) {
							if(info[1].equals("I")) {
								firstclass[row][col].setAvailability('N');
								firstclass[row][col].setName(info[2]);
							}
							else if(info[1].equals("G")) {
								firstclass[row][col].setGroupName(info[2]);
								firstclass[row][col].setAvailability('N');
								firstclass[row][col].setName(info[3]);
							}

						}
					}
				}

			}//end if

			else if(seatNumber >= 10){

				for(int row = 0 ; row < econclass.length; row++) {
					for(int col = 0; col < econclass[row].length; col++) {
						if(econclass[row][col].getSeatNumber() == seatNumber && econclass[row][col].getSeatLetter() == seatLetter) {
							if(info[1].equals("G")) {
								econclass[row][col].setGroupName(info[2]);
								econclass[row][col].setAvailability('N');
								econclass[row][col].setName(info[3]);
							}
							else if(info[1].equals("I")) {

								econclass[row][col].setAvailability('N');
								econclass[row][col].setName(info[2]);
							}

						}
					}
				}
			}


		}


	}

	/**
	 * Saves all reservations or cancellations to the text file inputted.
	 * @param file
	 */

	public void saveInfoToTextFile(File file) {



		try {

			String filename = file.getName();

			FileOutputStream erase = new FileOutputStream(filename);
			erase.write(("").getBytes());


			FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int row = 0; row < firstclass.length; row ++) {
				for(int col = 0; col < firstclass[row].length; col++) {
					if(firstclass[row][col].getAvailability() == 'N') {
						if(firstclass[row][col].getGroupName().equals(" ")) {


							bw.write(Integer.toString(firstclass[row][col].getSeatNumber()));
							bw.write(firstclass[row][col].getSeatLetter());
							bw.write(", I, ");
							bw.write(firstclass[row][col].getName());
							bw.newLine();




						}
						else {
							bw.write(Integer.toString(firstclass[row][col].getSeatNumber()));
							bw.write(firstclass[row][col].getSeatLetter());
							bw.write(", G, ");
							bw.write(firstclass[row][col].getGroupName());
							bw.write(", ");
							bw.write(firstclass[row][col].getName());
							bw.newLine();	



						}


					}
				}
			}
			for(int col = 0; col < 20; col ++) {
				for(int row = 0; row < 6; row++) {
					if(econclass[row][col].getAvailability() == 'N') {
						if(econclass[row][col].getGroupName() == " ") {
							bw.write(Integer.toString(econclass[row][col].getSeatNumber()));
							bw.write(econclass[row][col].getSeatLetter());
							bw.write(", I, ");
							bw.write(econclass[row][col].getName());
							bw.newLine();	
						}
						else {
							bw.write(Integer.toString(econclass[row][col].getSeatNumber()));
							bw.write(econclass[row][col].getSeatLetter());
							bw.write(", G, ");
							bw.write(econclass[row][col].getGroupName());
							bw.write(", ");
							bw.write(econclass[row][col].getName());
							bw.newLine();	

						}


					}
				}
			}


			bw.close();


		}
		catch (IOException e) {
			System.out.println("Exception Occurred:");
			e.printStackTrace();
		}



	}



	/**
	 * Sets up the first class seating with objects within each seat 
	 * in order to save important information on each seat.
	 * @param firstclass - 2D array of objects
	 */
	private void setupFirst(first[][] firstclass) {

		for(int row = 0; row < firstclass.length; row++) {
			for (int col = 0 ; col < firstclass[row].length; col++) {
				firstclass[row][col] = new first(" ", " ", 0, ' ', ' ' , 'Y'); 
			} //inner for
		} //outer for

		//sets up different seating arrangements
		for(int i = 0; i < 2; i++) {
			firstclass[0][i].setSeat('W');
			firstclass[3][i].setSeat('W');
			firstclass[1][i].setSeat('A');
			firstclass[2][i].setSeat('A');
		}

		char seatLetter = 'A';


		for(int x = 0; x < firstclass.length; x++) {
			for(int y = 0; y < firstclass[x].length; y++) {
				firstclass[x][y].setSeatNumber(y + 1);
				firstclass[x][y].setSeatLetter(seatLetter);
			}//inner for

			seatLetter = (char) (seatLetter + 1);
		}//outer for


	}


	/**
	 * Sets up the economy class seating with objects within each seat 
	 * in order to save important information on each seat.
	 * @param econclass - 2D array of objects
	 */
	private void setupEcon(economy[][] econclass) {


		//initialize economy class 
		for(int row = 0; row < econclass.length; row++) {
			for (int col = 0 ; col < econclass[row].length; col++) {
				econclass[row][col] = new economy(" ", " ", 0, ' ', ' ' , 'Y'); 
			} //inner for
		} //outer for


		for(int i = 0; i < 20; i++) {
			//set rows A & F as window seats
			econclass[0][i].setSeat('W');
			econclass[5][i].setSeat('W');

			//set row C & D as aisle seats
			econclass[2][i].setSeat('A');
			econclass[3][i].setSeat('A');

			//sets rows B & E as center seats
			econclass[1][i].setSeat('C');
			econclass[4][i].setSeat('C');
		}

		char seatLetter = 'A';


		for(int x = 0; x < econclass.length; x++) {
			for(int y = 0; y < econclass[x].length; y++) {
				econclass[x][y].setSeatNumber(y + 10);
				econclass[x][y].setSeatLetter(seatLetter);
			}//inner for

			seatLetter = (char)(seatLetter + 1);
		}//outer for



	}



}
