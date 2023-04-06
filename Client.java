package mowerInventory;

import java.io.IOException;

// document description

// imports
import java.util.Scanner;

public class Client {
	// boolean for while loop
	public static boolean go = true;
	public static Character choice;
	
	// message that will appear to guide mower selection.
	public static void userMessage() {
		System.out.println("Type C for Commercial Mower, G for Gas Powered Mower, P for Push reel Mower, L for Lawn Tractor, and S to stop:");
	}
	
	public static void main(String[] args) throws IOException {
		// creating scanner to read input and output file names
		Scanner fileScnr = new Scanner(System.in);
		
		// creating MowerWareHouse object
		MowerWareHouse mowerWareHouse = new MowerWareHouse();
		
		// prompting user for file name
		System.out.print("Enter name of file to read: ");
		String inputFileName = fileScnr.next();
		
		// reading data
		mowerWareHouse.readMowerData(inputFileName);
		//System.out.println(mowerWareHouse.completeMowers); // testing to see if data goes to file
		
		// running while loop to print values as user wishes
		while (go == true) {
			// printing menu option
			userMessage();
			choice = Character.toUpperCase(fileScnr.next().charAt(0));
			
			// if statements to determine which data to print
			if (choice == 'S') {
				break;
			}
			else if (choice == 'C') {
				System.out.println(mowerWareHouse.commercialMowers);
			}
			else if (choice == 'L') {
				System.out.println(mowerWareHouse.lawnTractors);
			}
			else if (choice == 'G') {
				System.out.println(mowerWareHouse.gasPoweredMowers);
			}
			else if (choice == 'P') {
				System.out.println(mowerWareHouse.pushReelMowers);
			}
			else {
				System.out.println("Invalid option. Please try again.");
			}
		} // while loop
		
		// save data to file
		System.out.print("Enter name of file to save data to: ");
		String outputFileName = fileScnr.next();
		
		mowerWareHouse.saveMowerData(outputFileName);
		
		// user exit messages
		System.out.println("File: " + outputFileName + " saved successfully.");
		System.out.println("Thank you for using the mower database!");
	} // main method // FIXME add ability to create new mower object

} // Client class