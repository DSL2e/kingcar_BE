package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.ArticleElement;
import com.example.kingcar_be.Repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleService {
    private final ArticleRepository articleRepository;
    public Slice<ArticleElement> list(Pageable pageable){
        Slice<ArticleElement> list = articleRepository.findAllByOrderByArticleIdDesc(pageable);
        return list;
    }
}
