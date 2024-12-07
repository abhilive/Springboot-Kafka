package com.abhilive.kafka_microservice_consumer.service;

import com.abhilive.kafka_microservice_consumer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonConsumerService.class);

    @KafkaListener(topics = "kafkaTopicJson", groupId = "my-group")
    public void consume(User user) {
        LOGGER.info(String.format("Json message received: %s", user.toString()));
    }
}
