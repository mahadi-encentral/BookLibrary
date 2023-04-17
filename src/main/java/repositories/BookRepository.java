package repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpaModels.JpaBook;

import java.util.List;

public class BookRepository {

    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    public BookRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("book_library");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public long createBook(JpaBook book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        return book.getBookId();

    }

    public List<JpaBook> findAllBooks() {
        return entityManager.createNamedQuery("JpaBook.getAllBooks", JpaBook.class).getResultList();
    }

    public JpaBook findBook(long bookId) {
        return entityManager.find(JpaBook.class, bookId);
    }

    public JpaBook updateBook(JpaBook book) {
        JpaBook bookTemplate = findBook(book.getBookId());

        entityManager.getTransaction().begin();

        bookTemplate.setTitle(book.getTitle());
        bookTemplate.setAuthor(book.getAuthor());
        bookTemplate.setField(book.getField());
        bookTemplate.setPublishedDate(book.getPublishedDate());


        entityManager.getTransaction().commit();

        return bookTemplate;

    }

    public void deleteBook(JpaBook book) {
        entityManager.getTransaction().begin();
        entityManager.remove(book);
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManagerFactory.close();
        entityManager.close();
    }


}
