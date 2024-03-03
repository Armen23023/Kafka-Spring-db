package com.example.KafkaSpringdb.consumer;

import com.example.KafkaSpringdb.model.User;
import com.example.KafkaSpringdb.model.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private final UserRepository userRepository;
    public KafkaConsumer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "firstTopic", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeData(User data){

        LOGGER.info(String.format("JSON message received ->%s",data.toString()));

        userRepository.save(data);
        LOGGER.info(String.format("JSON saved in db ->%s",data.toString()));
    }


}
