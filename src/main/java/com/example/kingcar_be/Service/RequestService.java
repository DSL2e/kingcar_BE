package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.RequestRequest;
import com.example.kingcar_be.DTO.Status;
import com.example.kingcar_be.Entity.Article;
import com.example.kingcar_be.Entity.Member;
import com.example.kingcar_be.Entity.Request;
import com.example.kingcar_be.Exception.ErrorCode;
import com.example.kingcar_be.Exception.RequestException;
import com.example.kingcar_be.Repository.ArticleRepository;
import com.example.kingcar_be.Repository.MemberRepository;
import com.example.kingcar_be.Repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RequestService {
    private final RequestRepository requestRepository;
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;
    public Status register(Long fromId, RequestRequest request){
        Article article = articleRepository.findById(request.getArticleId()).orElseThrow();
        log.info("find article {}", article.getArticleId());
        Member from = memberRepository.findById(fromId).orElseThrow();
        log.info("find from {}", from.getMemberId());
        Member to = memberRepository.findById(article.getWriter().getMemberId()).orElseThrow();
        log.info("find to {}", to.getMemberId());
        if(from.equals(to)){
            throw new RequestException(ErrorCode.INVALID_REQUEST, "본인 게시글을 신청할 수 없습니다");
        }

        if(!requestRepository.findByFromToArticle(from.getMemberId(), to.getMemberId(), article.getArticleId()).isEmpty()){
            throw new RequestException(ErrorCode.INVALID_REQUEST, "이미 신청한 게시글입니다.");
        }

        Request newRequest = new Request(from, to, article, false);
        requestRepository.save(newRequest);


        //requestRepository.save(new Request(from, to, article, false));
        return Status.builder().status("ok").build();
    }
}
