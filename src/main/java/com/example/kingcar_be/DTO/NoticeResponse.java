package com.example.kingcar_be.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NoticeResponse {
    List<MasterNotice> forMaster;
    List<WinnerNotice> forWinner;
}
