package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.RandomChoiceResponse;
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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class RequestService {
    private final RequestRepository requestRepository;
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;
    public Status register(Long fromId, RequestRequest request){
        Article article = articleRepository.findById(request.getArticleId()).orElseThrow();
        Member from = memberRepository.findById(fromId).orElseThrow();
        Member to = memberRepository.findById(article.getWriter().getMemberId()).orElseThrow();

        if(from.equals(to)){
            throw new RequestException(ErrorCode.INVALID_REQUEST, "본인 게시글을 신청할 수 없습니다");
        }

        if(!requestRepository.findByFromToArticle(from.getMemberId(), to.getMemberId(), article.getArticleId()).isEmpty()){
            throw new RequestException(ErrorCode.INVALID_REQUEST, "이미 신청한 게시글입니다.");
        }

        Request newRequest = new Request(from, to, article, false);
        requestRepository.save(newRequest);

        return Status.builder().status("ok").build();
    }

    @Transactional
    public RandomChoiceResponse selectWinner(Long articleId){
        List<Request> challengers = requestRepository.findAllByArticleArticleId(articleId);
        Article article = articleRepository.findById(articleId).orElseThrow();

        if(challengers.isEmpty()){
            throw new RequestException(ErrorCode.INVALID_REQUEST, "신청자가 없습니다.");
        }

        if(article.isConnection()){
            throw new RequestException(ErrorCode.INVALID_REQUEST, "이미 시승자가 선정되었습니다.");
        }

        //랜덤 숫자 생성
        Random random = new Random();
        int selectedIdx = random.nextInt(challengers.size());   //0~challengers.size()-1 까지의 무작위 int
        challengers.get(selectedIdx).registerWinner();  //winner의 request

        article.isConnected();


        Member winner = challengers.get(selectedIdx).getFrom();
        return RandomChoiceResponse.builder()
                .winnerId(winner.getMemberId())
                .winnerNickname(winner.getNickname())
                .build();
    }

}
