import library.Library;
import models.*;

import java.util.ArrayList;
import java.util.HashMap;

public class BookLibrary {

    public static void main(String[] args) {

        /*
          Initial Users with 3 students from different Levels
          and Two Staffs
         */
        final ArrayList<BaseUser> initialMembers = new ArrayList<>() {
            {
                add(new Student("Isah", 1));
                add(new Student("Musah", 1));
                add(new Student("Lawwali", 4));
                add(new Staff("Mallam"));
                add(new Staff("Teacher"));
            }
        };

        /*
         * Initial Examples of Books with 2 copies Each
         */
        final HashMap<Book, Integer> initialShelf = new HashMap<>() {
            {
                put(new Book("Intro to Java", "Mahadi", "01-01-19999", Field.PROGRAMMING), 2);
                put(new Book("Intro to Python", "Aliyu", "01-01-19999", Field.PROGRAMMING), 2);
                put(new Book("African night Magic", "Aliyu", "01-01-19999", Field.NOVEL), 2);
                put(new Book("Advanced Java", "Mahadi", "01-01-19999", Field.PROGRAMMING), 2);
            }
        };

//      Create Library Instance
        Library library = new Library(initialShelf, initialMembers);

//      Test Printing Books List
        library.displayBooks();

//      Test Borrowing Books
        Book book = initialShelf.keySet().stream().findFirst().get();
        for (BaseUser user : initialMembers)
            library.borrowBook(user.getId(), book.getId());

        library.viewBookWaitingQue(book.getId());


//      Test Returning Book
        library.returnBook(initialMembers.get(0).getId(), book.getId());
        library.viewBookWaitingQue(book.getId());

//        Testing Again

        /*
         * @// TODO: 16/04/2023
         * Implement A Menu Driven Approach to the application
         */


    }
}
