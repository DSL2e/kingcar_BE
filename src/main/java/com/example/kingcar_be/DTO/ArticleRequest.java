package com.example.kingcar_be.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleRequest {
    private String title;
    private int price;
    private String contents;
    private Long courseId;
}
