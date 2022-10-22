
import java.util.*;

public interface BookCatalogInterface {

	/**
	 * This method loads the data containing all the books from the given file.
	 * 
	 * @param fileName : This parameter represents the file we will be passing down
	 *                 to the method as a String.
	 */
	public void loadData(String fileName);

	/**
	 * This method takes no parameters and displays the books in the catalog.
	 */
	public void displayCatalog();

	/**
	 * This method searches the list for a book.
	 * 
	 * @param title : The title represents the title of the given book that the user
	 *              wants to search for.
	 * @return : If the user finds the book, the Book object is returned. Otherwise,
	 *         it returns null.
	 */
	public Book searchForBook(String title);

	/**
	 * This method is used to add a new book into the catalog.
	 * 
	 * @param ISBN      : Represents the ISBN of the book object being added.
	 * @param title     : Represents the title of the book object being added.
	 * @param author    : Represents the author of the book object being added.
	 * @param publisher : Represents the publisher of the book object being added.
	 * @param year:     Represents the year of the book object being added.
	 * @return : Returns a boolean value. if the book is added, it returns true,
	 *         otherwise it returns false.
	 */
	public boolean addBook(int ISBN, String title, String author, String publisher, int year);

	/**
	 * This method is used to update the information of an existing book.
	 * 
	 * @param ISBN      : The ISBN the user wants to change the current ISBN of the
	 *                  book to.
	 * @param title     : The title remains unchanged and is used to find the book
	 *                  in the catalog.
	 * @param author    : The author the user wants to change the current author of
	 *                  the book to.
	 * @param publisher : The publisher the user wants to change the current
	 *                  publisher of the book to.
	 * @param year      : The year the user wants to change the current year value
	 *                  to.
	 * @return : This method returns a boolean value. If the book is updated, it
	 *         returns true. Otherwise, it returns false.
	 */
	public boolean updateBook(int ISBN, String title, String author, String publisher, int year);

	/**
	 * This method removes a book from the catalog if the title is found.
	 * 
	 * @param title : This parameter is used to search through the list and find the
	 *              book the user wants to delete.
	 * @return : This method returns a booleanj value. If the book is removed, it
	 *         returns true. Otherwise, it returns false.
	 */
	public boolean removeBook(String title);

	/**
	 * This method returns an ArrayList object with all the books by the given
	 * publisher.
	 * 
	 * @param publisher : Represents the publisher the user wants to display all
	 *                  books by.
	 * @return : Returns an Object, which is an ArrayList of all the books by a
	 *         given publisher. If there is no books by the given publisher, the
	 *         return value is an empty ArrayList.
	 */
	public ArrayList<Book> getBooksByPublisher(String publisher);

	/**
	 * This method sorts the books based on title.
	 */
	public void sortByTitle();

	/**
	 * This method writes the book catalog to the file if the data has been changed.
	 */
	public void Save();
}
