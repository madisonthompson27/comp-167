package libraryDatabase;

// document description
//Allows the user to view the code running three search methods, then prompts them to use each search method if they choose. Closes with exit message. 

// imports
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

	// used to separate book fields
	private static final String delimiter = ",";
	
	// creating a menu to display for a user to choose which search method to use (adding functionality to required code).
	public static void menu() {
		System.out.println();
		System.out.println("=====================================================");
		System.out.println("User Search Options Menu:");
		System.out.println("=====================================================");
		System.out.println("A) search by author");
		System.out.println("B) search by year");
		System.out.println("C) search by genre");
		System.out.println("Q) quit");
		System.out.println("=====================================================");
		System.out.print("Enter choice: ");
	} // end menu
	
	// creating a function to display the menu, read an input, convert to uppercase, and format the menu properly. 
	@SuppressWarnings("resource")
	public static Character menuChoice() {
		// displaying menu options
		Scanner scnr = new Scanner(System.in);
		menu();
		Character option = scnr.next().charAt(0);
		Character menuOption = Character.toUpperCase(option);
		System.out.println("=====================================================");
		System.out.println();

		// returning menuOption
		return menuOption;
	}
	
	
	// main method to read user inputs and manipulate data given
	public static void main(String[] args) {
		
		// try except block so that errors in the file don't cause the code to break
		try {
			// declaring file readers
			ArrayList<Book> books = new ArrayList<>();
			File file = new File("MP1.csv");
			FileReader fr = new FileReader(file);
			
			// buffered reader to read the content contained in the file
			BufferedReader br = new BufferedReader(fr);
			
			// declaring variables needed to manipulate data in file
			String line;
			String[] columns = null;
			int i = 0;
			
			
			// reading CSV file line-by-line, until there isn't another line
			while ((line = br.readLine()) != null) {
				// splitting by row (commas) and storing in an array
				columns = line.split(delimiter);
				
				// writing an if statement to skip the headers of the csv
				if (i == 0) {
					i = 1; // increasing value to prevent infinite loops
					continue;
				} // if statement
				
				//System.out.println(line); // TODO testing
				
				// creating variables that correspond to the correct data values from columns provided
				String firstName = columns[0];
				String lastName = columns[1];
				String title = columns[2];
				int year = Integer.parseInt(columns[3]);
				String publisher = columns[4];
				String genre = columns[5];
				double rating = Double.parseDouble(columns[6]);
				double price = Double.parseDouble(columns[7]);
				
				// calling Author and Book classes to create objects that correspond to the columns created above
				Author author = new Author(firstName, lastName);
				Book book = new Book(author, title, year, publisher, genre, rating, price);
				
				// adding completed books to the ArrayList
				books.add(book);
				
			} // while loop
			
		// creating book database
		BookDatabase bookDatabase = new BookDatabase(books);
		
		// demonstrating ability of search methods.
		
		// telling the user that the tests being run now are for preset values
		System.out.println("This portion of the code prints books using preset values.");
		System.out.println("The author being used is jk rowling (all lowercase).");
		System.out.println("The range of years being used is 1900-2023.");
		System.out.println("The genre being used is fiction.");
		
		// testing the author method with preset values
		System.out.println();
		System.out.println("Books with author \"jk rowling\":");
		bookDatabase.search(new Author("jk", "rowling"));
		
		// testing year method with preset values
		System.out.println();
		System.out.println("Books published between 1900-2023:");
		bookDatabase.search(1900, 2023);
		
		// testing genre method with "fiction"
		System.out.println();
		System.out.println("Books with genre \"fiction\":");
		bookDatabase.search("fiction");
		
		// closing buffered reader after methods execute
		br.close();
		
		
		// allowing the user to try inputting values
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("Would you like to try inputting search values? Y for yes, N for no.");
		Character choice = scanner.next().charAt(0);
		Character search = Character.toUpperCase(choice);

		
		// if the user wants to test the methods, they'll be present with a menu to choose with method to run.
		if (search == 'Y') {
			Character menuOption = menuChoice();
			
			// as long as the user doesn't press quit, the options will be available. 
			while (menuOption != 'Q') {
				
				// if the user chooses option A, they'll be prompted to 
				if (menuOption == 'A') {
					// demonstrating ability to search with author using user-entered values. 
					System.out.print("Enter author first name: ");
					String userFirstName = scanner.next();
					System.out.print("Enter author last name: ");
					String userLastName = scanner.next();
					
					// searching for author using method created in bookDatabse
					System.out.println("Books with author \"" + userFirstName + " " + userLastName + "\"");
					Author userAuthor = new Author(userFirstName, userLastName);
					bookDatabase.search(userAuthor);
					
					// calling menu and allowing the user to input a new value.
					menuOption = menuChoice();
				} // option A
				
				// allowing the user to search by range of years. 
				if (menuOption == 'B') {
					// demonstrating ability to search with years using user-entered values. 
					// reading inputs
					System.out.print("Enter start year: ");
					int startYear = scanner.nextInt();
					System.out.print("Enter end year: ");
					int endYear = scanner.nextInt();
					
					// outputting data
					System.out.println("Books in range: " + startYear + "-" + endYear);
					bookDatabase.search(startYear, endYear);
					
					// calling menu and allowing the user to input a new value
					menuOption = menuChoice();
				} // option B
				
				// allowing the user to search by genre. 
				if (menuOption == 'C') {
					// demonstrating ability to search with genre using user-entered values. 
					System.out.print("Enter genre: ");
					String userGenre = scanner.next();
					System.out.println("Books with genre: " + userGenre);
					bookDatabase.search(userGenre);
					
					// calling menu and allowing the user to input a new value
					menuOption = menuChoice();
				} // option C
				
				// fail safe to break out of any infinite loops 
				if (menuOption == 'Q') {
					break;
				} // end fail safe
				
				// if the user enters a value that isn't an option, they'll be prompted to try again.
				else {
					System.out.println("Invalid option, please try again.");
					menuOption = menuChoice();
				} // end else 
			} // while loop 
		} // if search == 'Y'
		
		// closing second scanner
		scanner.close();
		
		// catching exceptions
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// exit message for user
		System.out.println("Thank you for using the library database!");
		
	} // main method
	
} // class client
