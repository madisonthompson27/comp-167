package mowerInventory;

// document description

public abstract class Mower {
	// declaring reference variables
	private String manufacturer;
	private int year;
	private String serialNumber;
	
	// creating blank Mower() constructor
	public Mower() {
		this.manufacturer = "none";
		this.year = -1;
		this.serialNumber = "none";
	}
	
	// creating Mower() constructor with values that fill in based on mutator methods
	public Mower(String manufacturer, int year, String serialNumber) {
		this.manufacturer = manufacturer;
		this.year = year;
		this.serialNumber = serialNumber;
	}
	
	// creating mutator methods
	protected void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}
	protected void setYear(int year) {this.year = year;}
	protected void setSerialNumber(String serialNumber) {this.serialNumber = serialNumber;}
	
	// creating accessor methods
	protected String getManufacturer() {return this.manufacturer;}
	protected int getYear() {return this.year;}
	protected String getSerialNumber() {return this.serialNumber;}
	
	// to string method to make data more readable, outputs each property on a separate line
	public String toString() {
		return ("Manufacturer: " + this.manufacturer + "\n" + "Year: " + this.year + "\n" + "Serial Number: " + this.serialNumber + "\n");
	}
	
} // abstract class Mower