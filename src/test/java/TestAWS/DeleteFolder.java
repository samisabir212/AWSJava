package TestAWS;

import org.testng.annotations.Test;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import Credentials.AWSCredentials;

public class DeleteFolder {

	
	@Test(enabled = true)
	public void testDeleteFolder() throws AmazonClientException, InterruptedException {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id,
				AWSCredentials.secret_access_key);		
		
		AmazonS3Client s3Client = new AmazonS3Client(awsCreds);
		String bucketName = "sami1556332861486";
		String object_keys = "automation2";
		
		ObjectListing objects = s3Client.listObjects(bucketName,object_keys);
		
		for(S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
			
			
			try {
				s3Client.deleteObject(bucketName, objectSummary.getKey());
			}catch(AmazonServiceException e) {
				
				System.out.println(e.getErrorMessage());
			}
			
		}

	}

	
}
