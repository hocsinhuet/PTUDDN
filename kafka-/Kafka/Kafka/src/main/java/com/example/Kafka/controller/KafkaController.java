package com.example.Kafka.controller;

import com.example.Kafka.model.UserEvent;
import com.example.Kafka.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producer")
public class KafkaController {

    @Autowired
    private KafkaProducer producerService;

    @PostMapping("/send")
    public String send(@RequestBody UserEvent event) {
        producerService.send(event);
        return "✅ Sent: " + event;
    }
}
