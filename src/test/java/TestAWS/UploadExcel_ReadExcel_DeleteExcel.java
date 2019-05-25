package TestAWS;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;

import Credentials.AWSCredentials;
import Lib.Lib;

public class UploadExcel_ReadExcel_DeleteExcel {

	static AmazonS3Client s3Client;
	static BasicAWSCredentials awsCreds;
	
	@BeforeTest()
	public void beforeTest() {
		

		 awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id,
				AWSCredentials.secret_access_key);	
		 s3Client = new AmazonS3Client(awsCreds);

	}
	
	@Test(enabled = false)
	public void testUploadDirectoryToBucket() throws AmazonClientException, InterruptedException {
		
		 awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id,
				AWSCredentials.secret_access_key);		
		//AmazonS3Client s3Client = new AmazonS3Client(awsCreds);

		String bucketName = "sami1556332861486";
		String key_prefix = "TestData";
		String file_PAth = "/Users/sami/Desktop/Automation/sidrissi/CucumberJenkins/Properties";
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
	
	@Test(enabled = true)
	public void download() throws IOException {
		
		String bucketName = "sami1556332861486";
		String key_name = "TestData/TestData.xlsx";
		
		
		awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id,
				AWSCredentials.secret_access_key);		
		s3Client = new AmazonS3Client(awsCreds);
		S3Object object = s3Client.getObject(bucketName, key_name);

		String keyname = object.getKey();
		
		System.out.println(keyname);
		
		String pathToDownloadTo = "/Users/sami/Desktop/Automation/downloadhereFromAWS/TestData.xlsx";
		FileUtils.copyInputStreamToFile(object.getObjectContent(), new File(pathToDownloadTo));

		
	}
	
}
