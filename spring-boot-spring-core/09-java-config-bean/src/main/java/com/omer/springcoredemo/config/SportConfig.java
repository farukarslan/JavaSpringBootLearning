package com.omer.springcoredemo.config;

import com.omer.springcoredemo.common.SwimCoach;
import com.omer.springcoredemo.common.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic") //Give a custom bean id
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
