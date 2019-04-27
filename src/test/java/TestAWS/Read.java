package TestAWS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.testng.annotations.Test;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;

import Credentials.AWSCredentials;

public class Read {
	
	
	
	@Test(enabled = true)
	public void testReadFile() throws IOException {
		String bucketName = "sami1556332861486";
		String key_name = "UploadtoAWS.txt";
		String file_PAth = "/Users/sami/Desktop/eclipse-workspace2k19/AWSJava/src/test/resources/Files/UploadtoAWS.txt";
		
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id,
				AWSCredentials.secret_access_key);		
		AmazonS3Client s3Client = new AmazonS3Client(awsCreds);
		S3Object object = s3Client.getObject(bucketName, key_name);
		
		InputStream objectData = object.getObjectContent();
		
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(object.getObjectContent()));
			String line;
			while((line = reader.readLine()) != null) {
				
				System.out.println(line);
			}
			
			object.close();
			
		}catch(IOException e) {
			System.out.println("Exception : "+e.getMessage());
		}
		

	}

}
