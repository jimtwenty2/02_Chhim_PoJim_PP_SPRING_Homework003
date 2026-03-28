package com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiVoidResponse {
    private Integer status;
    private String message;
    private Instant timestamp;
}