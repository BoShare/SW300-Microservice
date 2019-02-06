package com.sw300.schedulingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SchedulingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulingServiceApplication.class, args);
    }

}

