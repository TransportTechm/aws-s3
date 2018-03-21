package com.amazonaws.techm.nextera;

import java.io.File;
import java.io.IOException;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.techm.nextera.util.AWSUtil;
import com.amazonaws.techm.nextera.util.Util;

public class S3Manager {

	public static void main(String[] args) {
		S3Operations s3Ops = S3Operations.getinstance();

		// 1.  Get profile credentials
		AWSCredentials credentials = AWSUtil.getProfileCredentials();

		// 2. Get S3 client
		AmazonS3 s3Client = AWSUtil.getAmazonS3Client(credentials);


		// 3. Upload Object
		String bucketName = "antarnaad";
		String keyName = "Report-20180119140951.csv";
		String filePath = "./uploads/";
		String uploadFileName = filePath+keyName;

		//s3Ops.uploadObject(s3Client, bucketName, keyName, uploadFileName);
		s3Ops.uploadObjectAndEncrypt(s3Client, bucketName, keyName, uploadFileName);

	}

}
