package com.example.KafkaSpringdb.configurer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic javaJsonTopic(){
        return TopicBuilder.name("firstTopic")
                .build();
    }
}
