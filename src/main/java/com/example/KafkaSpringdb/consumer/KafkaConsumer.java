package com.example.KafkaSpringdb.consumer;

import com.example.KafkaSpringdb.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);



    @KafkaListener(topics = "firstTopic", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeData(User data){

        LOGGER.info(String.format("JSON message recived ->%s",data.toString()));

    }


}
