package com.spantom;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "studios")
public class Studio {
	
	@DynamoDBHashKey
	private int id;
	
	@DynamoDBIndexHashKey(attributeName="name", globalSecondaryIndexName = "name-index")
	private String name;
	
	@DynamoDBIndexHashKey(attributeName="address", globalSecondaryIndexName = "address-index")
	private String address;
	
	@DynamoDBAttribute
	private String description;
	
	@DynamoDBAttribute
	private String email;
	
	@DynamoDBAttribute
	private String contactNumber;
	
	@DynamoDBIndexHashKey(attributeName = "postcode", globalSecondaryIndexName = "postcode-index")
	private String postcode;
	
	@DynamoDBAttribute
	private String facebookHandle;
	
	@DynamoDBAttribute
	private String twitterHandle;
	
	@DynamoDBAttribute
	private String instagramHandle;
	
	@DynamoDBAttribute
	private String websiteUrl;
	
	@DynamoDBAttribute
	private List<String> activities;
	
	private String queryString;
	

	public Studio() {
		
	}
	
	public Studio(int id, 
			String name, 
			String address, 
			String description,
			String email,
			String contactNumber,
			String postcode,
			String facebookHandle,
			String twitterHandle,
			String instagramHandle,
			String websiteUrl,
			String queryString,
			List<String> activities) {
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.email = email;
		this.contactNumber = contactNumber;
		this.postcode = postcode;
		this.facebookHandle = facebookHandle;
		this.twitterHandle = twitterHandle;
		this.instagramHandle = instagramHandle;
		this.websiteUrl = websiteUrl;
		this.activities = activities;
		this.queryString = queryString;
		
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getFacebookHandle() {
		return facebookHandle;
	}
	
	public void setFacebookHandle(String facebookHandle) {
		this.facebookHandle = facebookHandle;
	}
	
	public String getTwitterHandle() {
		return twitterHandle;
	}
	
	public void setTwitterHandle(String twitterHandle) {
		this.twitterHandle = twitterHandle;
	}
	
	public String getInstagramHandle() {
		return instagramHandle;
	}
	
	public void setInstagramHandle(String instagramHandle) {
		this.instagramHandle = instagramHandle;
	}
	
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	
	public List<String> getActivities() {
		return activities;
	}
	public void setActivities(List<String> activities) {
		this.activities = activities;
	}
	
	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

}

