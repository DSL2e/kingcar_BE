package com.example.kingcar_be.Controller;

import com.example.kingcar_be.DTO.BrandRequest;
import com.example.kingcar_be.DTO.Status;
import com.example.kingcar_be.Service.CarBrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * 자동차 브랜드 등록
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class CarBrandController {
    private final CarBrandService carBrandService;

    @PostMapping("/members/{memberId}/car/brand")
    public ResponseEntity<Status> registerBrand(@PathVariable Long memberId, @RequestBody BrandRequest request){
        Status response = carBrandService.register(memberId, request.getBrand());
        log.info("[차 브랜드 등록 성공] MemberId: {}, 자동차 브랜드: {}", memberId, request.getBrand());
        return ResponseEntity.ok(response);
    }

}
