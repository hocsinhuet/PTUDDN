package com.example.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaReceiverApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaReceiverApplication.class, args);
    }
}
