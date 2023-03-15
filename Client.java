package libraryDatabase;

// document description

// imports
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

	// used to separate book fields
	private static final String delimiter = ",";
	
	
	// main method to read user inputs and manipulate data given
	public static void main(String[] args) {
		
		// try except block so that errors in the file don't cause the code to break
		try {
			// declaring file readers
			ArrayList<Book> books = new ArrayList<>();
			File file = new File("C:/Users/thema/OneDrive/Comp 167/libraryDatabase/src/libraryDatabase/MP1.csv"); // FIXME update path to submit
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
			} // while loop
			
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
		
			
		// creating book database
		BookDatabase bookDatabase = new BookDatabase(books);
		
		// demonstrating ability to search with author
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter author first name: ");
		String userFirstName = scnr.next();
		System.out.print("Enter author last name: ");
		String userLastName = scnr.next();
		
		// searching for author using method created in bookDatabse
		System.out.println("Books with author: " + userFirstName + " " + userLastName);
		ArrayList<Book> booksWithAuthor = bookDatabase.search(new Author(userFirstName, userLastName));
		System.out.println(booksWithAuthor.toString());
		
		
		// demonstrating ability to search with years
		
		// reading inputs
		System.out.print("Enter start year: ");
		int startYear = scnr.nextInt();
		System.out.print("Enter end year: ");
		int endYear = scnr.nextInt();
		
		// outputting data
		System.out.println("Books in range: " + startYear + "-" + endYear);
		ArrayList<Book> booksInRange = bookDatabase.search(startYear, endYear);
		System.out.println(booksInRange.toString());
		
		
		// demonstrating ability to search with genre
		System.out.print("Enter genre: ");
		String userGenre = scnr.next();
		System.out.println("Books with genre: " + userGenre);
		ArrayList<Book> booksWithGenre = bookDatabase.search(userGenre);
		System.out.println(booksWithGenre.toString());
		
		// closing scanner 
		scnr.close();
		
		// testing with preset values
		System.out.println("Books with author");
		ArrayList<Book> booksWithAuthors = bookDatabase.search(new Author("jk", "rowling"));
		System.out.println(booksWithAuthors.toString()); //FIXME test failed
		
		
		// closing buffered reader after methods execute
		br.close();
		
		// catching exceptions
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// exit message for user
		System.out.println("\nThank you for using the library database!");
		
		
	} // main method

} // class client

/*
 * NOTES: 
 * 2 main errors 
 * 1) variables not exporting properly, only one column at a time. 
 * 2) only exporting one book at a time.
 */ 
