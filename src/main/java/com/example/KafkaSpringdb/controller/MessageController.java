package com.example.KafkaSpringdb.controller;

import com.example.KafkaSpringdb.model.User;
import com.example.KafkaSpringdb.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // http://localhost:8080/api/v1/kafka/publish
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User data){
        kafkaProducer.sendData(data);
        return ResponseEntity.ok("Data sent to  KafkaProducer");
    }
}
