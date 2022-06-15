package com.kafka.api.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.kafka.api.model.Person;

@Configuration
public class KafkaPersonConfig {
//	public static final String BOOTSTRAP_SERVERS = "localhost:9092";
//    public static final Object GROUP_ID = "kafkapersonGroup";
    
    @Bean
	public ProducerFactory<String, Person> producerFactory() {
		
		Map<String, Object> confMap = new HashMap<String, Object>();
		
		confMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		confMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		confMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory(confMap);
	}
	
	@Bean
	public KafkaTemplate<String, Person> kafkaTemplateUser()
	{
		return new KafkaTemplate<String, Person>(producerFactory());
	}
	
	@Bean
	public ConsumerFactory<String, Person> personConsumerFactory()
	{
		
		Map< String, Object> personConfig = new HashMap<String, Object>();
		
		personConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		personConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "myGroup");
		personConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, Person>(personConfig, new StringDeserializer(), new JsonDeserializer<>(Person.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Person> personConcurrentKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Person> factory = new ConcurrentKafkaListenerContainerFactory<String, Person>();
		factory.setConsumerFactory(personConsumerFactory());
		return factory;
	}
}
