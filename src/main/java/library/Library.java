package library;

import models.BaseUser;
import models.Book;
import models.Field;
import models.LibraryBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class Library implements BookSearch {

    private final ArrayList<LibraryBook> shelf  = new ArrayList<>();
    private final ArrayList<BaseUser> users = new ArrayList<>();

    private final WaitingList waitlist = WaitingList.getInstance();
    private final Borrowings borrowings = Borrowings.getInstance();

    private final Logger logger = LogManager.getLogger(Library.class);


    public Library(Map<Book, Integer> newBooks, ArrayList<BaseUser> users){
        for (Map.Entry<Book, Integer> entry: newBooks.entrySet()
             ) {
            shelf.add(new LibraryBook(entry.getKey(), entry.getValue()));
        }
        this.users.addAll(users);
    }

    public List<LibraryBook> searchBooks(Predicate<LibraryBook> query){
        return shelf.stream().filter(query).collect(Collectors.toList());
    }

    @Override
    public List<LibraryBook> searchBooksByField(Field field){
        return searchBooks((lb) -> lb.getBook().getField().equals(field));
    }

    @Override
    public List<LibraryBook> searchBooksByTitle(String title) {
        return searchBooks(
                (lb) -> lb.getBook().getTitle().toLowerCase().contains(title.toLowerCase())
        );
    }

    @Override
    public List<LibraryBook> searchBooksByPublishingDate(String date) {
        return searchBooks(
                (lb) -> lb.getBook().getPublishedDate().equals(date)
        );
    }

    @Override
    public List<LibraryBook> searchBooksByAuthor(String author){
        return searchBooks(
                (lb)-> lb.getBook().getAuthor().toLowerCase().contains(author.toLowerCase())
        );
    }

    public List<LibraryBook> allAvailableBooks(){
        return shelf.stream().filter(LibraryBook::isAvailable).collect(Collectors.toList());
    }

    public void displayBooks(){
        displayBooks(10);
    }

    public void displayBooks(int n){
        System.out.printf("%n|%4s | %-25s | %-40s | %-15s | %16s |%n", "S/N", "Title", "ISBN", "Field", "Available Copies");
        for(int i=0; i<n && i < shelf.size(); i++){
            System.out.printf("|%4d | %s%n", i+1, shelf.get(i).toTableRow());
        }
    }

    public void borrowBook(String userId, String bookId){
        final var userOrNull = users.stream().filter(u -> u.getId().equals(userId)).findFirst();
        final var bookOrNull = shelf.stream().filter(lb -> lb.equals(new Book(bookId))).findFirst();
        if(userOrNull.isEmpty()){
            logger.error("\nError: No User with ID: " + userId);
            return;
        }
        if(bookOrNull.isEmpty()){
            logger.error("\nError: No Book with ID: " + bookId);
            return;
        }

        final BaseUser user = userOrNull.get();
        final LibraryBook lBook = bookOrNull.get();

//        Confirm User does not already has a copy of the book with him
        if(borrowings.getBookBorrowers(bookId).contains(userId))
        {
            logger.error("\nError: User Already borrowed this book");
            return;
        }

        if(lBook.isAvailable()){
//            Borrow the Book To User
            lBook.borrow();
            borrowings.recordBorrowing(userId, bookId);
            String message = String.format(
                    "%s (%s) is borrowed to User: %s (%s)%n",
                    lBook.getBook().getTitle(), bookId, user.getName(), userId);
            logger.info(message);
//
        }else{
//           Add User to the Book Waiting List
            waitlist.addToWaitlist(bookId, user);
            String message = String.format(
                    "%s (%s) is currently not available ::: %s (%s) is now added to it's waiting list%n",
                    lBook.getBook().getTitle(), bookId, user.getName(), userId
            );
            logger.info(message);
        }
    }

    public void returnBook(String userId, String bookId){
        final var userOrNull = users.stream().filter(u -> u.getId().equals(userId)).findFirst();
        final var bookOrNull = shelf.stream().filter(lb -> lb.equals(new Book(bookId))).findFirst();
        if(userOrNull.isEmpty()){
            logger.error("\n\nError: No User with ID: " + userId);
            return;
        }
        if(bookOrNull.isEmpty()){
            logger.error("\n\nError: No Book with ID: " + bookId);
            return;
        }

        final BaseUser user = userOrNull.get();
        final LibraryBook lBook = bookOrNull.get();

        final var bookBoorowers = borrowings.getBookBorrowers(bookId);
        if(!bookBoorowers.contains(userId)){
            logger.error(user.getName() + " Does not borrowed " + lBook.getBook().getTitle());
            return;
        }
        lBook.returnBook();
        borrowings.removeFromBorrowers(userId, bookId);
        String message = String.format(
                "%s (%s) is returned By %s (%s)%n",
                lBook.getBook().getTitle(), bookId, user.getName(), userId
        );
        logger.info(message);

//        Check If there are waiters for this Book and Borrow it to the Next In line
        final var nextWaiter = waitlist.getNextInLine(bookId);
        if(nextWaiter == null) return;

        borrowBook(nextWaiter.getId(), bookId);
    }

    public void viewBookWaitingQue(String bookId){
        System.out.printf("Waiting Que for: (%s)%n", bookId );
        waitlist.printBooksWaitingQue(bookId);
    }

}
