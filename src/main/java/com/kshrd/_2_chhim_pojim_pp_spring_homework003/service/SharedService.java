package com.kshrd._2_chhim_pojim_pp_spring_homework003.service;

import java.util.Map;

public interface SharedService {
    Map<String,String> validatePageAndSize(Integer page, Integer size);
}
