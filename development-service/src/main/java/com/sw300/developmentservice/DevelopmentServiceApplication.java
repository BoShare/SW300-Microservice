package com.sw300.developmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DevelopmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevelopmentServiceApplication.class, args);
    }

}

