package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.RequestRequest;
import com.example.kingcar_be.DTO.Status;
import com.example.kingcar_be.Entity.Article;
import com.example.kingcar_be.Entity.Member;
import com.example.kingcar_be.Entity.Request;
import com.example.kingcar_be.Repository.ArticleRepository;
import com.example.kingcar_be.Repository.MemberRepository;
import com.example.kingcar_be.Repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;
    public Status register(Long fromId, RequestRequest request){
        Article article = articleRepository.findById(request.getArticleId()).orElseThrow();
        Member from = memberRepository.findById(fromId).orElseThrow();
        Member to = memberRepository.findById(article.getWriter().getMemberId()).orElseThrow();
        if(from==to){
            throw new RuntimeException("본인 게시글을 신청할 수 없습니다");
        }
        if(!requestRepository.findByFromAndToAndArticle(from, to, article).isEmpty()){
            throw new RuntimeException("이미 신청한 게시글입니다.");
        }
        requestRepository.save(new Request(from, to, article, false));
        return Status.builder().status("ok").build();
    }
}
