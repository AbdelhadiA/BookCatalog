import java.util.*;
import java.io.*;

public class BookCatalog implements BookCatalogInterface {

	ArrayList<Book> arrCatalog = new ArrayList<Book>();

	Scanner inputStream = null;

	/**
	 * This method reads from the text file and stores the information from the text
	 * file into a array list. For each position in the array list, a Book type is
	 * created and the
	 * 
	 * @param fileName : This method takes in a parameter of type String, which
	 *                 represents the filename.
	 */
	public void loadData(String fileName) {
		String txtFile = "assg6_catalog.txt";
		int ISBN;
		String author;
		String publisher;
		String title;
		int year;
		int i = 0;

		try {

			inputStream = new Scanner(new File(txtFile));

			while (inputStream.hasNextLine()) {

				ISBN = inputStream.nextInt();
				inputStream.nextLine();
				title = inputStream.nextLine();
				author = inputStream.nextLine();
				publisher = inputStream.nextLine();
				year = inputStream.nextInt();

				arrCatalog.add(i, new Book(ISBN, title, author, publisher, year));
				i++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file."); 
		}

		finally {
			inputStream.close();
		}

	}

	/**
	 * The displayCatalog method prints out the entire array list with all the
	 * books.
	 */
	public void displayCatalog() {
		int i = 0;
		while (arrCatalog != null && i != arrCatalog.size()) {
			System.out.println(arrCatalog.get(i) + "\n");
			i++;
		}

	}

	/**
	 * The searchForBook method uses a FOR loop to search through the arrCatalog
	 * list and finds the book with a title that is equivalent to the title passed
	 * through as a paramter.
	 * 
	 * @param title: The searchForBook method takes in one parameter, of type
	 *               String. this parameter represents the title of the Book.
	 * @return : If the book title is found, then the method returns book at the
	 *         specific index of the list.
	 */
	public Book searchForBook(String title) {

		boolean found = false;

		for (int i = 0; i < arrCatalog.size(); i++) {
			if (arrCatalog.get(i).getTitle().equals(title)) {

				return arrCatalog.get(i);
			}

		}

		if (found == false) {
			System.out.println("Book not found.");
		}

		return null;

	}

	/**
	 * This method adds a book to the array list. It takes five parameters
	 * representing information for the book.
	 * 
	 * @param ISBN:      An integer is passed to represent the ISBN of the book
	 *                   being added.
	 * @param title:     A String representing the title of the book to be added.
	 * @param author:    A String representing the author of the book to be added.
	 * @param publisher: A String representing the publisher of the book to be
	 *                   added.
	 * @param year:      An integer representing the year of the book to be added.
	 * @return : The return value is a boolean.
	 */
	public boolean addBook(int ISBN, String title, String author, String publisher, int year) {

		boolean val = true;

		for (int i = 0; i < arrCatalog.size(); i++) {
			if (arrCatalog.get(i).getTitle().equals(title)) {
				System.out.println("\nBook already exists.");
				System.out.print("Result: ");
				return false;
			}

		}
		if (val = true) {
			arrCatalog.add(new Book(ISBN, title, author, publisher, year));
			System.out.print("\nResult: ");
			return true;
		}

		return val;

	}

	/**
	 * This method takes five parameters, and uses the title parameter to search the
	 * array list and find an equal title which will allow us to edit the book we
	 * are searching for. Once the book is found, the rest of the information,
	 * excluding the title, will be changed to the parameters passed.
	 * 
	 * @param ISBN:      This parameter updates the ISBN of the current book.
	 * @param title:     This parameter updates the title of the current book.
	 * @param author:    This parameter updates the author of the current book.
	 * @param publisher: This parameter updates the publisher of the current book.
	 * @param year:      This parameter updates the year of the current book.
	 * @return: This method returns true if the book has been updated and false if
	 *          it has not.
	 */
	public boolean updateBook(int ISBN, String title, String author, String publisher, int year) {

		@SuppressWarnings("resource")
		Scanner kbd = new Scanner(System.in);

		int choice = 0;
		boolean value = false;
		boolean found = false;

		for (int count = 0; count < arrCatalog.size(); count++) {
			if (arrCatalog.get(count).getTitle().equals(title)) {
				found = true;
			}
		}

		if (found == false) {
			System.out.println("\nBook doesn't exist.");
			System.out.print("Result: ");
			return found;
		}

		while (choice > -1) {

			System.out.println("Which information would you like to change?\n");
			System.out.println("0. Return to Main Menu.");
			System.out.println("1. ISBN");
			System.out.println("2. Author");
			System.out.println("3. Publisher");
			System.out.println("4. Year");
			System.out.print("Choice: ");
			choice = kbd.nextInt();
			kbd.nextLine();
			System.out.println();

			if (choice > 4 || choice < 0) {
				System.out.println("Invalid choice.");
			}

			else if (choice == 0) {
				System.out.print("Result: ");
				return value;
			}

			else if (choice == 1) {
				System.out.println("Enter the updated ISBN: ");
				ISBN = kbd.nextInt();
				kbd.nextLine();
				for (int i = 0; i < arrCatalog.size(); i++) {
					if (arrCatalog.get(i).getTitle().equals(title)) {
						arrCatalog.get(i).setISBN(ISBN);
						value = true;

					}
				}
			}

			else if (choice == 2) {
				System.out.println("Enter the updated author: ");
				author = kbd.nextLine();
				for (int i = 0; i < arrCatalog.size(); i++) {
					if (arrCatalog.get(i).getTitle().equals(title)) {
						arrCatalog.get(i).setAuthor(author);
						value = true;

					}

				}
			}

			else if (choice == 3) {
				System.out.println("Enter the updated publisher: ");
				publisher = kbd.nextLine();
				for (int i = 0; i < arrCatalog.size(); i++) {
					if (arrCatalog.get(i).getTitle().equals(title)) {
						arrCatalog.get(i).setPublisher(publisher);
						value = true;
					}
				}
			}

			else if (choice == 4) {
				System.out.println("Enter the updated year: ");
				year = kbd.nextInt();
				for (int i = 0; i < arrCatalog.size(); i++) {
					if (arrCatalog.get(i).getTitle().equals(title)) {
						arrCatalog.get(i).setYear(year);
						value = true;
					}
				}
			}
		}

		kbd.close();
		System.out.print("Result: ");
		return false;

	}

	/**
	 * The removeBook method uses a FOR loop to find a book in the arrCatalog list
	 * by comapring the titles. If the title is equal, that book in the list is
	 * removed.
	 * 
	 * @param title : The removeBook method takes in one parameter, of type String,
	 *              which represents the title.
	 * @return: This method returns a boolean value. If the book is removed, it
	 *          returns true. Otherwise, it returns false.
	 */
	public boolean removeBook(String title) {
		boolean val = false;
		for (int i = 0; i < arrCatalog.size(); i++) {
			if (arrCatalog.get(i).getTitle().equals(title)) {
				arrCatalog.remove(i);
				System.out.print("Result: ");
				return true;
			}
		}

		if (val == false) {
			System.out.println("Book was not found.");
			System.out.print("Result: ");
			return false;
		}

		return false;
	}

	/**
	 * The getBooksByPublisher method uses a FOR loop to search through the
	 * arrCatalog list and compare the publisher of each book to the publisher
	 * paramter. If the result is equal, then that book is stored in a new list. The
	 * new list represents all of the books by that specific publisher.
	 * 
	 * @param publisher : The paramter is of type String, and represents the chosen
	 *                  publisher to be searched for.
	 * @return: This method returns an ArrayList of Books. If there are no books in
	 *          the list, it returns an empty list.
	 */
	public ArrayList<Book> getBooksByPublisher(String publisher) {
		ArrayList<Book> newList = new ArrayList<Book>();

		boolean val = false;

		for (int i = 0; i < arrCatalog.size(); i++) {

			if (arrCatalog.get(i).getPublisher().equals(publisher)) {
				newList.add(new Book(arrCatalog.get(i).getISBN(), arrCatalog.get(i).getTitle(),
						arrCatalog.get(i).getAuthor(), publisher, arrCatalog.get(i).getYear()));
				if (newList != null) {
					val = true;
				}
			}
		}

		if (val == false) {
			System.out.println("No books by given publisher.");
		}

		return newList;
	}

	/**
	 * This method sorts all of the books by title.
	 */
	public void sortByTitle() {
		Collections.sort(arrCatalog);
	}

	/**
	 * This method saves the current information in the arrayList by opening the
	 * text file and overwriting the file with the arrCatalog contents.
	 */
	public void Save() {

		String txtFile = "assg6_catalog.txt";

		PrintWriter outputStream = null;
		try {

			outputStream = new PrintWriter(txtFile);

			for (int i = 0; i < arrCatalog.size(); i++) {

				if (i == arrCatalog.size() - 1) {
					outputStream.print(arrCatalog.get(i));
				} else {
					outputStream.println(arrCatalog.get(i) + "\n");
				}

			}

		}

		catch (FileNotFoundException e) {
			System.out.println("No such file.");
		}

		finally {
			outputStream.close();
		}

	}

}
