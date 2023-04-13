package models;


/**
 * Represent a Book In the Library
 *
 */
public class LibraryBook {

    private Book book;
    private int totalCopies;
    private int availableCopies;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public LibraryBook(Book book, int totalCopies) {
        this.book = book;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public boolean isAvailable(){
        return  availableCopies > 0;
    }

    public void borrow(BaseUser user){
//        To be implemented
//        Store the User Id
        availableCopies--;
    }

    public int getNoOfBorrowedCopies(){
        return totalCopies - availableCopies;
    }
}
