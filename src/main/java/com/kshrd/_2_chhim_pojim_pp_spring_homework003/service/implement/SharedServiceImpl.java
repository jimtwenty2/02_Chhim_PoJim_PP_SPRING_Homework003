package com.kshrd._2_chhim_pojim_pp_spring_homework003.service.implement;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.SharedService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SharedServiceImpl implements SharedService {

    @Override
    public Map<String, String> validateInputParameters(Map<String, Integer> parameters) {
        Map<String, String> errors = new HashMap<>();
        for(Map.Entry<String, Integer> entry : parameters.entrySet()){
            String parameter = entry.getKey();
            Integer value = entry.getValue();
            if(value <= 0 )
                errors.put(parameter, "must be greater than 0");
        }
        return errors;
    }
}
