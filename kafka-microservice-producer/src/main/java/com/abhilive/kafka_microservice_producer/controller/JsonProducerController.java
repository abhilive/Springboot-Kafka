package com.abhilive.kafka_microservice_producer.controller;

import com.abhilive.kafka_microservice_producer.model.User;
import com.abhilive.kafka_microservice_producer.service.JsonProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class JsonProducerController {

    private JsonProducerService jsonProducerService;

    public JsonProducerController(JsonProducerService jsonProducerService) {
        this.jsonProducerService = jsonProducerService;
    }

    @PostMapping("/sendJsonMessage")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        jsonProducerService.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic.");
    }
}
