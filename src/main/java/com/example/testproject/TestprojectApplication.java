package com.example.testproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.example.testproject.microservice")
public class TestprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestprojectApplication.class, args);
    }

}
