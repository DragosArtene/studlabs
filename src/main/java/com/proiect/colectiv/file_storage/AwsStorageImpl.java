package com.proiect.colectiv.file_storage;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class AwsStorageImpl implements FileStorage {

    private final Logger log = LoggerFactory.getLogger(AwsStorageImpl.class);

    @Value("${cloud.aws.bucket}")
    private String bucket;

    private AmazonS3Client amazonS3Client;

    public AwsStorageImpl(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    @Override
    public String store(MultipartFile file, String key) throws IOException {
        InputStream sourceFileIS = file.getInputStream();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, sourceFileIS, metadata);
        PutObjectResult putObjectResult = amazonS3Client.putObject(putObjectRequest);
        log.debug("uploaded file to aws " + key + ", size: " + putObjectResult.getMetadata().getContentLength());
        IOUtils.closeQuietly(sourceFileIS);

        return key;
    }

    @Override
    public InputStream retrieve(String key) throws Exception {
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucket, key);
        S3Object s3Object = amazonS3Client.getObject(getObjectRequest);
        InputStream inputStream = s3Object.getObjectContent();

        return inputStream;
    }


}
