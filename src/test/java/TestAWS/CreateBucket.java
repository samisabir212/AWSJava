package TestAWS;

import org.testng.annotations.Test;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;

import Credentials.AWSCredentials;

public class CreateBucket {

	@Test(enabled = true)
	public void testCreateBucket() {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id,
				AWSCredentials.secret_access_key);		
		AmazonS3Client s3Client = new AmazonS3Client(awsCreds);

		// BucketUtils.deleteAllBuckets(s3Client);

		String newBucketName = "sami" + System.currentTimeMillis();

		Bucket bucket = s3Client.createBucket(newBucketName);
		System.out.println(bucket.getName());
		System.out.println(bucket.getCreationDate());

	}

}
