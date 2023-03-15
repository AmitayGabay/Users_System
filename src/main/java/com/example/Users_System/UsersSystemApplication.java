package com.example.Users_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class UsersSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersSystemApplication.class, args);
    }

}
