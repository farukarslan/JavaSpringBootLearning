package com.omer.springcoredemo.rest;

import com.omer.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired // Tells Spring to inject a dependency
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    String getDailyWorkout() {

        return myCoach.getDailyWorkout();
    }
}
