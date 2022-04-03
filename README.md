# Kafka

install kafka

Go to the kafka folder kafka\bin\windows

Open CMD

1-> We have to Start Zookeeper
  Enter Command 
    -> zookeeper-server-start.bat ../../config/zookeeper.properties
  Minimize this window
  
2-> Open New CMD

3-> We have to Start Kafka Server
  Enter Command 
    -> kafka-server-start.bat ../../config/server.properties
  Minimize this window
  
4-> Open New CMD

5-> List all the Topics
  Enter Command 
  -> kafka-topics.bat --list --bootstrap-server <DESKTOP_NAME>:9092

6-> We have to Create Topic
  Enter Command 
    -> kafka-topics.bat --create --topic topic-name --partitions=2 --bootstrap-server <DESKTOP_NAME>:9092
  Describe Topic
    -> kafka-topics.bat --describe --topic topic-name --bootstrap-server <DESKTOP_NAME>:9092

7-> We have to Create Producer
  Enter Command 
    -> kafka-console-producer.bat --topic topic-name --bootstrap-server <DESKTOP_NAME>:9092
  Enter Some Text
  To close this file press ctrl+c
  
8-> We Have to Create Consumer 1
  Enter Command 
  -> kafka-console-consumer.bat --topic topic-name --from-beginning --partition=0 --bootstrap-server <DESKTOP_NAME>:9092
  
9-> We Have to Create Consumer 2
  Enter Command 
  -> kafka-console-consumer.bat --topic topic-name --from-beginning --partition=1 --bootstrap-server <DESKTOP_NAME>:9092
