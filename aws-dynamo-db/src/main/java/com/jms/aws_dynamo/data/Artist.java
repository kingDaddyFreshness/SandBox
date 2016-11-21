package com.jms.aws_dynamo.data;


import java.util.HashMap;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Artists")
public class Artist {

	private Integer id;
	private String name;
	private String extra;

	@DynamoDBHashKey(attributeName = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer Id) {
		this.id = Id;
	}
	
	public <V> void setId(HashMap<String, V> map) {
		this.id = (Integer) map.get("id");
		this.name = (String) map.get("name");
		this.extra = (String) map.get("extra");
	}

	@DynamoDBRangeKey(attributeName = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DynamoDBAttribute(attributeName = "extra")
	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	public void dump() {
		System.out.println("id:" + this.id + " name:" + this.name + " extra:" + this.extra);
	}

}
