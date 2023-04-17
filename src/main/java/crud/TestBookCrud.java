package crud;

import jpaModels.JpaBook;
import repositories.BookRepository;

public class TestBookCrud {

    public static void main(String[] args) {
        JpaBook book = new JpaBook();
        book.setTitle("labarin Iliya Dan Maikarfi");
        book.setAuthor("Abuhuraira");

        JpaBook book2 = new JpaBook();
        book2.setTitle("Jiki Magayi");
        book2.setAuthor("Na biyu");

        BookRepository bookRepository = new BookRepository();

//        Create Book
        bookRepository.createBook(book);
        long newId2 = bookRepository.createBook(book2);

//        Find Book
        System.out.println("After Creation ::: All Books");
        System.out.println(bookRepository.findAllBooks());

//        Find One
        System.out.println(bookRepository.findBook(newId2));

//        update book
        book.setTitle("Iliyasu Lawal");
        System.out.println("After Update");
        System.out.println(bookRepository.updateBook(book));

//        Delete Book
        bookRepository.deleteBook(book2);

//        Close repository
        bookRepository.close();

    }
}
