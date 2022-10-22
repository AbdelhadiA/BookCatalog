
public class Book implements Comparable<Book> {

	private int ISBN;
	private String title;
	private String author;
	private String publisher;
	private int year;

	/**
	 * This constructor initalizes the book related information.
	 * 
	 * @param ISBN      : Initializes the ISBN for the book.
	 * @param title     : Initializes the title for the book.
	 * @param author    : Initializes the author of the book.
	 * @param publisher : Initializes the publisher of the book.
	 * @param year      : Initialzies the year of the book.
	 */
	public Book(int ISBN, String title, String author, String publisher, int year) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
	}

	/**
	 * This method gets the ISBN for a given book.
	 * 
	 * @return : Returns the ISBN number for the book in the arrCatalog.
	 */
	public int getISBN() {
		return ISBN;
	}

	/**
	 * This method returns the title of a given book.
	 * 
	 * @return : Returns the title of a book in the arrCatalog.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method gets the author name from a book.
	 * 
	 * @return : This method returns the author's name from a book.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * This method gets the publisher name from a book.
	 * 
	 * @return: Returns a String representing the publishers name.
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * This method gets the year information from a book.
	 * 
	 * @return: Returns a integer representing the year number of a book.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * This method changes the ISBN number from a book to the ISBN number passed as
	 * a parameter.
	 * 
	 * @param ISBN : The parameter, of type int, is the new ISBN that the user will
	 *             change the current value to.
	 */
	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}

	/**
	 * This method changes the author from a book to the String passed as a
	 * parameter.
	 * 
	 * @param author : The current author value will be changed to the String
	 *               paramter passed by the user.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * This method changes the publisher name of the current book to the String
	 * paramter passed.
	 * 
	 * @param publisher: This parameter, of type String, is the new value that the
	 *                   current publisher variable will be changed to.
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * This method changes the year value to the parameter passed by the user.
	 * 
	 * @param year : The parameter, of type int, is the value that the current year
	 *             variable will be changed to.
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * This method returns the book information with each piece of info being on a
	 * different line.
	 * 
	 * @return : Returns the book information.
	 */
	public String toString() {
		return ISBN + "\n" + title + "\n" + author + "\n" + publisher + "\n" + year;
	}

	/**
	 * This method compares the title of the current book to the Object parameter.
	 * If it is true, then the titles are the same. If it is false, then the titles
	 * are different.
	 * 
	 * @param obj: This method takes in a Object.
	 * @return: Returns a true/false value. If true, values are equal. If false,
	 *          values are different.
	 */
	public boolean equals(Object obj) {

		if (obj == this.title) {
			return true;
		}

		else {
			return false;
		}

	}

	/**
	 * This method compares two books according tot he title.
	 * 
	 * @param x: This parameter is the book being compared.
	 * @return: Returns a integer.
	 */
	public int compareTo(Book x) {
		return this.title.compareTo(x.getTitle());

	}

}