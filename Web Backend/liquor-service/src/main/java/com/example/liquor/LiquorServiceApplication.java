package com.example.liquor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LiquorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiquorServiceApplication.class, args);
    }

}
