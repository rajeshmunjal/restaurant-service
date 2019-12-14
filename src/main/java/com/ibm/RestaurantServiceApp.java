package com.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class RestaurantServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApp.class, args);
    }
}
