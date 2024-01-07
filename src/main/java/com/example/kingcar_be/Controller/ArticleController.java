package com.example.kingcar_be.Controller;

import com.example.kingcar_be.DTO.ArticleElement;
import com.example.kingcar_be.Entity.Article;
import com.example.kingcar_be.Service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/articles")
    public ResponseEntity<Slice<ArticleElement>> getList(Pageable pageable){
        Slice<ArticleElement> list = articleService.list(pageable);
        log.info("{} 크기의 리스트 가져오기 성공", list.getSize());
        return ResponseEntity.ok(list);
    }
}
