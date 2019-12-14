package com.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class RestaurantServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApp.class, args);
    }
}
