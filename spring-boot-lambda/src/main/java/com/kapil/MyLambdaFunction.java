package com.kapil;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.services.s3.model.*;
import software.amazon.awssdk.services.s3.S3Client;

import java.util.logging.Logger;

public class MyLambdaFunction implements RequestHandler<Object, String> {

    private static final Logger logger = Logger.getLogger(MyLambdaFunction.class.getName());

    @Override
    public String handleRequest(Object event, Context context) {
        // Create an S3 client
        S3Client s3 = S3Client.builder().build();
        
        // Specify the bucket name
        String bucketName = "project-kdsbucket-cloudbunner";
        
        // List objects in the specified bucket
        try {
            ListObjectsV2Request listObjects = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .build();

            ListObjectsV2Response listObjectsResponse = s3.listObjectsV2(listObjects);
            listObjectsResponse.contents().forEach(s3Object -> {
                logger.info("Object: " + s3Object.key());
            });

        } catch (Exception e) {
            logger.severe("Error listing objects: " + e.getMessage());
        }

        // Return a success message
        return "Lambda executed successfully!";
    }
}
