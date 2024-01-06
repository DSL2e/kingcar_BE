package com.example.kingcar_be.Controller;

import com.example.kingcar_be.DTO.JoinRequest;
import com.example.kingcar_be.DTO.Status;
import com.example.kingcar_be.Service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  //회원가입
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;
    @PostMapping("/members")
    public ResponseEntity<Status> join(@RequestBody JoinRequest request){
        return ResponseEntity.ok(joinService.join(request.getNickname()));
    }

    /*
    @GetMapping("/members")
    public ResponseEntity

     */
}
