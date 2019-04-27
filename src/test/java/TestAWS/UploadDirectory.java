package TestAWS;

import java.io.File;

import org.testng.annotations.Test;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;

import Credentials.AWSCredentials;

public class UploadDirectory {
	
	
	
	@Test(enabled = true)
	public void testUploadDirectoryToBucket() throws AmazonClientException, InterruptedException {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id,
				AWSCredentials.secret_access_key);		
		//AmazonS3Client s3Client = new AmazonS3Client(awsCreds);

		String bucketName = "sami1556332861486";
		String key_prefix = "automation2";
		String file_PAth = "/Users/sami/Desktop/Automation/TransferMe2";
		boolean recursive = false;
		TransferManager transfer = new TransferManager(awsCreds);
		
		MultipleFileUpload xfer = transfer.uploadDirectory(bucketName, key_prefix, new File(file_PAth),recursive);
		
		try {
			
			xfer.waitForCompletion();
			
		}catch(AmazonServiceException e) {
			
			System.out.println(e);
			
		}catch(AmazonClientException e) {
			
			System.out.println(e);
			
		}catch(InterruptedException e) {
			
			System.out.println(e);
			
		}
		
		

	}

}
