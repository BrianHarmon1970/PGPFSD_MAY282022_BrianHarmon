package com.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringBootKafkaApplication {

    @Autowired
    private KafkaProducerConfig producerConfig ;
    @Autowired
    private KafkaConsumerConfig consumerConfig ;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(KafkaTemplate<String, String> kafkaTemplate) throws Exception {
        return (String[] args) -> {
            kafkaTemplate.send("ecommerce", "Starting message");
        };
    }
}
