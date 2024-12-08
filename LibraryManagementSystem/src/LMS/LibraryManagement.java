
package LMS;

import java.util.Scanner;

class Book {
	String name;
	String author;
	int id;
	Book next; // Points to the next book in the library's linked list
}

class Student {
	String name;
	String email;
	String book;
	String author;
	int id;
	Student next; // Points to the next student in the list of issued books
}

public class LibraryManagement {
	static Book startLib = null; // Head of the linked list of books
	static Student start = null; // Head of the linked list of students

	public static void main(String[] args) {
		startLib = initializeLib(startLib); // Initialize library with books
		greetings(); // Display greeting message
		mainMenu(); // Display main menu
	}

	public static void greetings() {
		System.out.println("\n\n");
		System.out.println("\t\t\t     ****************************************");
		System.out.println("\t\t\t     *                                      *");
		System.out.println("\t\t\t     *                                      *");
		System.out.println("\t\t\t     *     ----------------------------     *");
		System.out.println("\t\t\t     *      WELCOME TO STUDENT LIBRARY      *");
		System.out.println("\t\t\t     *     ----------------------------     *");
		System.out.println("\t\t\t     *                                      *");
		System.out.println("\t\t\t     *                                      *");
		System.out.println("\t\t\t     ****************************************");
		System.out.println("\n\n");
		System.out.println("\t\t\t             Press Enter to continue: ");
		new Scanner(System.in).nextLine(); // Wait for user input
	}

