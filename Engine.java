package mowerInventory;

// document description

public class Engine {

	// declaring variables
	private String manufacturer;
	private double horsePower;
	private int cylinders;
	
	// creating the Engine() constructor
	public Engine() {
		this.manufacturer = "none"; // default values if none are entered
		this.horsePower = -1.0; // default -1.0 indicates no value provided
		this.cylinders = -1; // default -1 indicates no value provided
	}
	
	// creating a second constructor that uses all the variables created
	public Engine(String manufacturer, double horsePower, int cylinders) {
		this.manufacturer = manufacturer;
		this.horsePower = horsePower;
		this.cylinders = cylinders; // instantiating the Engine() object with user-provided values 
	}
	
	// creating mutator methods
	protected void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}
	protected void setHorsePower(double horsePower) {this.horsePower = horsePower;}
	protected void setCylinders(int cylinders) {this.cylinders = cylinders;}
	
	// creating accessor methods
	protected String getManufacturer() {return this.manufacturer;}
	protected double getHorsePower() {return this.horsePower;}
	protected int getCylinders() {return this.cylinders;}
	
	// to string method to properly format data and improve console readability
	public String toString() {
		return ("Engine Manufacturer: " + this.manufacturer + "\n" + "Horsepower: " + this.horsePower + "\n" + "Cylinders: " + this.cylinders + "\n");
	}
	
	/*
	// testing
	public static void main(String[] args) {
		Engine engine = new Engine();
		
		engine.setManufacturer("Moo inc.");
		engine.setHorsePower(12.0);
		engine.setCylinders(8);
		
		System.out.println(engine.toString());
		
		Engine engine2 = new Engine();
		
		System.out.println(engine2.toString());
	}
	*/
} // class Engine