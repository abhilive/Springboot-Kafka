package com.abhilive.kafka_microservice_producer.controller;

import com.abhilive.kafka_microservice_producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody String message) {
        producerService.sendMessage(message);
    }
}
