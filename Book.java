public class Book{
	
	int bookId;
    String title;
    String author;
    boolean isIssued;
	
	public Book(int bookId, String title, String author, boolean isIssued){
		 this.bookId = bookId;
         this.title = title;
         this.author = author;
         this.isIssued = isIssued;
		
		
	}
	
	public void displayBook(){
		System.out.println("Display bookId : "+ bookId);
		System.out.println("Display title : "+ title);
		System.out.println("Display author : "+ author);
		System.out.println("Display isIssued : "+ isIssued);

		
	}
	
	public void issueBook(int bookId) {
    if (this.bookId == bookId && !isIssued) {
        isIssued = true;
        System.out.println("Book has been issued successfully. " + bookId );
    } else {
        System.out.println("Bookid not avaliable " + bookId);
    }
   }

    public void returnBook(int bookId) {
    if (this.bookId == bookId && isIssued) {
        isIssued = false;
        System.out.println("Book has been issued successfully. " + bookId);
    } else {
        System.out.println("Bookid not avaliable " + bookId);
    }
   }

}
	
	