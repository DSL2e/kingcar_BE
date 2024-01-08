package com.example.kingcar_be.Controller;

import com.example.kingcar_be.DTO.ModelRequest;
import com.example.kingcar_be.DTO.Status;
import com.example.kingcar_be.Service.CarModelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CarModelController {
    private final CarModelService carModelService;

    @ResponseBody
    @PostMapping("/members/{memberId}/car/model")
    public ResponseEntity<Status> registerBrand(@PathVariable(name = "memberId") Long memberId, @RequestBody ModelRequest request){
        Status response = carModelService.register(memberId, request.getModel());
        log.info("[차 모델 등록 성공] MemberId: {}, 자동차 모델: {}", memberId, request.getModel());
        return ResponseEntity.ok(response);
    }

}
