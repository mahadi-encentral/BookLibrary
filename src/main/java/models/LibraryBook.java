package models;


/**
 * Represent a Book In the Library
 *
 */
public class LibraryBook {

    private Book book;
    private int totalCopies;
    private int availableCopies;

    public LibraryBook(Book book, int totalCopies) {
        this.book = book;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public boolean equals(Book book){
        return this.book.equals(book);
    }

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

    public boolean isAvailable(){
        return  availableCopies > 0;
    }

    public void borrow(){
        if(availableCopies > 0)
            availableCopies--;
    }

    public void returnBook(){
        availableCopies++;
    }

    public int getNoOfBorrowedCopies(){
        return totalCopies - availableCopies;
    }

    /**
     * Formats a Library Book into a table row format in thw form
     * Title | field | no of copies available
     * @return A String Formatted
     */
    public String toTableRow(){
        return String.format(
                "%-25s | %-40s | %-15s | %16d |",book.getTitle(), book.getId(), book.getField(), availableCopies
        );
    }
}
