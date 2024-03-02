package com.example.KafkaSpringdb.producer;

import com.example.KafkaSpringdb.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, User> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendData(User data){

        LOGGER.info(String.format("The data sent to broker -> %s", data.toString()));

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"firstTopic")
                .build();

        kafkaTemplate.send(message);
    }
}
