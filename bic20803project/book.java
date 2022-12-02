package bic20803project;

//Java Program to Illustrate book Class that
//takes Input from the books and related information

//Importing required classes
import java.util.Scanner;

//Class
public class book {

 // Class data members
 public long serialNo;
 public String bookName;
 public String authorName;
 public int bookQty;
 public int bookQtyCopy;

 // Creating object of Scanner class to
 // read input from users
 Scanner input = new Scanner(System.in);

 // Method
 // To add book details
 public book()
 {
     // Display message for taking input later
     // taking input via
     // nextInt() and nextLine() standard methods
     System.out.println("Enter Serial No of Book:");
     this.serialNo = input.nextLong();
     input.nextLine();	// this is to avoid to skip the next input 
     
     System.out.println("Enter Book Name:");
     this.bookName = input.nextLine();

     System.out.println("Enter Author Name:");
     this.authorName = input.nextLine();

     System.out.println("Enter Quantity of Books:");
     this.bookQty = input.nextInt();
     this.bookQtyCopy = this.bookQty;
 }
}

//check out = borrow
//check in = return