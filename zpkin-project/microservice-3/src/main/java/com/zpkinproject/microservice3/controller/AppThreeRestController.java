package com.zpkinproject.microservice3.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppThreeRestController {

    private Logger log = LoggerFactory.getLogger(AppThreeRestController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/m3")
    public String methodThree() {
        log.info("Inside microservice#3");
        log.info("done with microservice#3 " );
        return "returning from microservice#3";
    }
}
