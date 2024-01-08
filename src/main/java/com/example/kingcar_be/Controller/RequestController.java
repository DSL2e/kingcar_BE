package com.example.kingcar_be.Controller;

import com.example.kingcar_be.DTO.RandomChoiceResponse;
import com.example.kingcar_be.DTO.RequestRequest;
import com.example.kingcar_be.DTO.Status;
import com.example.kingcar_be.Service.RequestService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RequestController {
    private final RequestService requestService;

    /**
     * 시승 신청
     */
    @PostMapping("/requests/{memberId}")
    public ResponseEntity<Status> request(@PathVariable Long memberId, @RequestBody RequestRequest request){
        Status status = requestService.register(memberId, request);
        log.info("{}번님이 {}번 게시글에 요청했습니다.", memberId, request.getArticleId());
        return ResponseEntity.status(201).body(status);
    }

    /**
     * 시승자 랜덤 뽑기
     */
    @GetMapping("/requests")
    public ResponseEntity<RandomChoiceResponse> random(@PathParam("articleId") Long articleId){
        RandomChoiceResponse response = requestService.selectWinner(articleId);
        log.info("[랜덤 뽑기 성공] Id:{}, Nickname:{}이 article {}번의 시승자로 당첨되었습니다.", response.getWinnerId(), response.getWinnerNickname(), articleId);
        return ResponseEntity.ok(response);
    }

}
