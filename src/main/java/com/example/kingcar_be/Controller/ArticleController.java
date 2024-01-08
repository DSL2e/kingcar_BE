package com.example.kingcar_be.Controller;

import com.example.kingcar_be.DTO.ArticleElement;
import com.example.kingcar_be.DTO.ArticleRequest;
import com.example.kingcar_be.DTO.ArticleResponse;
import com.example.kingcar_be.Entity.Article;
import com.example.kingcar_be.Service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    /*
    게시글 저장
     */
    @PostMapping(value = "/articles/{memberId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ArticleResponse> register(@PathVariable Long memberId, @RequestPart(name = "file") MultipartFile image, @RequestPart(name = "request") ArticleRequest request) throws IOException {
        ArticleResponse response = articleService.register(memberId, image, request);
        log.info("ID {} 게시글이 게시되었습니다.", response.getArticleId());
        return ResponseEntity.status(201).body(response);

    }

    /*
    게시판 목록
     */
    @GetMapping("/articles")
    public ResponseEntity<Slice<ArticleElement>> getList(Pageable pageable){
        Slice<ArticleElement> list = articleService.list(pageable);
        log.info("{} 크기의 리스트 가져오기 성공", list.getSize());
        return ResponseEntity.ok(list);
    }
}
