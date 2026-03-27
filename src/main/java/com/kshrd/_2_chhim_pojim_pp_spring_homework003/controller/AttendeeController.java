package com.kshrd._2_chhim_pojim_pp_spring_homework003.controller;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attendees")
@RequiredArgsConstructor
public class AttendeeController {
    private final AttendeeService attendeeService;
}
