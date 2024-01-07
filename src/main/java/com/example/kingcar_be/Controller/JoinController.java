package com.example.kingcar_be.Controller;

import com.example.kingcar_be.DTO.JoinRequest;
import com.example.kingcar_be.DTO.MemberIdResponse;
import com.example.kingcar_be.Service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  //회원가입
@RequiredArgsConstructor
@Slf4j
public class JoinController {
    private final JoinService joinService;
    @PostMapping("/members")
    public ResponseEntity<MemberIdResponse> join(@RequestBody JoinRequest request){
        MemberIdResponse response = joinService.join(request.getNickname());
        log.info("[회원가입 성공] ID: {}, NICKNAME: {}", response.getMemberId(), request.getNickname());
        return ResponseEntity.status(201).body(response);
    }

    /*
    @GetMapping("/members")
    public ResponseEntity

     */
}
