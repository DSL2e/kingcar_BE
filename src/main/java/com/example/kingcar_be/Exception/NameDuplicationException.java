package com.example.kingcar_be.Exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NameDuplicationException extends RuntimeException{
    private ErrorCode errorCode;
    private String message; //어떤 상황에서 예외가 발생했는지
}
