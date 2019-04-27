package TestAWS;

import org.testng.annotations.Test;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;

import Credentials.AWSCredentials;

public class DeleteBucket {
	
	@Test(enabled = true)
	public void testDeleteBucket() {
		//apples1556334940312
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id,
				AWSCredentials.secret_access_key);		
		AmazonS3Client s3Client = new AmazonS3Client(awsCreds);
		String deleteBucketName = "apples1556334940312";

		s3Client.deleteBucket(deleteBucketName);

	}

}
