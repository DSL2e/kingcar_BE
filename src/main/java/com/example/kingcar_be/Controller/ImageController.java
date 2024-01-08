package com.example.kingcar_be.Controller;

import com.example.kingcar_be.DTO.BrandResponse;
import com.example.kingcar_be.DTO.ModelResponse;
import com.example.kingcar_be.Entity.BrandImage;
import com.example.kingcar_be.Service.AwsService;
import com.example.kingcar_be.Service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BandCombineOp;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final AwsService awsService;
    private final ImageService imageService;


    @GetMapping("/members/car/model/{brandName}")
    public ResponseEntity<List<ModelResponse>> ModelImages(@PathVariable("brandName") String brandName){
        return imageService.ModelImageAll(brandName);
    }

    @GetMapping("/members/car/brand")
        public ResponseEntity<List<BrandResponse>> BrandImages (){
        return imageService.BrandImageAll();
    }

    //model 이미지 전달
    //@GetMapping("/members/car/model/{brandName}")
    public List<String> getModelImages(@PathVariable("brandName") String brandName){

       return awsService.getModelImagesAll("model/",brandName);
    }

    //brand 이미지 전달
    //@GetMapping("/members/car/brand")
    public List<String> getBrandImages (){
        return awsService.getBrandImageAll("brand/");
    }
}
