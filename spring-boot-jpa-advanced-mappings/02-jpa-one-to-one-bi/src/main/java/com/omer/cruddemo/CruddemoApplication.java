package com.omer.cruddemo;

import com.omer.cruddemo.dao.AppDAO;
import com.omer.cruddemo.entity.Instructor;
import com.omer.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            //createInstructor(appDAO);
            //findInstructor(appDAO);
            //deleteInstructor(appDAO);
            //findInstructorDetail(appDAO);
            deleteInstructorDetail(appDAO);
        };
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
        int id = 1;
        System.out.println("Deleting instructor id: " + id);

        appDAO.deleteInstructorById(id);

        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 2;
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
