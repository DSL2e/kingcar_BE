package com.example.kingcar_be.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {
    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String randomNum = UUID.randomUUID().toString();    //파일명에 붙은 난수
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        amazonS3.putObject(bucket+"/upload", randomNum+originalFilename, file.getInputStream(), metadata);
        return amazonS3.getUrl(bucket+"/upload", randomNum+originalFilename).toString();
    }
}
