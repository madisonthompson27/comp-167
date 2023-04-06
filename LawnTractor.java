package mowerInventory;

// document description

// ensures uniform code and makes sure that code is uniform
public class LawnTractor extends Mower {
	// declaring reference variables
	private Engine engine = new Engine();
	private String model;
	private double deckWidth;
	
	// creating a constructor for the lawnTractor
	public LawnTractor() {
		this.engine.setManufacturer("none");
		this.engine.setHorsePower(-1.0);
		this.engine.setCylinders(-1);
		this.model = "none";
		this.deckWidth = -1.0;
	}
	
	// creating a constructor for the lawnTractor with variables
	public LawnTractor(Engine engine, String model, double deckWidth) {
		this.engine = engine;
		this.model = model;
		this.deckWidth = deckWidth;
	}
	
	// mutator methods
	protected void setModel(String model) {this.model = model;}
	protected void setDeckWidth(double deckWidth) {this.deckWidth = deckWidth;}
	
	// accessor methods
	protected String getModel() {return this.model;}
	protected double getDeckWidth() {return this.deckWidth;}
	
	// method to make properties readable
	public String toString() {
		return (this.engine.toString() + "Model: " + this.model + "\n" + "Deck width: " + this.deckWidth + "\n");
	}	
	
	/*
	// testing
	public static void main(String[] args) {
		LawnTractor lawnTractor = new LawnTractor();
		lawnTractor.engine.setManufacturer("Moo Inc.");
		lawnTractor.engine.setHorsePower(12.0);
		lawnTractor.engine.setCylinders(8);
		
		lawnTractor.setModel("Best");
		lawnTractor.setDeckWidth(12.0);
			
		System.out.println(lawnTractor.toString());
	}
	*/
	
} // class