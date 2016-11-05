package jmh.kafka;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * Hello world!
 *
 */
public class KafkaProducer 
{
    	public static void main(String[] args) {
            long events = 3;
            Random rnd = new Random();
     
            Properties props = new Properties();
            props.put("metadata.broker.list", "localhost:9092");
            props.put("serializer.class", "kafka.serializer.StringEncoder");
            props.put("partitioner.class", "jmh.kafka.SimplePartitioner");
            props.put("request.required.acks", "1");
     
            ProducerConfig config = new ProducerConfig(props);
     
            Producer<String, String> producer = new Producer<String, String>(config);
     
            for (long nEvents = 0; nEvents < events; nEvents++) { 
                   long runtime = new Date().getTime();  
                   String ip = "192.168.2." + rnd.nextInt(255); 
                   String msg = runtime + ",www.example.com," + ip; 
                   KeyedMessage<String, String> data = new KeyedMessage<String, String>("page_visits", ip, msg);
                   producer.send(data);
            }
            producer.close();
        }    
}
