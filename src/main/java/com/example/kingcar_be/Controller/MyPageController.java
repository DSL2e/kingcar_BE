package com.example.kingcar_be.Controller;

import com.example.kingcar_be.DTO.MyPageResponse;
import com.example.kingcar_be.Service.MyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MyPageController {
    private  final MyPageService myPageService;

    @GetMapping("/members/{member-id}/mypage")
    public ResponseEntity<List<MyPageResponse>> getMyPage(@PathVariable(name = "member-id") Long memberId){
        return myPageService.MypageService(memberId);
    }

}
