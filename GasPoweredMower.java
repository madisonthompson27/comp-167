package mowerInventory;

// document description

public class GasPoweredMower extends WalkBehindMower {
	// creating class variables
	private Engine engine = new Engine();
	private boolean selfPropelled;
	
	// creating the constructor for the class, giving initial values. 
	public GasPoweredMower() {
		// engine settings
		engine.setManufacturer("none");
		engine.setHorsePower(-1.0);
		engine.setCylinders(0);
		
		// class-specific variable settings
		selfPropelled = false;
	}
	
	// creating a constructor with values for the class
	public GasPoweredMower(Engine engine, boolean selfPropelled) {
		this.selfPropelled = selfPropelled;
	}
	
	// creating a constructor that allows the abstract class to be instantiated
	public GasPoweredMower(double cutWidth, double wheelDiameter) {
		super(cutWidth, wheelDiameter);
		super.toString();
	}
	
	// mutator method for selfPropelled
	protected void setSelfPropelled(boolean selfPropelled) {this.selfPropelled = selfPropelled;}
	
	// accessor method for selfPropelled
	protected boolean getSelfPropelled() {return this.selfPropelled;}
	
	// toString() method to make data readable to user
	public String toString() {
		return (super.toString());
	}
	
	public String addSelfPropelled() {
		return ("Self Propelled: " + this.selfPropelled + "\n");
	}
	
	/*
	// testing
	public static void main(String[] args) {
		GasPoweredMotor gasPoweredMotor = new GasPoweredMotor();
		
		// setting engine values
		gasPoweredMotor.engine.setManufacturer("Moo inc.");
		gasPoweredMotor.engine.setHorsePower(12.0);
		gasPoweredMotor.engine.setCylinders(8);
		
		// setting boolean value
		gasPoweredMotor.setSelfPropelled(true);
		
		// calling string output
		System.out.println(gasPoweredMotor.toString());
	}
	*/
	
} // class