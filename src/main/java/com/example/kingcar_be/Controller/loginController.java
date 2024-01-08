package com.example.kingcar_be.Controller;

import com.example.kingcar_be.DTO.MemberIdResponse;
import com.example.kingcar_be.Service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class loginController {
    private final LoginService loginService;


    @GetMapping("/members/{NickName}")
    public ResponseEntity<MemberIdResponse> login(@PathVariable(name = "NickName") String nickname){
        MemberIdResponse response = loginService.login(nickname);

        return ResponseEntity.ok(response);
    }

}
