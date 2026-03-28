package com.kshrd._2_chhim_pojim_pp_spring_homework003.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(NotFoundExceptionHandler.class)
    public ProblemDetail handleRunTimeException(NotFoundExceptionHandler exceptionHandler){
        ProblemDetail problemDetail = ProblemDetail.
                forStatusAndDetail(HttpStatus.NOT_FOUND,exceptionHandler.getMessage());
        problemDetail.setTitle("Not Found");
        problemDetail.setProperty("timestamp",Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(OperationNotAllowExceptionHandler.class)
    public ProblemDetail handleRunTimeException(OperationNotAllowExceptionHandler exceptionHandler){
        ProblemDetail problemDetail = ProblemDetail.
                forStatusAndDetail(HttpStatus.CONFLICT,exceptionHandler.getMessage());
        problemDetail.setTitle("Conflict");
        problemDetail.setProperty("timestamp",Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleRunTimeException(MethodArgumentNotValidException exceptions){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Bad Request");
        Map<String, Object> errors = new HashMap<>();
        for(FieldError error : exceptions.getBindingResult().getFieldErrors()){
            errors.put(error.getField(), error.getDefaultMessage());
        }
        problemDetail.setProperty("errors",errors);
        return problemDetail;
    }
}
