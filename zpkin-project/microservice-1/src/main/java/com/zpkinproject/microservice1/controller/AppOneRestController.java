package com.zpkinproject.microservice1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppOneRestController {

    private Logger log = LoggerFactory.getLogger(AppOneRestController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/m1")
    public String methodOne() {
        log.info("Inside microservice#1");
        String response = restTemplate.getForObject("http://localhost:8082/m2", String.class);
        log.info("response by microservice#1 " + response);
        return "returning from microservice#1";
    }
}
