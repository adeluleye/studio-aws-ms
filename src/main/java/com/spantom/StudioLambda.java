package com.spantom;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;

public class StudioLambda {
	
	
	public static Object handleRequest(Request request, Context context) throws ResourceNotFoundException {
		
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		
		
		Studio studio = null;
		switch (request.getHttpMethod()) {
			case "GET":
				studio = mapper.load(Studio.class, request.getId());
				if (studio == null) {
					throw new ResourceNotFoundException("Resource can not be found" + request.getId());
				}
				
				return studio;
				
			case "POST":
				studio = request.getStudio();
				mapper.save(studio);
				return studio;
				
			default:
				break;
		}
		return null;
	}

}