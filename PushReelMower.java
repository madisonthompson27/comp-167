package mowerInventory;

// document description

class PushReelMower extends WalkBehindMower {
	// declaring private variables
	private int numWheels;
	
	// creating constructor with default values
	public PushReelMower() {
		this.numWheels = -1;
	}
	
	// creating constructor with values for numWheels
	public PushReelMower(int numWheels) {
		this.numWheels = numWheels;
	}
	
	// creating constructor with values for abstract class
	public PushReelMower(double cutWidth, double wheelDiameter) {
		super(cutWidth, wheelDiameter);
	}
	
	// mutator method for numWheels
	protected void setNumWheels(int numWheels) {this.numWheels = numWheels;}
	
	// accessor method for numWheels
	protected int getNumWheels() {return this.numWheels;}
	
	// toString() method for readability
	public String toString() {
		return (super.toString());
	}
	public String addWheels() {
		return ("Number of Wheels: " + this.numWheels + "\n");
	}
	
	/*
	// testing
	public static void main(String[] args) {
		PushReelMower pushReelMower = new PushReelMower();
		pushReelMower.setNumWheels(4);
		
		System.out.println(pushReelMower.toString());
	}
	*/
} // class
