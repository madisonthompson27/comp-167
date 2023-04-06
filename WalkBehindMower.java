package mowerInventory;

// document description

// is an extension of the mower class, ensures uniform code
public abstract class WalkBehindMower extends Mower {
	// initializing reference variables
	private double cutWidth;
	private double wheelDiameter;
	
	// creating constructor and assigning default values
	public WalkBehindMower() {
		this.cutWidth = -1.0;
		this.wheelDiameter = -1.0;
	}
	
	// creating another constructor for given values
	public WalkBehindMower(double cutWidth, double wheelDiameter) {
		this.cutWidth = cutWidth;
		this.wheelDiameter = wheelDiameter;
	}
	
	// creating mutator methods
	protected void setCutWidth(double cutWidth) {this.cutWidth = cutWidth;}
	protected void setWheelDiameter(double wheelDiameter) {this.wheelDiameter = wheelDiameter;}
	
	// creating accessor methods
	protected double getCutWidth() {return this.cutWidth;}
	protected double getWheelDiameter() {return this.wheelDiameter;}
	
	// creating a toString override method to improve readability
	public String toString() {
		return ("Cut Width: " + this.cutWidth + "\n" + "Wheel Diameter: " + this.wheelDiameter + "\n");
	}
}