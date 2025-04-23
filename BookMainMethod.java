import java.util.Scanner;
public class BookMainMethod{
   public static void main(String args[]){
    
	 Scanner sc = new Scanner(System.in);
	 System.out.println("Enter the How many book you want to insert in library?");
	 int size = sc.nextInt();
	 Book books[]=new Book[size];
	 
	 
	 for(int i=0; i<size; i++){
	 System.out.println("Enter the bookId");
	 int bookId = sc.nextInt();
	 System.out.println("Enter the Title");
	 String title = sc.next();
	 System.out.println("Enter the author");
	 String author = sc.next();
	 System.out.println("Enter the book is Issued");
	 boolean isIssued = sc.nextBoolean();
	 books[i] = new Book(bookId,title,author,isIssued);
	 
	 
	 }
	  for(int i=0; i<size; i++){
		  books[i].displayBook();
	  }
	 System.out.println("Enter the bookId to issue:");
        int bookId = sc.nextInt();
        for (Book book : books) {
            book.issueBook(bookId);
        }
	 
	 System.out.println("Enter the bookId to return:");
        int bookIdreturn= sc.nextInt();
        for (Book book : books) {
            book.returnBook(bookIdreturn);
        }
	 
   }
}