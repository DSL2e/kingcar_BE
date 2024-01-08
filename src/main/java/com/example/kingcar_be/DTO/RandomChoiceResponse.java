package com.example.kingcar_be.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class RandomChoiceResponse {
    private Long winnerId;
    private String winnerNickname;
}
