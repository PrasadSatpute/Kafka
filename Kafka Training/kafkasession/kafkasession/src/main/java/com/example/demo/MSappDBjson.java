package com.example.demo;

//import util.properties packages
import java.util.Properties;

//import simple producer packages
import org.apache.kafka.clients.producer.Producer;

//import KafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;

//import ProducerRecord packages
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.simple.JSONObject;

//Create java class named “SimpleProducer”
public class MSappDBjson {
 
 public static void main(String[] args) throws Exception{
    
    // Check arguments length value
//    if(args.length == 0){
//       System.out.println("Enter topic name");
//       //return;
//    }
    
    //Assign topicName to string variable
    String topicName = "TestTopic"; //args[0].toString();
    
    // create instance for properties to access producer configs   
    Properties props = new Properties();
    
    //Assign localhost id
    props.put("bootstrap.servers", "localhost:9092");
    
    //Set acknowledgements for producer requests.      
    props.put("acks", "all");
    
    //If the request fails, the producer can automatically retry,
    props.put("retries", 0);
    
    //Specify buffer size in config
    props.put("batch.size", 16384);
    
    //Reduce the no of requests less than 0   
    props.put("linger.ms", 1);
    
    //The buffer.memory controls the total amount of memory available to the producer for buffering.   
    props.put("buffer.memory", 33554432);
    
    props.put("key.serializer", 
       "org.apache.kafka.common.serialization.StringSerializer");
       
    props.put("value.serializer", 
       "org.apache.kafka.common.serialization.StringSerializer");
    
    Producer<String, String> producer = new KafkaProducer
       <String, String>(props);
    
    
    JSONObject s11 = new JSONObject();
	s11.put("Pid", 1);
    s11.put("PName", "PCell");
    s11.put("PPrice", 7000);
    
          
    for(int i = 0; i < 10; i++)
       producer.send(new ProducerRecord<String, String>(topicName, 
          Integer.toString(i), s11 + ""));
             System.out.println("Message sent successfully");
             
             producer.close();
 }
}