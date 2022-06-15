package com.kafka.api;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class KafkaConsumerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApiApplication.class, args);
	}
	
//	@Bean
//	public NewTopic createTopic()
//	{
//		System.out.println("New topic 3  created");
//		return TopicBuilder.name("topic3").build();
//	}

}
