package com.kshrd._2_chhim_pojim_pp_spring_homework003.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationNotAllowExceptionHandler extends RuntimeException{
    private String message;
}
