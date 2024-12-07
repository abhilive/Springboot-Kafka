package com.abhilive.kafka_microservice_producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Value("${kafka.topic.name}")
    private String kafkaTopic;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent: %s", message));
        kafkaTemplate.send(kafkaTopic, message);
    }
}
