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

    //상세페이지 조회
    public ArticleDetail detail(Long articleId){
        /*
        return articleDetailRepository.findById(articleId).map(ArticleDetail::new).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );*/
        Article article = articleDetailRepository.findById(articleId).orElseThrow();
        return new ArticleDetail(article);
    }


    //상세페이지 업데이트
    public ArticleDetail update(Long articleId, boolean TorF){
        Article existingarticle = articleDetailRepository.findById(articleId).orElseThrow();
        existingarticle.setConnection(TorF);
        articleDetailRepository.save(existingarticle);

        return new ArticleDetail(existingarticle);

    }

}
