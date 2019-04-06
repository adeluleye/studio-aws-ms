package com.spantom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;

public class StudioLambdaQuery implements RequestHandler<Studio, List<Studio>> {
	
	public List<Studio> handleRequest(Studio studio, Context context) {

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		
		DynamoDBQueryExpression<Studio> qe = null;
		
		Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
		Map<String, String> expressionAttributesNames = new HashMap<>();
		
		
		switch (studio.getQueryString()) {
				
			case "activityLocation":
				expressionAttributeValues.put(":postcode", new AttributeValue().withS(String.valueOf(studio.getPostcode())));
				
				qe = new DynamoDBQueryExpression<Studio>()
						.withIndexName("postcode-index")
						.withKeyConditionExpression("postcode = :postcode")
						.withConsistentRead(false)
						.withExpressionAttributeValues(expressionAttributeValues);
				return mapper.query(Studio.class, qe);
				
				
			case "activityAddress":
				expressionAttributeValues.put(":address", new AttributeValue().withS(String.valueOf(studio.getAddress())));
				
				qe = new DynamoDBQueryExpression<Studio>()
						.withIndexName("address-index")
						.withKeyConditionExpression("address = :address")
						.withConsistentRead(false)
						.withExpressionAttributeValues(expressionAttributeValues);
				return mapper.query(Studio.class, qe);
				
			case "activityName":
				expressionAttributesNames.put("#name","name");
				
				expressionAttributeValues.put(":name",new AttributeValue().withS(String.valueOf(studio.getName())));
				
				qe = new DynamoDBQueryExpression<Studio>()
						.withIndexName("name-index")
						.withKeyConditionExpression("#name = :name")
						.withExpressionAttributeNames(expressionAttributesNames)
						.withConsistentRead(false)
						.withExpressionAttributeValues(expressionAttributeValues);
				return mapper.query(Studio.class, qe);
				
			case "studioId":
				
				expressionAttributeValues.put(":id",new AttributeValue().withN(Long.toString(studio.getId())));
					
				qe = new DynamoDBQueryExpression<Studio>()
						.withKeyConditionExpression("id = :id")
						.withConsistentRead(false)
						.withExpressionAttributeValues(expressionAttributeValues);
				return mapper.query(Studio.class, qe);
				
			default:
				break;
		}
		
		return null;
	
	}

}
