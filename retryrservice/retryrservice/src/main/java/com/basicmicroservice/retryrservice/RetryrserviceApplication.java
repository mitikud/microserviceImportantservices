package com.basicmicroservice.retryrservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RetryrserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetryrserviceApplication.class, args);
	}

}
