package carnivalRides;

// importing the scanner to be used to read user inputs
import java.util.Scanner;

public class HotAirBalloon {

	public static void main(String[] args) {
		
		// creating a scanner to read input values
		Scanner scnr = new Scanner(System.in);
		
		// declaring variables
		int numPeople= 0;
		int weight = 0;
		int eachWeight = 0;
		
		// reading the number of people as a user input
		System.out.print("Enter number of people riding balloon: ");
		numPeople = scnr.nextInt();
		
			
		// as long as the number of people hasn't been reached, the loop will continue to read weights
		// and add those weights to the accumulating value. 
		for (int i = 1; i <= numPeople; i++) {
			
			// verifying that weight is less than 500
			if (weight < 500) {

				// reading input weight
				System.out.print("Enter weight of passenger: ");
				eachWeight = scnr.nextInt();
				
				// making sure that the total weight will not be over 500
				if ((weight + eachWeight) <= 500) {
					weight += eachWeight;
				}
				
				// if the weight would exceed 500, the total weight and number of people that can ride
				// are output by the system.
				else {
					
					// if the first passenger's weight is over 500, then i must be reduced to 0 before the output message.
					if (eachWeight > 500) {
						System.out.println("No passengers can ride the balloon.");
						
						// loop will be broken because the balloon could not support the passenger's weight. 
						break;
					}
					
					// otherwise, the program proceeds as if the last passenger could not be added.
					else {
					System.out.println(i + " out of " + numPeople + " passengers can ride the ballon. Their weight will be " + weight + " pounds.");
					
					// break statement stops the code from iterating once maximum capacity has been reached. 
					break;
					}
				}
			
			// if the weight is 500, then the number of passengers that can ride and their weight are output. 
			if (weight == 500) {
				System.out.println(i + "out of" + numPeople + " passengers can ride the ballon. Their weight will be " + weight + " pounds.");
				
				// break statement stops the code from iterating once maximum capacity has been reached. 
				break;
			}
			
			}
		
		}
		
		// printing a goodbye message so that the user knows the program has finished executing
		System.out.println("Have a safe ride!");
		
	}

}
// EOF
