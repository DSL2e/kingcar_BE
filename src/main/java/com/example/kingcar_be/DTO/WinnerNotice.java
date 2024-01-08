package com.example.kingcar_be.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class WinnerNotice {
    private Long articleId;
    private String carBrand;
    private String carModel;
    private String myNickname;
}
