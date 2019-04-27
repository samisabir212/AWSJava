package TestAWS;

import java.io.File;

import org.testng.annotations.Test;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;

import Credentials.AWSCredentials;

public class DeleteFile {
	
	

	@Test(enabled = true)
	public void testDeleteFile() {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id,
				AWSCredentials.secret_access_key);		
		AmazonS3Client s3Client = new AmazonS3Client(awsCreds);

		String bucketName = "sami1556332861486";
		String key_name = "DeleteMeTest.txt";
		
		try {
			s3Client.deleteObject(bucketName, key_name);
		}catch(AmazonServiceException e) {
			
			System.out.println("Exception : "+e.getMessage());
		}

	}

}
