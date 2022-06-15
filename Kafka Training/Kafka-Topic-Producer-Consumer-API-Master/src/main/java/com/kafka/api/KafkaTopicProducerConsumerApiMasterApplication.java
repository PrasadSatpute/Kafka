package com.kafka.api;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class KafkaTopicProducerConsumerApiMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaTopicProducerConsumerApiMasterApplication.class, args);
	}
	
	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("KafkaPerson").build();
	}

}
