package com.example.kingcar_be.Controller;

import com.example.kingcar_be.Service.AwsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final AwsService awsService;

    //model 이미지 전달
    @GetMapping("/members/car/model/{brandName}")
    public List<String> getBoardImages(@PathVariable("brandName") String brandName){

        return awsService.getModelImagesAll("model/", brandName);
    }

    //brand 이미지 전달
    @GetMapping("/members/car/brand")
    public List<String> getBrandImages (){
        return awsService.getBrandImageAll("brand/");
    }
}
