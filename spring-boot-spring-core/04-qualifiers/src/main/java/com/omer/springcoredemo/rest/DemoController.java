package com.omer.springcoredemo.rest;

import com.omer.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired           //Multiple Classes: Specify the bean id: Same name as class, firts character lower-case
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    String getDailyWorkout() {

        return myCoach.getDailyWorkout();
    }
}