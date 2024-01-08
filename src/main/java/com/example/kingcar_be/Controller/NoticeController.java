package com.example.kingcar_be.Controller;

import com.example.kingcar_be.DTO.NoticeResponse;
import com.example.kingcar_be.Service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class NoticeController {
    private final NoticeService noticeService;
    @GetMapping("/requests/{memberId}")
    public ResponseEntity<NoticeResponse> notify(@PathVariable Long memberId){
        NoticeResponse response = noticeService.getNoticeList(memberId);
        log.info("[알림 성공] {}님은 {}개의 알림이 있습니다.", memberId, response.getForMaster().size()+response.getForWinner().size());
        return ResponseEntity.ok(response);
    }
}
