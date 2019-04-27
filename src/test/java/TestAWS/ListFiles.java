package TestAWS;

import java.util.List;

import org.testng.annotations.Test;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import Credentials.AWSCredentials;

public class ListFiles {

	
	
	@Test(enabled = true)
	public void testListFiles() {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id,
				AWSCredentials.secret_access_key);		
		AmazonS3Client s3Client = new AmazonS3Client(awsCreds);
		String bucketName = "sami1556332861486";

		ObjectListing listing = s3Client.listObjects(bucketName);
		
		List<S3ObjectSummary> objects = listing.getObjectSummaries();
		
		for(S3ObjectSummary o : objects) {
			
			System.out.println("object : "+ o.getKey());
		}

	}

}
