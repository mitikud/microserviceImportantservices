package com.zpkinproject.microservice2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppTwoRestController {

    private Logger log = LoggerFactory.getLogger(AppTwoRestController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/m2")
    public String methodTwo() {
        log.info("Inside microservice#2");
        String response = restTemplate.getForObject("http://localhost:8083/m3", String.class);
        log.info("response by microservice#2 " + response);
        return "returning from microservice#2";
    }
}
