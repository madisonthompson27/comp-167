package mowerInventory;

// document description

public class CommercialMower {
	// declaring reference variables
	private double operatingHours;
	private boolean zeroTurnRadius;
	
	// creating the blank constructor and assigning default values
	public CommercialMower() {
		this.operatingHours = -1.0;
		this.zeroTurnRadius = false;
	}
	
	// creating a constructor with values for CommercialMower()
	public CommercialMower(double operatingHours, boolean zeroTurnRadius) {
		this.operatingHours = operatingHours;
		this.zeroTurnRadius = zeroTurnRadius;
	}
	
	// creating mutator methods
	protected void setOperatingHours(double operatingHours) {this.operatingHours = operatingHours;}
	protected void setZeroTurnRadius(boolean zeroTurnRadius) {this.zeroTurnRadius = zeroTurnRadius;}
	
	// creating accessor methods
	protected double getOperatingHours() {return this.operatingHours;}
	protected boolean getZeroTurnRadius() {return this.zeroTurnRadius;}
	
	// creating toString method for readability
	public String toString() {
		LawnTractor lawnTractor = new LawnTractor();
		return ("Operating Hours: " + this.operatingHours + "\n" + "Zero Turn Radius: " + this.zeroTurnRadius + "\n");
	}
}