package com.basicmicroservice.ratelimiterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RatelimiterserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatelimiterserviceApplication.class, args);
	}

}
