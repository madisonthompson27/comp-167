package carnivalRides;

// importing a scanner to read user input values
import java.util.Scanner;

public class methompson1_hotAirBalloon {

	public static void main(String[] args) {
		
		// creating a scanner
		Scanner scnr = new Scanner(System.in);
		
		// declaring variable types and initializing with the value 0.
		int numPeople = 0;
		int weight = 0;
		int tempWeight = 0;
		
		// declaring loop variable outside of loop so that it can be used in the if statements following loop execution. 
		int i = 0;

		// reassigning the int var numPeople to read a user's input of the number of people riding the balloon.
		System.out.print("Enter the number of people riding the balloon: ");
		numPeople = scnr.nextInt();
		
		// creating a loop that reads the reads each passenger's weight, and adds the total to output whether the group can ride.
		// NOTE: the group is seen as all passengers, so if they exceed the weight limit, none will ride. 
		for (i = 0; i < numPeople; ++i) {
			
			// reading the input value tempWeight for each passenger
			System.out.print("Enter the weight of the passenger: ");
			tempWeight = scnr.nextInt();
			
			// adding the weights of each passenger
			weight += tempWeight; 
		}
		
		// following the loop's execution, the value of the int var weight is checked to see if the group can ride. 
		if (weight <= 500) {
			System.out.println("The group of " + i + " passengers weighs " + weight + " pounds and will be able to ride the balloon together.");
		}
		
		// if the weight of the group exceeds 500 pounds, the group cannot ride the balloon together. 
		else {
			System.out.println("The group of " + i + " passengers weighs " + weight + " pounds and will not be able to ride the balloon together.");

		}
	}

}
