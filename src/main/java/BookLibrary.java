import models.Book;
import models.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookLibrary {

    public static void main(String[] args) {
        System.out.println("Hello World");

        ArrayList<Book> books = new ArrayList<>(){
            {
                add(new Book("Intro to Java", "Mahadi", "01-01-19999",Field.PROGRAMMING ));
                add(new Book("Intro to Python", "Aliyu", "01-01-19999", Field.PROGRAMMING ));
                add(new Book("African night Magic", "Aliyu", "01-01-19999", Field.NOVEL ));
                add(new Book("Advanced Java", "Mahadi", "01-01-19999", Field.PROGRAMMING ));
            }
        };

        List<Book> programmingBooks = books.stream().filter(
                (Book b) -> b.getField().equals(Field.PROGRAMMING)
        ).collect(Collectors.toList());


        for (Book book: programmingBooks)
              {
            System.out.println(book);
        }
    }
}
