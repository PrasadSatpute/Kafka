package com.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Kafka")
public class UserController {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	private static final String TOPIC = "Kafka_Example";
	
	@GetMapping("/publish/{message}")
	public String post(@PathVariable("message") final String message)
	{
		return "Published Successfully";
	}
	
}
