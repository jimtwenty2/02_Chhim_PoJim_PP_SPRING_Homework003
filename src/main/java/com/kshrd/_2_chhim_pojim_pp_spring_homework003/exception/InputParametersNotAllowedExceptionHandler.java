package com.kshrd._2_chhim_pojim_pp_spring_homework003.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputParametersNotAllowedExceptionHandler extends RuntimeException{
    private Map<String, String> errors;
}
