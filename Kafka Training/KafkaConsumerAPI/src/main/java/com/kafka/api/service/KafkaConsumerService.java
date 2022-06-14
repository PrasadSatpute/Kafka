package com.kafka.api.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.api.model.User;

@Service
public class KafkaConsumerService {
	
	@KafkaListener(topics = "topic1", groupId = "Group_ID")
	public void consume(String message)
	{
		System.out.println("Consumed Message: "+message);
	}
	
	@KafkaListener(topics = "topic1", groupId = "Group_Json", containerFactory = "userConcurrentKafkaListenerContainerFactory")
	public void userConsume(User user)
	{
		System.out.println("Consumed JSON Message: "+user.toString());
	}
	
}
