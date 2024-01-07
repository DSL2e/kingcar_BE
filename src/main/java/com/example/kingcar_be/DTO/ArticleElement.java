package com.example.kingcar_be.DTO;

import lombok.Getter;

@Getter
public class ArticleElement {
    private Long articleId; //게시물 Id
    private String title;   //게시물 제목
    private String writer;  //게시물 작성자
    private boolean connection; //차주와 시승자 연결 여부
    private String writerCarBrand;  //차주 자동차 브랜드
    private String writerCarModel;  //차주 자동차 모델
    private int price;  //차주가 설정한 금액

}
