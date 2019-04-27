package TestAWS;

import org.testng.annotations.Test;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class insertDynamoDB {
	
	
	/**
	 * insert into local dynamo DB
	 *
	 */
	
	static AmazonDynamoDBClientBuilder client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
			new AwsClientBuilder.EndpointConfiguration("LocalHost", "us-east-2"));
	

	DynamoDB dynamoDB = new DynamoDB(client);

	
	@Test(enabled = true)
	public void testInsertionToDynamoDB() {
		
		
		
		
	}
	
}
