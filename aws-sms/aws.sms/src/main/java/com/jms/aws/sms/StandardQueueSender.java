package com.jms.aws.sms;

import java.util.UUID;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

/**
 * Hello world!
 *
 */
public class StandardQueueSender 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
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
 
        AmazonSQSClient sqs = new AmazonSQSClient(credentials);
        sqs.setEndpoint("https://sqs.us-west-2.amazonaws.com/277579334826/jmh-queue");
        //sqs.setEndpoint("https://sqs.us-west-2.amazonaws.com/277579334826/jmh-queue.fifo");
        
//        System.out.println("Listing all queues in your account.\n");
//        for (String queueUrl : sqs.listQueues().getQueueUrls()) {
//            System.out.println("  QueueUrl: " + queueUrl);
//        }
//        System.out.println();

        
        for (int i = 0; i < 10; i++) {
        	String  uuid = UUID.randomUUID().toString();
            SendMessageRequest sendMessageRequest = new SendMessageRequest("https://sqs.us-west-2.amazonaws.com/277579334826/jmh-queue", "This is my message text:" + uuid);
            SendMessageResult sendMessageResult = sqs.sendMessage(sendMessageRequest);
            String messageId = sendMessageResult.getMessageId();
            System.out.println("SendMessage succeed with messageId " + messageId + "\n");
        }
        
        
//        System.out.println("Sending a message to MyFifoQueue.fifo.\n");
//        SendMessageRequest sendMessageRequest = new SendMessageRequest("https://sqs.us-west-2.amazonaws.com/277579334826/jmh-queue", "This is my message text.");
//        // You must provide a non-empty MessageGroupId when sending messages to a FIFO queue
//        //sendMessageRequest.setMessageGroupId("messageGroup1");
//        // Uncomment the following to provide the MessageDeduplicationId
//        //sendMessageRequest.setMessageDeduplicationId("1");
//        SendMessageResult sendMessageResult = sqs.sendMessage(sendMessageRequest);
//        //String sequenceNumber = sendMessageResult.getSequenceNumber();
//        String messageId = sendMessageResult.getMessageId();
//        System.out.println("SendMessage succeed with messageId " + messageId + "\n");
        
        

//        System.out.println("Sending a message to MyFifoQueue.fifo.\n");
//        SendMessageRequest sendMessageRequest = new SendMessageRequest("https://sqs.us-west-2.amazonaws.com/277579334826/jmh-queue", "This is my message text.");
//        SendMessageResult sendMessageResult = sqs.sendMessage(sendMessageRequest);
//        String sequenceNumber = sendMessageResult.getSequenceNumber();
//        String messageId = sendMessageResult.getMessageId();
//        System.out.println("SendMessage succeed with messageId " + messageId + ", sequence number " + sequenceNumber + "\n");
    }
}
