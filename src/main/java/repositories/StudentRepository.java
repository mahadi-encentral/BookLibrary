package repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpaModels.JpaStudent;

public class StudentRepository {

    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    public StudentRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("book_library");
        this.entityManager = entityManagerFactory.createEntityManager();

    }

    public long createStudent(JpaStudent student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student.getId();

    }

//    public List<JpaStudent> findAllStudents(){
//        return entityManager.find();
//    }

    public JpaStudent findStudent(long studentId) {
        return entityManager.find(JpaStudent.class, studentId);
    }

    public JpaStudent updateStudent(JpaStudent student) {
        JpaStudent studentTemplate = findStudent(student.getId());

        entityManager.getTransaction().begin();

        studentTemplate.setLastName(student.getLastName());
        studentTemplate.setFirstName(student.getFirstName());

        entityManager.getTransaction().commit();

        return studentTemplate;

    }

    public void deleteStudent(JpaStudent student) {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManagerFactory.close();
        entityManager.close();
    }
}
