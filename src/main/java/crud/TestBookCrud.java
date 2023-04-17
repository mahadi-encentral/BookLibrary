package crud;

import jpaModels.JpaBook;
import repositories.BookRepository;

public class TestBookCrud {

    public static void main(String[] args) {
        JpaBook book = new JpaBook();
        book.setTitle("Mahadi");
        book.setAuthor("Abuhuraira");

        JpaBook book2 = new JpaBook();
        book2.setTitle("Dalibi");
        book2.setAuthor("Na biyu");

        BookRepository bookRepository = new BookRepository();

//        Create Book
        long newId = bookRepository.createBook(book);
        long newId2 = bookRepository.createBook(book2);

//        Find Book
        System.out.println("After Creation");
        System.out.println(bookRepository.findBook(newId));
        System.out.println(bookRepository.findBook(newId2));

//        update book
        book.setTitle("Iliyasu Lawal");
        bookRepository.updateBook(book);
        System.out.println("After Update");
        System.out.println(book);

//        Delete Book
        bookRepository.deleteBook(book2);

//        Close repository
        bookRepository.close();

    }
}
