package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.ArticleElement;
import com.example.kingcar_be.DTO.ArticleRequest;
import com.example.kingcar_be.DTO.ArticleResponse;
import com.example.kingcar_be.Entity.Article;
import com.example.kingcar_be.Entity.Course;
import com.example.kingcar_be.Entity.Member;
import com.example.kingcar_be.Repository.ArticleRepository;
import com.example.kingcar_be.Repository.CourseRepository;
import com.example.kingcar_be.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CourseRepository courseRepository;
    private final MemberRepository memberRepository;
    private final S3Service s3Service;
    public Slice<ArticleElement> list(Pageable pageable){
        Slice<ArticleElement> list = articleRepository.findAllByOrderByArticleIdDesc(pageable);
        return list;
    }


    public ArticleResponse register(Long memberId, MultipartFile image, ArticleRequest request) throws IOException {
        //1. image S3에 업로드
        String imgUrl = s3Service.upload(image);
        //2. Article에 저장
        Course selectedCourse = courseRepository.findById(request.getCourseId()).orElseThrow();
        Member writer = memberRepository.findById(memberId).orElseThrow();
        Article newArticle = new Article(request.getTitle(), request.getPrice(), request.getContents(), imgUrl, selectedCourse, writer);
        articleRepository.save(newArticle);
        return new ArticleResponse(newArticle.getArticleId());

    }

}
