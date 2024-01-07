package com.example.kingcar_be.DTO;

import com.example.kingcar_be.Entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleElement {
    private Long articleId; //게시물 Id
    private String title;   //게시물 제목
    private String writerNickname;  //게시물 작성자
    private String image;   //게시물 이미지
    private boolean connection; //차주와 시승자 연결 여부
    private String writerCarBrand;  //차주 자동차 브랜드
    private String writerCarModel;  //차주 자동차 모델
    private int price;  //차주가 설정한 금액

}
