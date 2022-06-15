package com.kafka.api.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.api.model.Person;
import com.kafka.api.repository.PersonRepository;
import com.kafka.api.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

}
