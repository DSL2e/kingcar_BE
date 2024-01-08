package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.MyPageResponse;
import com.example.kingcar_be.Entity.Article;
import com.example.kingcar_be.Entity.Member;
import com.example.kingcar_be.Repository.MyPageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MyPageService {

    private final MyPageRepository myPageRepository;
    public ResponseEntity<List<MyPageResponse>> MypageService(Long memberId) {
        Member member = myPageRepository.findById(memberId).orElseThrow();
        List<Article> articleList = member.getArticles();

        List<MyPageResponse> myPageResponseList = articleList.stream()
                .map(MyPageResponse::new)
                .toList();

        return ResponseEntity.ok(myPageResponseList);

    }
}
