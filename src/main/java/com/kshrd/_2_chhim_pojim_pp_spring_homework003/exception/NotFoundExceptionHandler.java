package com.kshrd._2_chhim_pojim_pp_spring_homework003.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundExceptionHandler extends RuntimeException {
    private String message;
}
