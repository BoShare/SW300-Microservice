package com.sw300.swdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SwDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwDiscoveryApplication.class, args);
	}

}

