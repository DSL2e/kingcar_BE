package com.example.kingcar_be.Controller;

import com.example.kingcar_be.DTO.ArticleDetail;
import com.example.kingcar_be.Service.ArticleDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ArticleDetailController {
    private final ArticleDetailService articleDetailService;
    @GetMapping("/articles/{article-id}")
    public ArticleDetail getArticleDetail(@PathVariable(name = "article-id") Long articleId) {
        return articleDetailService.detail(articleId);
    }

}
