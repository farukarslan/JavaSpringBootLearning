package com.omer.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@SpringBootApplication(
        scanBasePackages = {"com.omer.springcoredemo",
                            "com.omer.util"
        })*/
@SpringBootApplication() //Enables auto configuration, component scanning, additional configuration
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }

}
