package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.BrandResponse;
import com.example.kingcar_be.DTO.ModelResponse;
import com.example.kingcar_be.Entity.BrandImage;
import com.example.kingcar_be.Entity.CarImage;
import com.example.kingcar_be.Repository.BrandImageRepository;
import com.example.kingcar_be.Repository.ModelImageRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@SpringBootApplication
@RequiredArgsConstructor
@Getter
public class ImageService {
    private final BrandImageRepository brandImageRepository;
    private final ModelImageRepository modelImageRepository;

    public ResponseEntity<List<BrandResponse>> BrandImageAll () {
        List<BrandImage> brandResponses = brandImageRepository.findAll();
        List<BrandResponse> brandResponses1 = brandResponses.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(brandResponses1);
    }

    public ResponseEntity<List<ModelResponse>> ModelImageAll(String brandName){

        List<CarImage> brandResponses = modelImageRepository.findByBrandName(brandName);
        List<ModelResponse> modelResponses = brandResponses.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(modelResponses);
    }

    private  BrandResponse convertToDto(BrandImage brandImage) {
        BrandResponse brandResponse = new BrandResponse();

        brandResponse.setBrandId(brandImage.getBrandImageId());
        brandResponse.setBrandName(brandImage.getBrandName());
        brandResponse.setBrand(brandImage.getBrandLogo());

        return brandResponse;
    }

    private ModelResponse modelToDto(CarImage carImage){
        ModelResponse modelResponse = new ModelResponse();

        modelResponse.setCarId(carImage.getCarImageId());
        modelResponse.setBrandName(carImage.getBrandName());
        modelResponse.setBrandModel(carImage.getBrandModel());
        modelResponse.setModelImage(carImage.getModelImage());

        return modelResponse;
    }

}
