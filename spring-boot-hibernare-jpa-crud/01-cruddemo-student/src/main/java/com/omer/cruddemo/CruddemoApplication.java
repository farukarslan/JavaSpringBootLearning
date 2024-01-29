package com.omer.cruddemo;

import com.omer.cruddemo.dao.StudentDAO;
import com.omer.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    //This will be executed after the Spring Beans have been loaded
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            //queryForStudents(studentDAO);
            //queryForStudentsByLastName(studentDAO);
            //updateStudent(studentDAO);
            //updateMany(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {

        System.out.println("Deleting all students ...");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {

        int studentId = 4;
        System.out.println("Deleting student id: " + studentId);

        studentDAO.delete(studentId);
    }

    private void updateMany(StudentDAO studentDAO) {

        int numRowsUpdared = studentDAO.updateAll();
        System.out.println("Number of updated rows: " + numRowsUpdared);
    }

    private void updateStudent(StudentDAO studentDAO) {

        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student student = studentDAO.findById(studentId);

        System.out.println("Updating student ...");
        student.setFirstName("Walter");

        studentDAO.update(student);
        System.out.println("Updated student: " + student);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        List<Student> students = studentDAO.findByLastName("white");

        for (Student tempStudent : students) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        List<Student> students = studentDAO.findAll();

        for (Student tempStudent : students) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Rick", "Sanchez", "r.sanchez@gmail.com");

        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        int id = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + id);

        System.out.println("Retrieving student with id: " + id);
        Student student = studentDAO.findById(id);

        System.out.println("Found the student: " + student);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        System.out.println("Creating 3 new student objects ...");
        Student tempStudent1 = new Student("Walter", "White", "w.white@gmail.com");
        Student tempStudent2 = new Student("Harold", "Finch", "h.finch@gmail.com");
        Student tempStudent3 = new Student("Walter", "Bishop", "w.bishop@gmail.com");

        System.out.println("Saving the students");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Omer Faruk", "Arslan", "omer.faruk.arslan@huawei.com");

        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}