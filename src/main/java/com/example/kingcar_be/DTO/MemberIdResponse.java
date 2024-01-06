package com.example.kingcar_be.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class MemberIdResponse {
    private Long memberId;
}
