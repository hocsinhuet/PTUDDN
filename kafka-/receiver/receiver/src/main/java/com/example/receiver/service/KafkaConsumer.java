package com.example.receiver.service;

import com.example.receiver.model.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group", containerFactory = "productKafkaListenerFactory")
    public void consume(Product product) {
        System.out.println("📥 Received Product:");
        System.out.println("🆔 ID: " + product.getId());
        System.out.println("📦 Name: " + product.getName());
        System.out.println("💰 Price: " + product.getPrice());
    }
}
