package com.basicmicroservice.bulkheadservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BulkheadserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BulkheadserviceApplication.class, args);
	}

}
