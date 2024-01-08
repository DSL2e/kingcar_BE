package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.ArticleDetail;
import com.example.kingcar_be.Entity.Article;
import com.example.kingcar_be.Entity.Member;
import com.example.kingcar_be.Repository.ArticleDetailRepository;
import com.example.kingcar_be.Repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ArticleDetailService {
    private  final ArticleDetailRepository articleDetailRepository;
    private final MemberRepository memberRepository;

    public ArticleDetail detail(Long articleId){
        /*
        return articleDetailRepository.findById(articleId).map(ArticleDetail::new).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );*/

        //article을 일단 가져오기
        Article article = articleDetailRepository.findById(articleId).orElseThrow();
        //writer 가져오기
        return new ArticleDetail(article);
    }
}
