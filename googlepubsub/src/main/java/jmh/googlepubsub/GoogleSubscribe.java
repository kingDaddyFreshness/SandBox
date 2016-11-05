package jmh.googlepubsub;

import java.util.Iterator;

import com.google.cloud.pubsub.PubSub;
import com.google.cloud.pubsub.PubSubOptions;
import com.google.cloud.pubsub.ReceivedMessage;

public class GoogleSubscribe {

	public static void main(String... args) throws Exception {
		// Instantiates a client
		PubSub pubsub = PubSubOptions.defaultInstance().service();
		
		// The name for the subscription
		String subscriptionName = "my-sub";
		
		boolean notDone = true;
		while(notDone) {
			int count = 0;
			Iterator<ReceivedMessage> iter = pubsub.pull(subscriptionName, 5);
			while (iter.hasNext()) {
				count += 1;
				ReceivedMessage m = iter.next();
				String payload = m.payloadAsString();
				m.ack();
				System.out.println("message pulled from " + subscriptionName + " with payload:" + payload);
			}
			if (count == 0) {
				notDone = false;
			}
		}

		pubsub.close();	}

}