	// Main menu method for handling user choices
	public static void mainMenu() {
		int choice;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\n\n");
			System.out.println("\n\t\t\t*************************************************");
			System.out.println("\n\t\t\t\t      MAIN MENU: ");
			System.out.println("\n\t\t\t\t     1. ISSUE OF BOOKS ");
			System.out.println("\n\t\t\t\t     2. RETURN OF BOOKS ");
			System.out.println("\n\t\t\t\t     3. DISPLAY STUDENT DETAILS ");
			System.out.println("\n\t\t\t\t     4. EXIT\n ");
			System.out.println("\n\t\t\t*************************************************");
			System.out.print("\n\t\t\t\t      Enter your choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				start = bookIssue(start); // Issue a book
				break;
			case 2:
				start = bookReturn(start); // Return a book
				break;
			case 3:
				display(start); // Display student details
				break;
			case 4:
				System.exit(0); // Exit the program
				break;
			default:
				System.out.println("\n\t\t\t\t      ...Invalid Option!...");
				System.out.println("\n\t\t\t\t      Press Enter to try again: ");
				new Scanner(System.in).nextLine(); // Wait for user input to try again
			}
		} while (choice != 4); // Repeat until user chooses to exit
	}

	// Initialize the library with some books
	public static Book initializeLib(Book start) {
		Book ptr, newBook1, newBook2, newBook3, newBook4, newBook5;

		// Create books and link them in the library's linked list
		newBook1 = new Book();
		newBook1.next = null;
		startLib = newBook1;
		newBook1.name = "Harry Potter";
		newBook1.author = "J. K. Rowling";
		newBook1.id = 101;
		ptr = newBook1;

		newBook2 = new Book();
		newBook2.next = null;
		newBook2.name = "Introduction to Algorithm";
		newBook2.author = "Ronald Rivest";
		newBook2.id = 102;
		ptr.next = newBook2;
		ptr = newBook2;

		newBook3 = new Book();
		newBook3.next = null;
		newBook3.name = "JavaScript: The Good Parts";
		newBook3.author = "Douglas Crockford";
		newBook3.id = 103;
		ptr.next = newBook3;
		ptr = newBook3;

		newBook4 = new Book();
		newBook4.next = null;
		newBook4.name = "Thinking in Java";
		newBook4.author = "Bruce Eckel";
		newBook4.id = 104;
		ptr.next = newBook4;
		ptr = newBook4;

		newBook5 = new Book();
		newBook5.next = null;
		newBook5.name = "A Tale Of Two Cities";
		newBook5.author = "Charles Dickens";
		newBook5.id = 105;
		ptr.next = newBook5;

		return startLib; // Return the head of the linked list of books
	}

	// Issue a book to a student
	public static Student bookIssue(Student start) {
		Book ptr;
		Student ptr2, newStudent;
		int id;
		boolean flag = false;
		Scanner sc = new Scanner(System.in);

		if (startLib == null) {
			System.out.println(
					"\n\t\t\t\t No books left in the library to issue!\n\t\t\t\t Sorry for the inconvenience!\n");
		} else {
			System.out.println("\n\t*************** Books Available: ****************\n");
			ptr = startLib; // Traverse the linked list of books
			int i = 1;
			while (ptr != null) {
				System.out.println("\n\t_________________________________________________");
				System.out.println("\n\t Book " + i);
				System.out.println("\n\t Book Title: " + ptr.name);
				System.out.println("\n\t Name of Author: " + ptr.author);
				System.out.println("\n\t Book ID: " + ptr.id);
				System.out.println("\n\t_________________________________________________");
				ptr = ptr.next;
				i++;
			}

			System.out.print("\n\n\t Enter the Book ID: ");
			id = sc.nextInt();
			ptr = startLib;
			while (ptr != null) {
				if (ptr.id == id) {
					flag = true;
					break;
				}
				ptr = ptr.next;
			}

			if (flag) {
				ptr = startLib;
				while (ptr.id != id) {
					ptr = ptr.next; // Find the book by ID
				}

				// Create a new student node for the issued book
				newStudent = new Student();
				System.out.println("\n\t Enter Student Details:\n ");
				System.out.print("\n\t Enter your Name: ");
				sc.nextLine(); // Consume newline left by nextInt()
				newStudent.name = sc.nextLine();
				System.out.print("\n\t Enter your Email: ");
				newStudent.email = sc.nextLine();
				newStudent.book = ptr.name;
				newStudent.author = ptr.author;
				newStudent.id = ptr.id;
				newStudent.next = null;

				System.out.println("\n\t Issue of Book ID " + newStudent.id + " done successfully!\n");

				if (start == null) {
					start = newStudent; // Add to the empty list if it's the first student
				} else {
					ptr2 = start;
					while (ptr2.next != null) {
						ptr2 = ptr2.next; // Traverse to the end of the student list
					}
					ptr2.next = newStudent; // Add new student at the end
				}

				startLib = deleteBook(newStudent.id); // Remove the book from the library list
			} else {
				System.out.println("\n\t\t      ...Invalid Option!...\n");
				System.out.println("\n\t\t      Press Enter to try again: ");
				sc.nextLine(); // Wait for user input to try again
			}
		}
		return start; // Return updated student list
	}

	// Handle book return
	public static Student bookReturn(Student start) {
		Student ptr = start;
		Student prev = null;
		boolean flag = false;
		int identity;
		Scanner sc = new Scanner(System.in);

		System.out.println("\n\n\t*************** Books Submission: ****************\n");
		System.out.print("\n\n\t Enter your Book ID: ");
		identity = sc.nextInt();

		// Traverse the student list to find the student who issued the book
		while (ptr != null) {
			if (ptr.id == identity) {
				flag = true;
				break; // Book found, exit loop
			}
			prev = ptr;
			ptr = ptr.next; // Move to the next student in the list
		}

		if (flag) {
			// Display student's details
			System.out.println("\n\t_________________________________________________");
			System.out.println("\n\t Student Name: " + ptr.name);
			System.out.println("\n\t Student Email: " + ptr.email);
			System.out.println("\n\t Name of Book Issued: " + ptr.book);
			System.out.println("\n\t Book ID: " + ptr.id);
			System.out.println("\n\t_________________________________________________");

			// Remove the student from the list
			if (prev == null) {
				start = ptr.next; // If the student is the first node, update the start pointer
			} else {
				prev.next = ptr.next; // Skip the student node to remove it
			}

			// Add the book back to the library
			addBook(ptr.book, ptr.author, ptr.id);
			System.out.println("\n\t Book returned successfully!");

		} else {
			System.out.println("\n\tSorry, the book doesn't exist! Please recheck the entered ID.");
			System.out.println("\n\t\t\t\t      Press Enter to try again: ");
			sc.nextLine(); // Wait for user input
		}
		return start; // Return updated student list
	}

	// Display all student details
	public static void display(Student start) {
		Student ptr = start;
		while (ptr != null) {
			System.out.println("\n\t************* Details of Students: **************\n");
			System.out.println("\n\t_________________________________________________");
			System.out.println("\n\t\t Student Name: " + ptr.name);
			System.out.println("\n\t\t Student Email: " + ptr.email);
			System.out.println("\n\t\t Name of Book Issued: " + ptr.book);
			System.out.println("\n\t\t Book ID: " + ptr.id);
			System.out.println("\n\t_________________________________________________");
			ptr = ptr.next; // Traverse the linked list of students
		}

		System.out.println("\n\n\t Press Enter to go to the main menu: ");
		new Scanner(System.in).nextLine(); // Wait for user input
	}

	// Delete a book from the library's linked list when it's issued
	public static Book deleteBook(int id) {
		Book ptr = startLib, prev = null;
		while (ptr != null) {
			if (ptr.id == id) {
				if (prev == null) {
					startLib = ptr.next; // If the book is the first node, update the head
				} else {
					prev.next = ptr.next; // Skip the book node to remove it
				}
				break;
			}
			prev = ptr;
			ptr = ptr.next;
		}
		return startLib; // Return updated book list
	}

	// Add a returned book back to the library
	public static void addBook(String bookName, String authorName, int id) {
		Book newBook = new Book();
		newBook.name = bookName;
		newBook.author = authorName;
		newBook.id = id;
		newBook.next = null;

		if (startLib == null) {
			startLib = newBook; // If the library is empty, set the new book as the first node
		} else {
			Book ptr = startLib;
			while (ptr.next != null) {
				ptr = ptr.next; // Traverse to the end of the list
			}
			ptr.next = newBook; // Add the new book at the end
		}
	}
}
