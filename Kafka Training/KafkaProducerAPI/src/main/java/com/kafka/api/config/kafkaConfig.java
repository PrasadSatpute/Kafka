package com.kafka.api.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.kafka.api.model.User;

@Configuration
public class kafkaConfig {

	@Bean
	public ProducerFactory<String, User> producerFactory() {
		
		Map<String, Object> confMap = new HashMap<String, Object>();
		
		confMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		confMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		confMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory(confMap);
	}
	
	@Bean
	public KafkaTemplate<String, User> kafkaTemplateUser()
	{
		return new KafkaTemplate<String, User>(producerFactory());
	}
	
}
