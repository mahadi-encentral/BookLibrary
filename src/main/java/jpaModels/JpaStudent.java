package jpaModels;


import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class JpaStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public JpaStudent() {

    }

    public JpaStudent(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }
    

    @Override
    public String toString() {
        return String.format("ID: %d\tFirstname: %s\t Lastname: %s%n", id, firstName, lastName);
    }
}
