package com.kshrd._2_chhim_pojim_pp_spring_homework003.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ProblemDetail handleRunTimeException(NotFoundExceptionHandler exceptionHandler){
        ProblemDetail problemDetail = ProblemDetail.
                forStatusAndDetail(HttpStatus.NOT_FOUND,exceptionHandler.getMessage());
        problemDetail.setTitle("Not Found");
        problemDetail.setProperty("timestamp",Instant.now());
        return problemDetail;
    }

    @ExceptionHandler
    public ProblemDetail handleRunTimeException(OperationNotAllowExceptionHandler exceptionHandler){
        ProblemDetail problemDetail = ProblemDetail.
                forStatusAndDetail(HttpStatus.CONFLICT,exceptionHandler.getMessage());
        problemDetail.setTitle("Conflict");
        problemDetail.setProperty("timestamp",Instant.now());
        return problemDetail;
    }
}
