package mowerInventory;

// document description

// imports
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class MowerWareHouse extends Mower {
	// declaring class variables
	private String storeName;
	private ArrayList<Mower> mowers; // stores mower data
	public ArrayList<String> completeMowers = new ArrayList<String>(); // stores mowers and mower subclass data
	private ArrayList<String> storage = new ArrayList<String>(); // stores subclasses until they're combined with main mower in completeMowers
	private Character type;
	
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
		storage.add(walkBehindMower.toString() + gasPoweredMower.addSelfPropelled() + engine.toString());
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
			
			
			fs.close();
			// testing
			//System.out.println(completeMowers);// TODO add back in for testing
		} // try block
		
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + inputFileName);
		}
	} // readMowerData()

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