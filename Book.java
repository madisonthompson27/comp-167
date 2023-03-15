package libraryDatabase;

// document description
// Assigns default values to blank cells in csv, or assigns them from values read using the second constructor. 

// imports
//import java.util.Scanner; // TODO comment back in if testing

public class Book {

	// declaring reference variables
	private Author author;
	private String title;
	private int year;
	private String publisher;
	private String genre;
	private double rating;
	private double price;
	
	
	// constructor that holds default values, called when no input is provided.
	public Book() {
		// declaring default values for author
		this.author.setFirstName("none");
		this.author.setLastName("none");
		
		// declaring default value for title as "None"
		this.title = "none";
		
		// declaring default value for year as -1
		this.year = -1;
		
		// declaring default value for publisher and genre as "none"
		this.publisher = "none";
		this.genre = "none";
		
		// declaring default value for rating and price as -1.0 (doubles)
		this.rating = -1.0;
		this.price = -1.0;
	} // constructor Book()
	
	// override constructor for usage when values are given.
	public Book(Author author, String title, int year, String publisher, String genre, double rating, double price) {
		// declaring values for the author class
		this.author = author;
		
		// declaring each variable to match the input provided, in respective order.
		this.title = title;
		this.year = year;
		this.publisher = publisher;
		this.genre = genre; 
		this.rating = rating;
		this.price = price;
	}
	
	// accessor and mutator methods
	
	// methods for author being called from the class
	protected void setAuthor(Author author) {this.author = author;}
	
	// mutators (setters) for normal members (title-price)
	protected void setTitle(String title) {this.title = title;}
	protected void setYear(int year) {this.year = year;}
	protected void setPublisher(String publisher) {this.publisher = publisher;}
	protected void setGenre(String genre) {this.genre = genre;}
	protected void setRating(double rating) {this.rating = rating;}
	protected void setPrice(double price) {this.price = price;}
	
	
	// accessor for author class
	protected Author getAuthor() {return this.author;}
	
	// accessors (getters) for normal members (title-price)
	protected String getTitle() {return this.title;}
	protected int getYear() {return this.year;}
	protected String getPublisher() {return this.publisher;}
	protected String getGenre() {return this.genre;}
	protected double getRating() {return this.rating;}
	protected double getPrice() {return this.price;}
	
	
	// toString() method to return values from the array list as a string
	public String toString() {
			
		return  "\n" +"Book " + ": {" +  // brackets help improve user readability
			author +			
			", Title: " + title +
			", Year: " + year +
			", Publisher: " + publisher +
			", Genre: " + genre + 
			", Rating: " + rating + 
			", Price: $" + price +
			"}";
	}
	
	/*
	// testing 
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		// test input variables
		System.out.println("Title: ");
		String userTitle = scnr.nextLine();
		
		System.out.println("Year: ");
		int userYear = scnr.nextInt();
		
		System.out.println("Publisher: ");
		String userPublisher = scnr.nextLine();
		
		System.out.println("Genre: ");
		String userGenre = scnr.nextLine();

		System.out.println("Rating: ");
		double userRating = scnr.nextDouble();

		System.out.println("Price: ");
		double userPrice = scnr.nextDouble();
		
		// creating two options from each constructor
		Book option1 = new Book(userTitle, userYear, userPublisher, userGenre, userRating, userPrice);
		Book option2 = new Book();
		
		System.out.println(option1);
		System.out.println(option2);
		
	}
	*/
} // class Book
