package com.kshrd._2_chhim_pojim_pp_spring_homework003.exception;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ProblemDetail handleRunTimeException(NotFoundExceptionHandler ex){
        ProblemDetail problemDetail = ProblemDetail.
                forStatusAndDetail(HttpStatus.NOT_FOUND,ex.getMessage());
        problemDetail.setProperty("timestamp",Instant.now());
        problemDetail.setTitle("Resource not Found");
        return problemDetail;
    }
}
