package com.example.demo;

import java.util.Properties;
import java.time.Duration;
import java.util.Arrays;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class MRapp {
		
	/*public static void SparkStreamingDataTransformProcess(Collection<String> topics, String HOSTPORT,
            String CASE)
throws InterruptedException {
JavaStreamingContext jsc = SparkSessionUtil.getJavaStreamingContext();
Map<String, Object> kafkaParams = KafkaConfiguration.kafkaParams(HOSTPORT);
JavaInputDStream<ConsumerRecord<String, String>> stream = KafkaConfiguration.stream(jsc, topics, kafkaParams);
JavaDStream<String> msgDataStream = KafkaConfiguration.msgDataStream(stream);
msgDataStream.foreachRDD(new VoidFunction<JavaRDD<String>>() {
private static final long serialVersionUID = -8725713781025494501L;
@Override
public void call(JavaRDD<String> rdd) {
SparkSession spark = SparkSessionUtil.getSparkSession();
Dataset<Row> created_new_ds = KafkaConfiguration.sparkStreamingDataset(spark, rdd ,Schema);
long count_of_Dataset = created_new_ds.count();
if (count_of_Dataset > 0) {
try {
System.out
.println("Processing for " + count_of_Dataset + " of records started at " + startDate);

String SEGMENT_COL_NAME = "Segment";
Column SEGMENT_COL = col(SEGMENT_COL_NAME);
Column CALL_UDF = callUDF(SparkFunctions.returnSegment_UDF, col("value"));
created_new_ds = created_new_ds.withColumn(SEGMENT_COL_NAME, CALL_UDF).cache();
//created_new_ds.show(100);
created_new_ds.head(1);
List SegmentedList = Constants.SegmentList;
created_new_ds = SparkFunctions
.CallFileWriter(created_new_ds, SEGMENT_COL, file_path, SegmentedList);

CommonUtils.printTime(startTime, "Session of " + count_of_Dataset + "records completed in ");

} catch (Exception e) {
log.error(e.getMessage(), e);
}

}
}
});

jsc.start();
jsc.awaitTermination();

}

	
*/	
  
	public static void main(String[] args) throws Exception {
      if(args.length == 0){
         System.out.println("Enter topic name");
         //return;
      }
      //Kafka consumer configuration settings
      String topicName = "TestTopic"; //args[0].toString();
      Properties props = new Properties();
      
      props.put("bootstrap.servers", "localhost:9092");
      props.put("group.id", "test");
      props.put("enable.auto.commit", "true");
      props.put("auto.commit.interval.ms", "1000");
      props.put("session.timeout.ms", "30000");
      props.put("key.deserializer", 
         "org.apache.kafka.common.serialization.StringDeserializer");
      props.put("value.deserializer", 
         "org.apache.kafka.common.serialization.StringDeserializer");
      KafkaConsumer<String, String> consumer = new KafkaConsumer
         <String, String>(props);
      
      //Kafka Consumer subscribes list of topics here.
      consumer.subscribe(Arrays.asList(topicName));
      
      //print the topic name
      System.out.println("Subscribed to topic " + topicName);
      int i = 0;
      
      while (true) {
         ConsumerRecords<String, String> records = 
        		 consumer.poll(Duration.ofMillis(100));
         
         
         
        //consumer.poll(100);
         
         for (ConsumerRecord<String, String> record : records)
         
         // print the offset,key and value for the consumer records.
         System.out.printf("offset = %d, key = %s, value = %s\n", 
            record.offset(), record.key(), record.value());
         
         //String fileName = "Kafka.txt";
         
         
      }
      
      
   }
}