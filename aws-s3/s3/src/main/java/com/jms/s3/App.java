package com.jms.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        
        AmazonS3 s3Client = new AmazonS3Client(new ProfileCredentialsProvider());        
        S3Object object = s3Client.getObject(
                          new GetObjectRequest("jmh-experimental-bucket", "googoo/README.md"));
        InputStream objectData = object.getObjectContent();
        
        BufferedReader reader = new BufferedReader(new 
        		InputStreamReader(objectData));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;

            System.out.println("    " + line);
        }
        System.out.println();
        
        
        objectData.close();
    }
}
