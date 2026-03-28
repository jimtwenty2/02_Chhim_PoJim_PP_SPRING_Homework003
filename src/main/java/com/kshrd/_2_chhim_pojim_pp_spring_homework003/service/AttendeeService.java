package com.kshrd._2_chhim_pojim_pp_spring_homework003.service;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.AttendeeRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.AttendeeResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface AttendeeService {
    List<AttendeeResponse> getAllAttendees(Integer page, Integer size);

    AttendeeResponse getAttendeeById(Integer attendeeId);

    AttendeeResponse createAttendee(@Valid AttendeeRequest attendeeRequest);

    AttendeeResponse updateAttendeeById(Integer attendeeId, @Valid AttendeeRequest attendeeRequest);

    void deleteAttendeeById(Integer attendeeId);
}
