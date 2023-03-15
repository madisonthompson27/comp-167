package libraryDatabase;

//code description

// imports
import java.util.ArrayList;

public class BookDatabase {

	// declaring variables
	private final ArrayList<Book> books;

	// creating blank constructor
	public BookDatabase() {
		this.books = new ArrayList<>(); // will create a blank list if no books are given as input
	}
	
	// creating a constructor for when information is given
	public BookDatabase(ArrayList<Book> books) {
		this.books = books; // initializing the list with the values given
	}
	
	// method to add a book to the given ArrayList
	public void addBook(Book book) {
		this.books.add(book); 
	}
	
	// method to remove a book from the ArrayList
	public void removeBook(Book book) {
		this.books.remove(book);
	}
	
	
	// search methods
	
	// method to allow the user to search by author
	public ArrayList<Book> search(Author author) {
		
		ArrayList<Book> result = new ArrayList<>();
		
		// for loop checks all books
		for (Book book : books) {
			if (book.author.equals(author)) { //FIXME
				result.add(book);
			} // if statement
		} // for loop
		
		return result; // stores search results for user
	} // author search method
	
	
	// method to search by a range of years
	public ArrayList<Book> search(int startYear, int endYear) {
		
		// creating new and separate list so that results from previous searches aren't included in new search
		ArrayList<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.year >= startYear && book.year <= endYear) { //FIXME
				result.add(book);
			} // if statement 
		} // for loop 
		
		return result; // stores search results for user
	} 
	
	
	// method to search by genre
	public ArrayList<Book> genre(String genre) {
		
		ArrayList <Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.genre.equals(genre)) {
				result.add(book);
			} // if statement
		} // for loop
		
		return result; // stores search results for user
	}
	
	
	// to string method to allow books to be in format that can be read by user
	public String toString() {
		
		// converts to a string that lists each book under the title "BookDatabase"
		return "BookDatabase{ " +
				"Books: " + books.toString() +
				"}";
	}
	
} // class BookDatabase
