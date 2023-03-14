package libraryDatabase;
//this code allows the user to input the author of a book, and if no values are provided, they will be assigned. This is done by overriding two constructors.


// imports
import java.util.Scanner;

public class Author {

	// declaring class variables 
	private String firstName;
	private String lastName;
	
	
	// creating first constructor, used for when values aren't entered for Author.
	public Author() {
		// if values aren't entered, the names will be instantiated as "none".
		this.firstName = "none";
		this.lastName = "none";
	}
	
	
	// creating a second constructor that can access and modify the user's inputs for firstName and lastName.
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	// accessor and modifier methods 
	
	// creating setters for first and last name
	protected void setFirstName(String firstName) {this.firstName = firstName;}
	protected void setLastName(String lastName) {this.lastName = lastName;}
	
	// creating getters for first and last name
	protected String getFirstName() {return this.firstName;}
	protected String getLastName() {return this.lastName;}

	// creating a method to convert the given values to a string that includes both first and last name
	public String toString() {
		return "Author: " + this.firstName + " " + this.lastName;
	}

	// testing constructors, accessor methods (modifiers), and toString().
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		// reading user's input to test second constructor (option2)
		String firstName = scnr.next();
		String lastName = scnr.next();
		
		// Instantiating each constructor, option1 reads no input values and option 2 reads two input values.
		Author option1 = new Author();
		Author option2 = new Author(firstName, lastName);
		
		// testing the default values of Author() to make sure they're accurate.
		System.out.println(option1.getFirstName());
		System.out.println(option1.getLastName());
		
		// making sure that the inputs read are those assigned to the option2 constructor.
		System.out.println(option2.getFirstName());
		System.out.println(option2.getLastName());
		
		// testing set methods to make sure values can be mutated.
		option2.setFirstName("Gayle");
		option2.setLastName("Myrick");
		
		// recalling the get methods to make sure they kept up with the modification and output the correct values.
		System.out.println(option2.getFirstName());
		System.out.println(option2.getLastName());
		
		// testing toString method to make sure it outputs the full first and last name
		System.out.println(option2.toString());
	}// test class, successful as of 3/13/2023
} // class Author