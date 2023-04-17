package crud;

import jpaModels.JpaStudent;
import repositories.StudentRepository;

public class TestStudentCrud {

    public static void main(String[] args) {
        JpaStudent student = new JpaStudent();
        student.setFirstName("Mahadi");
        student.setLastName("Abuhuraira");

        JpaStudent student2 = new JpaStudent();
        student2.setFirstName("Dalibi");
        student2.setLastName("Na biyu");

        StudentRepository studentRepository = new StudentRepository();

//        Create Student
        long newId = studentRepository.createStudent(student);
        long newId2 = studentRepository.createStudent(student2);

//        Find Student
        System.out.println("After Creation");
        System.out.println(studentRepository.findStudent(newId));
        System.out.println(studentRepository.findStudent(newId2));


//        update student
        student.setFirstName("Iliyasu Lawal");
        studentRepository.updateStudent(student);
        System.out.println("After Update");
        System.out.println(student);


//        Delete Student
        studentRepository.deleteStudent(student2);


//        Close repository
        studentRepository.close();


    }
}
