package com.example.kingcar_be.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {
    @ExceptionHandler(RequestException.class)
    public ResponseEntity<?> requestExceptionHandler(RequestException e){
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(e.getErrorCode().name()+" "+e.getMessage());
    }
    @ExceptionHandler(NameDuplicationException.class)
    public ResponseEntity<?> nameDuplicationExceptionHandler(NameDuplicationException e){
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(e.getErrorCode().name()+" "+e.getMessage());
    }

}
