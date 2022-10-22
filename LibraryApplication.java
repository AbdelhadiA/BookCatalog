import java.util.Scanner;

public class LibraryApplication {

	public static void main(String[] args) {

		int choice = 0;

		int ISBN;
		String publisher;
		String author;
		int year;
		String txtFile = "assg6_catalog.txt";
		boolean changed = false;
		BookCatalog catalog = new BookCatalog();

		catalog.loadData(txtFile);

		Scanner kbd = new Scanner(System.in);

		choice = -1;

		/*
		 * The user is prompted with choices they can choose from and will continue to
		 * be until they enter 9 to exit.
		 */
		while (choice != 9) {

			System.out.println("Select from the choices below");
			System.out.println("------------------------------");
			System.out.println("1. Display all the books in the catalog.");
			System.out.println("2. Search for a book.");
			System.out.println("3. Add a new book.");
			System.out.println("4. Update an existing book.");
			System.out.println("5. Remove a book.");
			System.out.println("6. Display books by a publisher.");
			System.out.println("7. Sort all the books based on title.");
			System.out.println("8. Save data.");
			System.out.println("9. Exit");

			System.out.print("\nChoose: ");

			choice = kbd.nextInt();
			kbd.nextLine();
			System.out.println();

			// If the user enters a choice outside of range, a error message is printed.
			if (choice < 0 || choice > 9) {
				System.out.println("Invalid choice");
			}

			// If the choice == 1, then the catalog is displayed.
			if (choice == 1) {
				catalog.displayCatalog();
				System.out.println("Press ENTER to continue.");
				kbd.nextLine();

			}

			// If the choice == 2, then the user can search for a book by inputting the
			// title.
			else if (choice == 2) {
				System.out.print("Enter a title: ");
				String title = kbd.nextLine();
				System.out.println();
				System.out.println(catalog.searchForBook(title));
				System.out.println("\nPress ENTER to continue.");
				kbd.nextLine();
				changed = true;

			}

			// If the choice == 3, then the user can add a book.
			else if (choice == 3) {
				System.out.println("Enter a ISBN: ");
				ISBN = kbd.nextInt();
				kbd.nextLine();

				System.out.println("Enter a title: ");
				String title = kbd.nextLine();

				System.out.println("Enter a author: ");
				author = kbd.nextLine();

				System.out.println("Enter a publisher: ");
				publisher = kbd.nextLine();

				System.out.println("Enter a year: ");
				year = kbd.nextInt();
				kbd.nextLine();

				System.out.println(catalog.addBook(ISBN, title, author, publisher, year));

				System.out.println("\nPress ENTER to continue.");
				kbd.nextLine();
				changed = true;
			}

			// If the choice == 4, then the user can update a book.
			else if (choice == 4) {
				System.out.print("Enter the title: ");
				String title = kbd.nextLine();

				System.out.println(catalog.updateBook(0, title, "", "", 0));

				System.out.println("\nPress ENTER to continue.");
				kbd.nextLine();
				changed = true;
			}

			// If the choice == 5, then the user can remove a book.
			else if (choice == 5) {
				System.out.print("Enter title of book to remove: ");
				String title = kbd.nextLine();
				System.out.println();
				System.out.println(catalog.removeBook(title));

				System.out.println("\nPress ENTER to continue.");
				kbd.nextLine();
				changed = true;
			}

			// If the choice == 6, then the user can display all the books by a specific
			// publisher.
			else if (choice == 6) {
				System.out.println("Enter publisher whose books you want to display: ");
				publisher = kbd.nextLine();
				System.out.println(catalog.getBooksByPublisher(publisher));

				System.out.println("\nPress ENTER to continue.");
				kbd.nextLine();

			}

			// If the choice == 7, then the books in the catalog are sorted.
			else if (choice == 7) {
				catalog.sortByTitle();
				System.out.println("Press ENTER to continue.");
				kbd.nextLine();
				changed = true;
			}

			// If the choice == 8, then the information in the array list is saved by
			// printing to a text file.
			else if (choice == 8) {
				catalog.Save();

				System.out.println("\nPress ENTER to continue.");
				kbd.nextLine();
			}

			// If choice == 9, program exits.
			// If the catalog has been changed, then the data is automatically saved before
			// exiting.
			else if (choice == 9) {
				if (changed == true) {
					catalog.Save();
				}
				System.exit(0);

			}
		}

		kbd.close();

	}
}
