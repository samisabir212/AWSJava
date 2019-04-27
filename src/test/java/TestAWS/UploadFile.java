package TestAWS;

import java.io.File;

import org.testng.annotations.Test;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;

import Credentials.AWSCredentials;

public class UploadFile {
	
	
	@Test(enabled = true)
	public void testUploadFileToBucket() {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id,
				AWSCredentials.secret_access_key);		
		AmazonS3Client s3Client = new AmazonS3Client(awsCreds);

		String bucketName = "sami1556332861486";
		String key_name = "DeleteMeTest.txt";
		String file_PAth = "/Users/sami/Desktop/eclipse-workspace2k19/AWSJava/src/test/resources/Files/DeleteMeTest.txt";
		
		try {
			s3Client.putObject(bucketName, key_name, new File(file_PAth));
		}catch(AmazonServiceException e) {
			
			System.out.println("Exception : "+e.getMessage());
		}

	}

}
