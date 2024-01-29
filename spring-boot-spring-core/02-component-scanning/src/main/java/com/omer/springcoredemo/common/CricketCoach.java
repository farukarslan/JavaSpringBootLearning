package com.omer.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component // Marks the class as a Spring bean and it makes it available for dependency injection
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }
}
