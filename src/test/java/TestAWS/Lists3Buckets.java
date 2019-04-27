package TestAWS;

import java.util.List;

import org.testng.annotations.Test;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;

import Credentials.AWSCredentials;

public class Lists3Buckets {
	
	
	@Test(enabled = true)
	public void testListBuckets() {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id,
				AWSCredentials.secret_access_key);		
		AmazonS3Client s3Client = new AmazonS3Client(awsCreds);

		List<Bucket> buckets = s3Client.listBuckets();
		
		for(Bucket b:buckets) {
			
			System.out.println("Bucket name : "+b.getName());
		}

	}

}
