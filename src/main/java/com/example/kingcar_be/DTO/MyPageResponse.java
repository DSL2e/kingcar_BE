package com.example.kingcar_be.DTO;

import com.example.kingcar_be.Entity.Article;
import com.example.kingcar_be.Entity.Member;
import com.example.kingcar_be.Entity.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MyPageResponse {
    private Long articleId;         //게시물 Id
    private String title;           //게시물 제목
    private String nickname;        //게시물 작성자
    private String image;           //게시물 이미지
    private String contents;        //게시글 내용
    private boolean connection;     //차주와 시승자 연결 여부
    private Long courseId;          //코스
    private int price;              //차주가 설정한 금액
    private String writerCarBrand;  //차주 자동차 브랜드
    private String writerCarModel;  //차주 자동차 모델
    private String ImageUrl;        //이미지 url
    private int RequestCount;       //신청한 사람 수
    private String ConnectionName;   //당첨된 신청자
    public String SetImageUrl(String brand){
        return switch (brand) {
            case "koenigsegg" -> "https://softeer-kingcar.s3.ap-northeast-2.amazonaws.com/model/koenigsegg_1.png";
            case "hyundai" -> "https://softeer-kingcar.s3.ap-northeast-2.amazonaws.com/model/hyundai_1.png";
            case "lamborghini" -> "https://softeer-kingcar.s3.ap-northeast-2.amazonaws.com/model/lamborghini_1.png";
            case "mclaren" -> "https://softeer-kingcar.s3.ap-northeast-2.amazonaws.com/model/mclaren_1.png";
            case "porsche" -> "https://softeer-kingcar.s3.ap-northeast-2.amazonaws.com/model/porsche_1.png";
            case "bugatti" -> "https://softeer-kingcar.s3.ap-northeast-2.amazonaws.com/model/bugatti_1.png";
            default -> "error";
        };
    }
    public String SetConnectionName(Article entity){
        if(this.connection){
            List<Request> requests = entity.getRequests();
            for(Request request:requests)
                if(request.isConnection()){
                    return request.getFrom().getNickname();
                }
        }
        return "NULL";
    }

    public MyPageResponse(Article entity) {
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
        this.ImageUrl = SetImageUrl(this.writerCarBrand);
        this.RequestCount = entity.getRequests().size();
        this.ConnectionName = SetConnectionName(entity);
        }
}

