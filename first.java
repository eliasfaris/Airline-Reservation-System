/**
 * @author Elias Faris
 * version 1.0 9/12/2020
 */

/**
 * 
 * first class to set up each first class seat as an object.
 */

public class first {
	
	
		String name;
		String groupName;
		int seatNumber;
		char seatLetter;
		char seat;
		char availability;
		
		/**
		 * Constructor for first class
		 * @param name - name of passenger
		 * @param seatNumber - seat number
		 * @param seatLetter - seat letter 
		 * @param seat - seat arrangement: window, aisle
		 * @param availability - seat availability
		 */
		
		public first(String name, String groupName, int seatNumber, char seatLetter, char seat, char availability) {
			super();
			this.name = name;
			this.groupName = groupName;
			this.seatNumber = seatNumber;
			this.seatLetter = seatLetter;
			this.seat = seat;
			this.availability = availability;
		}
		
		/**
		 * 
		 * @return group name
		 */
		public String getGroupName() {
			return groupName;
		}
		/**
		 * 
		 * @param gn - the group name
		 */
		public void setGroupName(String gn) {
			this.groupName = gn;
		}
		
		/**
		 * 
		 * @return name
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * 
		 * @param n - name
		 */
		public void setName(String n) {
			this.name = n;
		}
		/**
		 * 
		 * @return seat number
		 */
		public int getSeatNumber() {
			return seatNumber;
			
		}
		/**
		 * 
		 * @param sn - seat number
		 */
		public void setSeatNumber(int sn) {
			this.seatNumber = sn;
			
		}
		/**
		 * 
		 * @return seat letter
		 */
		public char getSeatLetter() {
			return seatLetter;
		}
		/**
		 * 
		 * @param sl - seat letter
		 */
		public void setSeatLetter(char sl) {
			this.seatLetter = sl;
		}
		/**
		 * 
		 * @return seat 
		 */
		public char getSeat() {
			return seat;
			
		}
		/**
		 * 
		 * @param s - seat
		 */
		public void setSeat(char s) {
			this.seat = s;
			
		}
		/**
		 * 
		 * @return availability
		 */
		public char getAvailability() {
			return availability;
			
		}
		/**
		 * 
		 * @param a - availability
		 */
		public void setAvailability(char a) {
			this.availability = a;
		}
	}
	
	

