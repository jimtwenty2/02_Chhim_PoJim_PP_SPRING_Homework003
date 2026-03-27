package com.kshrd._2_chhim_pojim_pp_spring_homework003.service.implement;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.AttendeeRepository;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;
}
