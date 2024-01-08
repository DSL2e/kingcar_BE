package com.example.kingcar_be.DTO;


import com.example.kingcar_be.Entity.Article;
import com.example.kingcar_be.Entity.Course;
import com.example.kingcar_be.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class ArticleDetail {
    private Long articleId; //게시물 Id
    private String title;   //게시물 제목
    private String nickname;  //게시물 작성자
    private String image;   // 게시물 이미지
    private String contents;     // 게시글 내용
    private boolean connection;     //차주와 시승자 연결 여부
    private Long courseId;          // 코스
    private int price;              //차주가 설정한 금액
    private String writerCarBrand;  //차주 자동차 브랜드
    private String writerCarModel;  //차주 자동차 모델

    public ArticleDetail(Article entity) {
        this.articleId = entity.getArticleId();
        this.title = entity.getTitle();
        this.nickname = entity.getWriter().getNickname();
        this.image = entity.getImage();
        this.contents = entity.getContents();
        this.connection = entity.isConnection();
        this.courseId = entity.getCourse().getCourseId();
        this.price = entity.getPrice();
        this.writerCarBrand=entity.getWriter().getCarBrand();
        this.writerCarModel=entity.getWriter().getCarModel();
    }
}
