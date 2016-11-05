package jmh.googlepubsub;

import java.util.UUID;

import com.google.cloud.pubsub.Message;
import com.google.cloud.pubsub.PubSub;
import com.google.cloud.pubsub.PubSubOptions;


public class GooglePublish {
	
	public static void main(String... args) throws Exception {
		// Instantiates a client
		PubSub pubsub = PubSubOptions.defaultInstance().service();
		
		// The name for the topic
		String topicName = "my-topic";
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 5; j++) {
				Message m = Message.of("hi:" + UUID.randomUUID().toString());
			//pubsub.publishAsync(topicName, m);
			String id = pubsub.publish(topicName, m);
			System.out.println("published message to " + topicName + " with id:" + id);
		}

		pubsub.close();
	}

}