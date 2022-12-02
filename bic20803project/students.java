package bic20803project;

//Java Program to Illustrate students Class
//To Do all the Operations related to students:
//add Students,check-in books,check out books,ValidStudent

//Importing required classes
import java.util.Scanner;

//Class
public class students {

	// Creating objects of Scanner and students class
	Scanner input = new Scanner(System.in);
	Student theStudents[] = new Student[50];

	public static int count = 0;

	// Method 1
	// To add books
	public void addStudent(Student serial)
	{
		for (int i = 0; i < count; i++) {

			if (serial.regNum.equalsIgnoreCase(theStudents[i].regNum)) {

				// Print statement
				System.out.println("Student of Registration Number " + serial.regNum + " is Already Registered.");

				return;
			}
		}

		if (count <= 50) 
		{
			theStudents[count] = serial;
			count++;
		}
	}

	// Method 2
	// Displaying all students
	public void showAllStudents()
	{
		// Printing student name and
		// corresponding registered number
		System.out.println("Student Name\t\tMatric Number\t\tRegistration Number");
		for (int i = 0; i < count; i++) 
		{
			System.out.println(theStudents[i].studentName + "\t\t\t" + theStudents[i].matricID + "\t\t\t" + theStudents[i].regNum);
		}
	}

	// Method 3
	// To check the Student
	public int isStudent()
	{
		// Display message only
		System.out.println("Enter Registration Number:");

		String regNum = input.nextLine();

		for (int i = 0; i < count; i++)
		{
			if (theStudents[i].regNum.equalsIgnoreCase(regNum)) 
			{
				return i;
			}
		}

		// Print statements
		System.out.println("Student is not Registered.");
		System.out.println("Get Registered First.");

		return -1;
	}

	// Method 4
	// Borrow the book
	public void checkOutBook(books book)
	{
		int studentIndex = this.isStudent();

		if (studentIndex != -1)
		{
			System.out.println("Checking Out");

			book.showAllBooks();
			book b = book.checkOutBook();

			System.out.println("Checking Out");
			
			if (b != null)
			{
				if (theStudents[studentIndex].booksCount <= 3)
				{
					//System.out.println("adding book");
					theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount] = b;
					theStudents[studentIndex].booksCount++;

					return;
				}
				else
				{
					System.out.println("Student CANNOT Borrow more than 3 Books.");
					return;
				}
			}
			System.out.println("Book is not Available.");
		}
	}

	// Method 5
	// Return the book
	public void checkInBook(books book)
	{
		int studentIndex = this.isStudent();
		if (studentIndex != -1) {

			// Printing credentials corresponding to student
			System.out.println("Serial.No\t\t\tBook Name\t\t\tAuthor Name");

			Student serial = theStudents[studentIndex];

			for (int i = 0; i < serial.booksCount; i++)
			{
				System.out.println(serial.borrowedBooks[i].serialNo + "\t\t\t" + serial.borrowedBooks[i].bookName + "\t\t\t\t" + serial.borrowedBooks[i].authorName);
			}

			// Display message only
			System.out.println("Enter Serial Number of Book to be Checked In: ");

			long serialNo = input.nextLong();

			for (int i = 0; i < serial.booksCount; i++)
			{
				if (serialNo == serial.borrowedBooks[i].serialNo)
				{
					book.checkInBook(serial.borrowedBooks[i]);
					serial.borrowedBooks[i] = null;

					return;
				}
			}

			System.out.println("Book of Serial No " + serialNo + "not Found");
		}
	}
}
