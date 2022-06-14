package com.kafka.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.api.model.User;

@RestController
@RequestMapping("kafka")
public class UserController {
	
//	@Autowired
//	KafkaTemplate<String, String> kafkaTemplate;
	private static final String TOPIC = "topic1";
	
	
//	@GetMapping("/publish/{message}")
//	public String postMessage(@PathVariable("message") final String message)
//	{
//		kafkaTemplate.send(TOPIC,message);
//		return "Publish Successfully";
//	}
	

	@Autowired
	KafkaTemplate<String, User> kafkaTemplateUser;
	
	@GetMapping("/publish/user/{name}")
	public String postUser(@PathVariable("name") final String name)
	{
		kafkaTemplateUser.send(TOPIC,new User(name,"Technology",500000L));
		return "Publish Successfully";
	}
	
}
