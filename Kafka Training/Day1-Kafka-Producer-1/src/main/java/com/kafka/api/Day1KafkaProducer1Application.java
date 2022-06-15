package com.kafka.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.github.javafaker.Faker;
import com.kafka.api.config.AppConfig;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

@SpringBootApplication
public class Day1KafkaProducer1Application {

	public static void main(String[] args) throws InterruptedException{
		SpringApplication.run(Day1KafkaProducer1Application.class, args);
		
		Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfig.BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<Integer, String> producer = new KafkaProducer<>(props);
        Faker faker = new Faker();
        for (int index = 0; index < 1000; index++) {
            String fact = faker.chuckNorris().fact();
            ProducerRecord<Integer, String> producerRecord = new ProducerRecord<>("topic1", fact);
            Thread.sleep(2000);
            producer.send(producerRecord);
            System.out.println("Sending message" + fact);
        }
        producer.close();
	
	}

}