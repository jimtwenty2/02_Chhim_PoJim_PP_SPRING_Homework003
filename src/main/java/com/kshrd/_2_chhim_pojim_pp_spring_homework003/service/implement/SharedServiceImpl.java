package com.kshrd._2_chhim_pojim_pp_spring_homework003.service.implement;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.exception.PaginationNotAllowedExceptionHandler;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.SharedService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SharedServiceImpl implements SharedService {
    @Override
    public Map<String, String> validatePageAndSize(Integer page, Integer size) {
        Map<String, String> errors = new HashMap<>();
        if (page == null || page <= 0) {
            errors.put("page", "must be greater than 0");
        }
        if (size == null || size <= 0) {
            errors.put("size", "must be greater than 0");
        }
        if(size > 50){
            errors.put("size", "cannot request 50 row per page");
        }
        return errors;
    }
}
