package com.jms.aws_dynamo;

import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.jms.aws_dynamo.data.Artist;
import com.jms.aws_dynamo.data.Movie;

public class MyDynamoDB {

	public static void main(String[] args) {

		AmazonDynamoDBClient client = new AmazonDynamoDBClient(new ProfileCredentialsProvider());
		client.setRegion(Region.getRegion(Regions.US_WEST_2));
		
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		
		// retrieve an object using a "normal" (non-composite) id
		Movie m = new Movie();
		m.setTitle("foxy brown");
		Movie m2 = mapper.load(m);
		if (m2.getExtra() != null) {
			System.out.println("title:" + m2.getTitle() + " extra:" + m2.getExtra());
		}
		
		// retrieve an object using a composite key	
		Artist a = new Artist();
		a.setId(5);
		a.setName("Van Gogh");
		Artist a2 = mapper.load(a);
		
		// scan through a bunch of entries in a table and print them out
		ScanRequest scanRequest = new ScanRequest().withTableName("Artists");
		ScanResult result = client.scan(scanRequest);
		for (Map<String, AttributeValue> item : result.getItems()) {
			String o1 = item.get("id").getN();
			String o2 = item.get("name").getS();
			Artist artist = mapper.load(Artist.class, new Integer(o1), o2);
			artist.dump();
		}
	}
}
