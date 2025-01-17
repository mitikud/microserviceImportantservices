package com.basicmicroservice.timelimitreservice.controller;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/timelimiter")
public class TimeLimiterController {

    Logger logger = LoggerFactory.getLogger(TimeLimiterController.class);

    @GetMapping("/getMessageTL")
    @TimeLimiter(name = "getMessageTL")
    public CompletableFuture<String> getMessage() {
        return CompletableFuture.supplyAsync(this::getResponse);
    }

    private String getResponse() {

        if (Math.random() < 0.4) {       //Expected to fail 40% of the time
            return "Executing Within the time Limit...";
        } else {
            try {
                logger.info("Getting Delayed Execution");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Exception due to Request Timeout.";
    }
}
