package mowerInventory;

// document description

// imports
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MowerWareHouse extends Mower {
	// declaring class variables
	private String storeName;
	private ArrayList<Mower> mowers; // stores mower data
	public ArrayList<String> completeMowers = new ArrayList<String>(); // stores mowers and mower subclass data
	private ArrayList<String> storage = new ArrayList<String>(); // stores subclasses until they're combined with main mower in completeMowers
	private Character type;
	public ArrayList<String> unformattedMowers = new ArrayList<String>(); // stores unformatted data to add to input file
	
	// store final objects based on mower type
	public ArrayList<String> commercialMowers = new ArrayList<String>(); // stores objects of subclass C
	public ArrayList<String> lawnTractors = new ArrayList<String>(); // stores objects of subclass L
	public ArrayList<String> gasPoweredMowers = new ArrayList<String>(); // store objects of subclass G
	public ArrayList<String> pushReelMowers = new ArrayList<String>(); // stores objects of subclass P
	
	// defining blank constructor
	public MowerWareHouse() {
		this.storeName = "none";
		this.mowers = new ArrayList<>();
	}
		
	// defining constructor with values to fit super class
	public MowerWareHouse(String manufacturer, int year, String serialNumber) {
		super(manufacturer, year, serialNumber);
		this.storeName = "none";
		this.mowers = new ArrayList<>(); // blank ArrayList is no values provided
	}
		
	// creating a constructor for when input is present
	public MowerWareHouse(ArrayList<Mower> mowers) {
		this.mowers = mowers;
	}
	
	// mutator methods
	protected void setStoreName(String storeName) {this.storeName = storeName;}
	
	// modified mutators to comply with list methods
	protected void addMower(Mower mower) {this.mowers.add(mower);}
	protected void removeMower(Mower mower) {this.mowers.remove(mower);}
	
	// accessor methods
	protected String getStoreName() {return this.storeName;}
	protected ArrayList<Mower> getMower() {return this.mowers;} // could call toString() method here
	
	// method to find main Mower class data
	public Character MowerDataCalc(ArrayList<String> mowerData) {
		this.setManufacturer(mowerData.get(0));
		mowerData.remove(0);
		this.setYear(Integer.parseInt(mowerData.get(0)));
		mowerData.remove(0);
		this.setSerialNumber(mowerData.get(0));
		mowerData.remove(0);
		type = Character.toUpperCase(mowerData.get(0).charAt(0));
		mowerData.remove(0);
		
		// adding mower to constructor by creating a new Mower object
		MowerWareHouse mowerWareHouse = new MowerWareHouse(getManufacturer(), getYear(), getSerialNumber());			
		// adding object to list
		mowers.add(mowerWareHouse);
	
		// returns character to be used for input for future functions
		return type;
	} // MowerDataCalc()
	
	// method to populate class for type C, commercialMower
	public void CommercialMowerCalc(ArrayList<String> mowerData) {
		Engine engine = new Engine(mowerData.get(0), Double.parseDouble(mowerData.get(1)), Integer.parseInt(mowerData.get(2)));
		// removing data that's been instantiated
		mowerData.remove(0);
		mowerData.remove(0);
		mowerData.remove(0);
		// creating a constructor for the lawnTractor
		LawnTractor lawnTractor = new LawnTractor(engine, mowerData.get(0), Double.parseDouble(mowerData.get(1)));
		// removing data that's been instantiated
		mowerData.remove(0);
		mowerData.remove(0);
		CommercialMower commercialMower = new CommercialMower(Double.parseDouble(mowerData.get(0)), Boolean.parseBoolean(mowerData.get(1)));
		// removing instantiated values
		mowerData.remove(0);
		mowerData.remove(0);
			
		// creating string objects
		String commercialObject = lawnTractor.toString() + commercialMower.toString();
		storage.add(commercialObject);
	} // CommercialMowerCalc()
	
	public void GasPoweredMowerCalc(ArrayList<String> mowerData) {
		// making a WalkBehindMower object
		GasPoweredMower walkBehindMower = new GasPoweredMower(Double.parseDouble(mowerData.get(0)), Double.parseDouble(mowerData.get(1)));
		// removing instantiated data
		mowerData.remove(0);
		mowerData.remove(0);
		// making an engine object
		Engine engine = new Engine(mowerData.get(0), Double.parseDouble(mowerData.get(1)), Integer.parseInt(mowerData.get(2)));
		// removing instantiated data
		mowerData.remove(0);
		mowerData.remove(0);
		mowerData.remove(0);
		// creating a constructor for GasPoweredMower
		GasPoweredMower gasPoweredMower = new GasPoweredMower(engine, Boolean.parseBoolean(mowerData.get(0)));
		mowerData.remove(0);
		// add value to storage list
		storage.add(walkBehindMower.toString() + engine.toString() + gasPoweredMower.addSelfPropelled());
	} // GasPoweredMowerCalc()
	
	public void PushReelMowerCalc(ArrayList<String> mowerData) {
		PushReelMower walkBehindMower = new PushReelMower(Double.parseDouble(mowerData.get(0)), Double.parseDouble(mowerData.get(1)));
		// removing instantiated data
		mowerData.remove(0);
		mowerData.remove(0);
		// making a pushReelMower object
		PushReelMower pushReelMower = new PushReelMower(Integer.parseInt(mowerData.get(0)));
		mowerData.remove(0);
		// add value to storage list
		storage.add(walkBehindMower.toString() + pushReelMower.addWheels());
	} // PushReelMowerCalc()
	
	public void LawnTractorCalc(ArrayList<String> mowerData) {
		Engine engine = new Engine(mowerData.get(0), Double.parseDouble(mowerData.get(1)), Integer.parseInt(mowerData.get(2)));
		// removing data that's been instantiated
		mowerData.remove(0);
		mowerData.remove(0);
		mowerData.remove(0);
		// creating a constructor for the lawnTractor
		LawnTractor lawnTractor = new LawnTractor(engine, mowerData.get(0), Double.parseDouble(mowerData.get(1)));
		// removing data that's been instantiated
		mowerData.remove(0);
		mowerData.remove(0);	
		// adding data value to list
		storage.add(lawnTractor.toString());
	} // LawnTractorCalc()
	
	public void MowerChoice(ArrayList<String> mowerData, Character type) {
		if (type == 'L') {
			LawnTractorCalc(mowerData);
		}
		else if (type == 'C') {
			CommercialMowerCalc(mowerData);
		}
		else if (type == 'G') {
			GasPoweredMowerCalc(mowerData);
		}
		else if (type == 'P' ) {
			PushReelMowerCalc(mowerData);
		}
	} // MowerChoice()
	
	// method to read file data
	@SuppressWarnings("resource")
	public void readMowerData(String inputFileName) throws IOException {		
		// making file with name passed to method
		try {
			FileReader fr = new FileReader(inputFileName);
			Scanner fs = new Scanner(fr);
			
			// temporary ArrayList storage
			ArrayList<String> mowerData = new ArrayList<String>();
			
			// as long as data is present, read data and put it into the Mower class.
			while(fs.hasNext()) {
				// adding all values to an ArrayList
				mowerData.add(fs.nextLine());
			} // while loop
			
			// separating storeName and removing element from list
			this.storeName = mowerData.get(0);
			mowerData.remove(0);
			
			// local variable for appending to completeMowers
			int count = 0;
			
			// starting with blank list
			completeMowers.clear();
			
			// assigning Mower class with proper subclass
			while (mowerData.size() > 0) {
				MowerDataCalc(mowerData);
				MowerChoice(mowerData, type);
			
				// adding mowers class to mower subclass data
				completeMowers.add("\n" + mowers.get(count).toString() + "Subclass: " + type + "\n" + storage.get(0).toString());
				
				// adding to specific lists based on type
				if (type == 'C') {
					commercialMowers.add("\n" + mowers.get(count).toString() + "Subclass: " + type + "\n" + storage.get(0).toString());
				}
				else if (type == 'L') {
					lawnTractors.add("\n" + mowers.get(count).toString() + "Subclass: " + type + "\n" + storage.get(0).toString());
				}
				else if (type == 'G') {
					gasPoweredMowers.add("\n" + mowers.get(count).toString() + "Subclass: " + type + "\n" + storage.get(0).toString());
				}
				else if (type == 'P') {
					pushReelMowers.add("\n" + mowers.get(count).toString() + "Subclass: " + type + "\n" + storage.get(0).toString());
				}
				
				// clearing list
				storage.remove(0);
				
				// Incrementing count 
				count++;
			} // second while loop			
			// testing
			//System.out.println(completeMowers);// TODO add back in for testing
		} // try block
		
		catch (FileNotFoundException e) {
			System.out.println("File: " + inputFileName + " not found. Please use JFileChooser window instead.");
			// creating file chooser object
			final JFileChooser j = new JFileChooser();
			// filter to only allow the user to open .txt files
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files only", "txt");
			j.setFileFilter(filter);
			// opening directory
			int returnVal = j.showOpenDialog(null);
			// ensures filters are adhered to 
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				// recursive call to iterate through function with selected file
				readMowerData(j.getSelectedFile().getName());
			}
			
		}
	} // readMowerData()
	
	// method to create new mower objects
	@SuppressWarnings("resource")
	public void createMowerObject() {
		// creating a scanner for the method
		Scanner mowerScnr = new Scanner(System.in);
		boolean go = true;
		Character choice = 'M';

		// first display of user message
		System.out.println("Enter type of mower to add. Type C for Commercial Mower, G for Gas Powered Mower, P for Push reel Mower, L for Lawn Tractor, or S for stop.");
		choice = Character.toUpperCase(mowerScnr.next().charAt(0));
		
		// creating while loop to allow user to add unlimited mower objects
		while (go == true) {
			// sentinel value
			if (choice.equals('S')) {
				System.out.println("Mowers added!");
				go = false;
			}
			else {
				try {
					// uniform data (Mower class)
					System.out.println("Enter basic mower data: ");
					// adding mower object, universal for all mowers
					System.out.println("Manufacturer: ");
					String manufacturer = mowerScnr.next();
					System.out.println("Year: ");
					int year = mowerScnr.nextInt();
					System.out.println("Serial Number: ");
					String serialNumber = mowerScnr.next();
					// creating output format and objects
					MowerWareHouse mowerWareHouse = new MowerWareHouse(manufacturer, year, serialNumber);
					String mowerWareHouseString = ("\n" + manufacturer + "\n" + year + "\n" + serialNumber + "\n");
					
					// adding objects based on choice
					if (choice.equals('C')) {
						// reading parameters
						System.out.println("Engine Manufacturer: ");
						String engineManufacturer = mowerScnr.next();
						System.out.println("Horsepower: ");
						double horsepower = mowerScnr.nextDouble();
						System.out.println("Cylinders: ");
						int cylinders = mowerScnr.nextInt();
						System.out.println("Model: ");
						String model = mowerScnr.next();
						System.out.println("Deck Width: ");
						double deckWidth = mowerScnr.nextDouble();
						System.out.println("Operating Hours: ");
						double operatingHours = mowerScnr.nextDouble();
						System.out.println("Zero Turn Radius: ");
						boolean zeroTurnRadius = mowerScnr.nextBoolean();
						// assigning to objects
						Engine engine = new Engine(engineManufacturer, horsepower, cylinders);
						LawnTractor lawnTractor = new LawnTractor(engine, model, deckWidth);
						CommercialMower commercialMower = new CommercialMower(operatingHours, zeroTurnRadius);
						
						// adding to list
						mowers.add(mowerWareHouse);
						completeMowers.add(mowerWareHouse.toString() + "Subclass: " + choice + "\n" + engine.toString() + lawnTractor.toString() + commercialMower.toString());
						
						// string objects
						String engineString = (engineManufacturer + "\n" + horsepower + "\n" + cylinders + "\n");
						String lawnTractorString = (model + "\n" + deckWidth + "\n");
						String commercialMowerString = (mowerWareHouseString + choice + "\n" + engineString + lawnTractorString + operatingHours + "\n" + zeroTurnRadius);
						unformattedMowers.add(commercialMowerString);
						
						// next choice 
						System.out.println("Enter type of mower to add. Type C for Commercial Mower, G for Gas Powered Mower, P for Push reel Mower, L for Lawn Tractor, or S for stop.");
						choice = Character.toUpperCase(mowerScnr.next().charAt(0));
					} // choice C
					
					else if (choice.equals('G')) {
						// reading parameters
						System.out.println("Engine Manufacturer: ");
						String engineManufacturer = mowerScnr.next();
						System.out.println("Horsepower: ");
						double horsepower = mowerScnr.nextDouble();
						System.out.println("Cylinders: ");
						int cylinders = mowerScnr.nextInt();
						System.out.println("Cut Width: ");
						double cutWidth = mowerScnr.nextDouble();
						System.out.println("Wheel Diameter: ");
						double wheelDiameter = mowerScnr.nextDouble();
						System.out.println("Self Propelled: ");
						boolean selfPropelled = mowerScnr.nextBoolean();
						// assigning to objects
						Engine engine = new Engine(engineManufacturer, horsepower, cylinders);
						GasPoweredMower walkBehindMower = new GasPoweredMower(cutWidth, wheelDiameter);
						GasPoweredMower gasPoweredMower = new GasPoweredMower(engine, selfPropelled);
						
						// adding to list
						mowers.add(mowerWareHouse);
						completeMowers.add(mowerWareHouse.toString() + engine.toString() + "Subclass: " + choice + "\n" + walkBehindMower.toString() + gasPoweredMower.addSelfPropelled());
						
						// string objects
						String engineString = (engineManufacturer + "\n" + horsepower + "\n" + cylinders + "\n");
						String walkBehindMowerString = (cutWidth + "\n" + wheelDiameter + "\n");
						String gasPoweredMowerString = (mowerWareHouseString + choice + "\n" + walkBehindMowerString + engineString + selfPropelled);
						unformattedMowers.add(gasPoweredMowerString);
						
						// next choice 
						System.out.println("Enter type of mower to add. Type C for Commercial Mower, G for Gas Powered Mower, P for Push reel Mower, L for Lawn Tractor, or S for stop.");
						choice = Character.toUpperCase(mowerScnr.next().charAt(0));
					} // choice G
					
					else if (choice.equals('P')) {
						// reading parameters
						System.out.println("Cut Width: ");
						double cutWidth = mowerScnr.nextDouble();
						System.out.println("Wheel Diameter: ");
						double wheelDiameter = mowerScnr.nextDouble();
						System.out.println("Number of Wheels: ");
						int numWheels = mowerScnr.nextInt();
						// assigning to objects
						PushReelMower walkBehindMower = new PushReelMower(cutWidth, wheelDiameter);
						PushReelMower pushReelMower = new PushReelMower(numWheels);
						
						// adding to list
						mowers.add(mowerWareHouse);
						completeMowers.add(mowerWareHouse.toString() + "Subclass: " + choice + "\n" + walkBehindMower.toString() + pushReelMower.toString());
						
						// string objects
						String walkBehindMowerString = (cutWidth + "\n" + wheelDiameter + "\n");
						String pushReelMowerString = (mowerWareHouseString + choice + "\n" + walkBehindMowerString + numWheels);
						unformattedMowers.add(pushReelMowerString);
						
						// next choice 
						System.out.println("Enter type of mower to add. Type C for Commercial Mower, G for Gas Powered Mower, P for Push reel Mower, L for Lawn Tractor, or S for stop.");
						choice = Character.toUpperCase(mowerScnr.next().charAt(0));
					} // choice P
					
					else if (choice.equals('L')) {
						// reading parameters
						System.out.println("Engine Manufacturer: ");
						String engineManufacturer = mowerScnr.next();
						System.out.println("Horsepower: ");
						double horsepower = mowerScnr.nextDouble();
						System.out.println("Cylinders: ");
						int cylinders = mowerScnr.nextInt();
						System.out.println("Model: ");
						String model = mowerScnr.next();
						System.out.println("Deck Width: ");
						double deckWidth = mowerScnr.nextDouble();
						// assigning to objects
						Engine engine = new Engine(engineManufacturer, horsepower, cylinders);
						LawnTractor lawnTractor = new LawnTractor(engine, model, deckWidth);
						
						// adding to list
						mowers.add(mowerWareHouse);
						completeMowers.add(mowerWareHouse.toString() + "Subclass: " + choice + "\n" + engine.toString() + lawnTractor.toString());
						
						// string objects
						String engineString = (engineManufacturer + "\n" + horsepower + "\n" + cylinders + "\n");
						String lawnTractorString = (model + "\n" + deckWidth + "\n");
						String lawnTractorMowerString = (mowerWareHouseString + choice + "\n" + engineString + lawnTractorString);
						unformattedMowers.add(lawnTractorMowerString);
						
						// next choice 
						System.out.println("Enter type of mower to add. Type C for Commercial Mower, G for Gas Powered Mower, P for Push reel Mower, L for Lawn Tractor, or S for stop.");
						choice = Character.toUpperCase(mowerScnr.next().charAt(0));
					} // choice L
					else {
						System.out.println("Invalid option.");
						
						// next choice 
						System.out.println("Enter type of mower to add. Type C for Commercial Mower, G for Gas Powered Mower, P for Push reel Mower, L for Lawn Tractor, or S for stop.");
						choice = Character.toUpperCase(mowerScnr.next().charAt(0));
					}
				} // try
				// if user inputs wrong value, code doesn't break
				catch (InputMismatchException e){
					System.out.println("Invalid input. Please start over.\n");
				}
				// catch all
				catch (Exception e) {
					System.out.println("Bad data. Please start over.\n");
				} // final catch
			} // else
		} // while loop
	} // createMowerObject();
	
	// method to append unformatted user data
	public void appendUnformatted(String inputFileName) throws IOException {
		FileWriter fw = new FileWriter(inputFileName, true);
		PrintWriter pw = new PrintWriter(fw);
		
		// adding unformatted data to file
		for (int i=0; i<unformattedMowers.size(); i++) {
			pw.print(unformattedMowers.get(i));
		}
		
		// closing PrintWriter
		pw.close();
	}
	
	// method to read in a new mower object
	@SuppressWarnings("resource")
	public void addMower() {
		// creating a scanner object
		Scanner scnr = new Scanner(System.in);
		// communicate with user
		System.out.println("Would you like to add a new mower to the file? Y/N.");
		// read input
		Character choice = Character.toUpperCase(scnr.next().charAt(0));
		// adding mower objects based on on user input
		if (choice.equals('Y')) {
			// reading and adding objects using prompts
			createMowerObject();
		}
		else {
			System.out.println("Enter subclass to see available mowers: ");
		}
	}

	// method to save file data
	public void saveMowerData(String outputFileName) throws IOException {
		PrintWriter pw = new PrintWriter(outputFileName);
		// printing title first
		pw.print("Store Name:\n" + getStoreName() + "\n\n");
		
		// for loop to format output
		int number = 1;
		for (int i=0; i<completeMowers.size(); i++) {
			pw.print("Mower " + number + ":");
			pw.print(completeMowers.get(i));
			pw.print("\n");
			number++;
		} // for loop
		pw.close();
	} // saveMowerData()
	
	/*
	// main method for testing
	public static void main(String[] args) {
		MowerWareHouse mowerWareHouse = new MowerWareHouse("hi", 1, "bye");
		
		// creating scanner and reading file name
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = "src/mowerInventory/MP2_Dataset.txt";
		
		try {
			mowerWareHouse.readMowerData(fileName);
			mowerWareHouse.saveMowerData("src/mowerInventory/test.txt");
		}
		
		catch (IOException e) {
			System.out.println("Wrong file");
		}

		// declaring variable for while loop
		boolean go = true;
		
		// while loop to allow user to read data
		while (go == true) {
			mowerWareHouse.userMessage();
			Character choice = Character.toUpperCase(scnr.next().charAt(0));
			if (choice == 'G') {
				for (int i=0; i<completeMowers.size(); i++) {
					if
				}
			}
		
		scnr.close();		
	} // main
	*/
	
} // class
