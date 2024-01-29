package com.omer.cruddemo;

import com.omer.cruddemo.dao.AppDAO;
import com.omer.cruddemo.entity.*;
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

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            //createCourseAndStudents(appDAO);
            //findCourseAndStudents(appDAO);
            //findStudentAndCourses(appDAO);
            //addMoreCoursesForStudent(appDAO);
            //deleteCourse(appDAO);
            deleteStudent(appDAO);
        };
    }

    private void deleteStudent(AppDAO appDAO) {
        int id = 1;
        System.out.println("Deleting student id: " + id);

        appDAO.deleteStudentById(id);

        System.out.println("Done!");
    }

    private void addMoreCoursesForStudent(AppDAO appDAO) {
        int id = 2;
        Student student = appDAO.findStudentAndCoursesByStudentId(id);

        Course course = new Course("Rubik's Cube - How to Speed Cube");
        Course course1 = new Course("Atari 2600 - Game Development");

        student.addCourse(course);
        student.addCourse(course1);

        System.out.println("Updating student: " + student);
        System.out.println("associated courses: " + student.getCourses());

        appDAO.update(student);

        System.out.println("Done!");
    }

    private void findStudentAndCourses(AppDAO appDAO) {
        int id = 2;
        Student student = appDAO.findStudentAndCoursesByStudentId(id);

        System.out.println("Loaded student: " + student);
        System.out.println("Courses: " + student.getCourses());

        System.out.println("Done!");
    }

    private void findCourseAndStudents(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseAndStudentsByCourseId(id);

        System.out.println("Loaded course: " + course);
        System.out.println("Students: " + course.getStudents());

        System.out.println("Done!");
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        Course course = new Course("Pacman - How To Score One Million Points?");

        Student student1 = new Student("John", "Doe", "john@doe.com");
        Student student2 = new Student("Mary", "Poppins", "marry@pop.com");

        course.addStudent(student1);
        course.addStudent(student2);

        System.out.println("Saving the course: " + course);
        System.out.println("associated students: " + course.getStudents());

        appDAO.save(course);

        System.out.println("Done!");
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        System.out.println("Deleting course id: " + id);

        appDAO.deleteCourseById(id); // Will delete course and associated reviews thanks to CascadeType.ALL

        System.out.println("Done!");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseAndReviewsByCourseId(id);

        System.out.println(course);
        System.out.println(course.getReviews());

        System.out.println("Done!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        Course course = new Course("Pacman - How to Score One Million Points");

        course.addReview(new Review("Great course <3"));
        course.addReview(new Review("Loved it!!!"));
        course.addReview(new Review("It's okay"));

        System.out.println("Saving the course");
        System.out.println(course);
        System.out.println(course.getReviews());

        appDAO.save(course); // Will save course and associated reviews thanks to CascadeType.ALL

        System.out.println("Done");
    }

    private void deleteCourse(AppDAO appDAO) {
        int id = 10;
        System.out.println("Deleting course id: " + id);
        appDAO.deleteCourseById(id);

        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;
        System.out.println("Finding course id: " + id);
        Course course = appDAO.findCourseById(id);

        System.out.println("Updating course id: " + id);
        course.setTitle("TEST TITLE");

        appDAO.update(course);

        System.out.println("Done!");
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);
        Instructor instructor = appDAO.findInstructorById(id);

        System.out.println("Updating instructor id: " + id);
        instructor.setLastName("TESTER");

        appDAO.update(instructor);

        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

        System.out.println("instructor: " + instructor);
        System.out.println("the associated courses: " + instructor.getCourses());

        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("instructor: " + instructor);

        System.out.println("Finding courses for instructor id: " + id);
        List<Course> courses = appDAO.findCoursesByInstructorId(id);

        instructor.setCourses(courses);
        System.out.println("the associated courses: " + instructor.getCourses());

        System.out.println("Done");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);

        // Only loads the instructor. Does not load courses since they are lazy loaded.
        // If you want to load the courses too. Change fetch type to FetchType.EAGER from entity class.
        Instructor instructor = appDAO.findInstructorById(id);

        System.out.println("instructor: " + instructor);
        System.out.println("the associated courses: " + instructor.getCourses());

        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("John", "Reese", "john.reese@poi.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail("github.com/farukarslan", "Guns");
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        Course tempCourse2 = new Course("The Pinball Masterclass");

        // add courses to the instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        //
        // NOTE: this will also save the courses
        // beacuse of CascadeType.PERSIST
        //
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id = 4;
        System.out.println("Deleting  instructor detail id: " + id);

        appDAO.deleteInstructorDetailById(id);

        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int id = 3;
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

        System.out.println("instructorDetail: " + instructorDetail);

        System.out.println("the associated instructor: " + instructorDetail.getInstructor());

        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 2;
        System.out.println("Deleting instructor id: " + id);

        appDAO.deleteInstructorById(id);

        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("instructor: " + instructor.toString());
        System.out.println("the associated instructorDetail only: " + instructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {

        //Instructor tempInstructor = new Instructor("Omer", "Arslan", "omer.faruk.arslan@huawei.com");
        //InstructorDetail tempInstructorDetail = new InstructorDetail("github.com/farukarslan", "Coding");

        Instructor tempInstructor = new Instructor("John", "Doe", "john@doe.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail("github.com/farukarslan", "Violin");


        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // This will also save the details object
        // because of CascadeType.ALL
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }
}