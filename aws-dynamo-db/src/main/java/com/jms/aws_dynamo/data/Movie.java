package com.jms.aws_dynamo.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="movies")
public class Movie {

    private String title;
    private String extra;
    
    @DynamoDBHashKey
    public String getTitle() {
        return this.title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute(attributeName = "extra")
	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
 
	
}
