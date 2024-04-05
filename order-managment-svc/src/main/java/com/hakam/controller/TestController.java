package com.hakam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    private final RestTemplate restTemplate;

    TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello")
    public String hello() {
        LOGGER.info("---------Hello method started---------");
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("https://httpbin.org/post", "Hello, Cloud!", String.class);
        return responseEntity.getBody();
    }

    @GetMapping("/notify")
    public String notify2() {
        LOGGER.info("---------Notification started---------");
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("http://localhost:8057/v1/api/notifications/sendNotification", "Hello, notification!", String.class);
        return responseEntity.getBody();
    }
}

