package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.MasterNotice;
import com.example.kingcar_be.DTO.NoticeResponse;
import com.example.kingcar_be.DTO.WinnerNotice;
import com.example.kingcar_be.Entity.Article;
import com.example.kingcar_be.Entity.Request;
import com.example.kingcar_be.Repository.ArticleRepository;
import com.example.kingcar_be.Repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoticeService {
    private final ArticleRepository articleRepository;
    private final RequestRepository requestRepository;
    public NoticeResponse getNoticeList(Long memberId){
        List<MasterNotice> masterNoticeList = new ArrayList<>();
        List<WinnerNotice> winnerNoticeList = new ArrayList<>();
        //1. 차주 입장 가져오기
        List<Article> myAcceptedArticles = articleRepository.findAllByWriterMemberIdAndConnectionIs(memberId, true);
        for(Article article : myAcceptedArticles){
            Request selected = requestRepository.findByArticleIdAndConnection(article.getArticleId(), true);
            masterNoticeList.add(article.toMasterNotice(selected.getFrom().getNickname()));
            log.info("[차주 알림]{}님은 {}님과 드라이브합니다.", memberId, selected.getFrom().getMemberId());
        }
        //2. 시승자 입장 가져오기
        List<Request> myAcceptedRequests = requestRepository.findAllByFrom_MemberIdAndConnectionIs(memberId, true);
        for(Request request : myAcceptedRequests){
            winnerNoticeList.add(
                   WinnerNotice.builder()
                           .articleId(request.getArticle().getArticleId())
                           .carBrand(request.getTo().getCarBrand())
                           .carModel(request.getTo().getCarModel())
                           .myNickname(request.getFrom().getNickname())
                           .build()

            );
            log.info("[탑승자 알림]{}님은 {} {}에 당첨되었어요.", memberId, request.getTo().getCarBrand(), request.getTo().getCarModel());
        }

        return new NoticeResponse(masterNoticeList, winnerNoticeList);
    }

}
