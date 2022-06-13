package com.kafka.TopicsCreate;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducer1Application {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducer1Application.class, args);
	}

	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("topic2").partitions(10).replicas(1).build();
	}
}
