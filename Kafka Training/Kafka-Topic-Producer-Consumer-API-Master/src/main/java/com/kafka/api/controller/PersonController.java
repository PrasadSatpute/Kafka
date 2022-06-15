package com.kafka.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.api.model.Person;
import com.kafka.api.service.PersonService;

@RestController
@RequestMapping("/kafka/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	private static final String TOPIC = "KafkaPerson";
	
	@Autowired
	KafkaTemplate<String, Person> kafkaTemplateUser;
	
	@PostMapping("addperson")
	public Person addPerson(@RequestBody Person person)
	{
		kafkaTemplateUser.send(TOPIC,person);
		return personService.savePerson(person);
	}
	
	@KafkaListener(topics = "KafkaPerson", groupId = "myGroup", containerFactory = "personConcurrentKafkaListenerContainerFactory")
	public void personConsume(Person person)
	{
		System.out.println("Consumed JSON Message: "+person.toString());
	}

}
