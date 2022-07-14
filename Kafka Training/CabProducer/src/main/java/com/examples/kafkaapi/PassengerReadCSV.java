package com.examples.kafkaapi;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.examples.kafkaapi.schemas.Passenger;
import com.examples.kafkaapi.serde.JsonSerializer;

import java.util.List;
import java.util.Properties;

public class PassengerReadCSV {


    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args)  {

        Properties props = new Properties();
        props.put(ProducerConfig.CLIENT_ID_CONFIG,"my-app-readcsv");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

System.out.println("Producer has been created...Start sending Student Record");
//        logger.info("Producer has been created...Start sending Student Record ");

        KafkaProducer<String, Passenger> producer = new KafkaProducer<String,Passenger>(props);

        ReadPassenger readCSV = new ReadPassenger();
        List passengerList = readCSV.ReadCSVFile(); //It will return the student list
        for (Object passengerObject : passengerList) {
            Passenger passobject = (Passenger) passengerObject;
            producer.send(new ProducerRecord<String, Passenger>("passenger",passobject.getName(),passobject));
        }
        System.out.println("Producer has sent all employee records successfully...");
//        logger.info("Producer has sent all employee records successfully...");
        producer.close();
    }

}
