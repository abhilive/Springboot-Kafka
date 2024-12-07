package com.abhilive.kafka_microservice_producer.controller;

import com.abhilive.kafka_microservice_producer.service.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class ProducerController {

    private ProducerService producerService;
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        producerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic.");
    }
}
