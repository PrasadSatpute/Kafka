package com.kafka.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
