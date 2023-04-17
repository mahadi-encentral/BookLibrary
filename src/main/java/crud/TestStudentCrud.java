package crud;

import jpaModels.JpaStudent;
import repositories.StudentRepository;

public class TestStudentCrud {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();


        JpaStudent student = new JpaStudent();
        student.setFirstName("Mamman");
        student.setLastName("Abuhuraira");

        JpaStudent student2 = new JpaStudent();
        student2.setFirstName("yakawada");
        student2.setLastName("Na biyu");


//        Create Student
        studentRepository.createStudent(student);
        long newId2 = studentRepository.createStudent(student2);

//      Retrieve Students
        System.out.println("After Creation:::: All Students");
        System.out.println(studentRepository.findAllStudents());

//      Find One
        System.out.println(studentRepository.findStudent(newId2));


//        update student
        student.setFirstName("Iliyasu Lawal");
        System.out.println("After Update");
        System.out.println(studentRepository.updateStudent(student));


//        Delete Student
        studentRepository.deleteStudent(student2);


//        Close repository
        studentRepository.close();


    }
}
