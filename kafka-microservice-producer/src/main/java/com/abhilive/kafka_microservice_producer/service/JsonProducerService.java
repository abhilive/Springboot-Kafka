package com.abhilive.kafka_microservice_producer.service;

import com.abhilive.kafka_microservice_producer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonProducerService {

    @Value("${kafka.topic.name}")
    private String kafkaTopic;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonProducerService.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonProducerService(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data) {
        Message<User> message = MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, kafkaTopic)
                .build();
        LOGGER.info(String.format("sending user data: %s", data.toString()));
        kafkaTemplate.send(message);
    }
}
