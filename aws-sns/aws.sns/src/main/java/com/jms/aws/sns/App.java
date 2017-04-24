package com.jms.aws.sns;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sqs.AmazonSQSClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "START" );
        
        AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Can't load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (~/.aws/credentials), and is a in valid format.",
                    e);
        }
 
            	
    	//create a new SNS client and set endpoint
    	AmazonSNSClient snsClient = new AmazonSNSClient(credentials);		                           
    	//snsClient.setRegion(Region.getRegion(Regions.US_EAST_1));

    	//publish to an SNS topic
    	String msg = "My text published to SNS topic with email endpoint";
    	PublishRequest publishRequest = new PublishRequest("arn:aws:sns:us-west-2:277579334826:homeland-security-1", "test john");
    	PublishResult publishResult = snsClient.publish(publishRequest);
    	//print MessageId of message published to SNS topic
    	System.out.println("MessageId - " + publishResult.getMessageId());
    	
    }
}
