package com.sw300.bookingoperationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BookingOperationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingOperationServiceApplication.class, args);
    }

}

