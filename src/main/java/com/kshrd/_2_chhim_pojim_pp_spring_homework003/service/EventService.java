package com.kshrd._2_chhim_pojim_pp_spring_homework003.service;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.EventRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.EventResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Event;
import jakarta.validation.Valid;

import java.util.List;

public interface EventService {
    List<EventResponse> getAllEvents(Integer page, Integer size);

    EventResponse getEventById(Integer eventId);

    EventResponse createEvent(@Valid EventRequest eventRequest);

    EventResponse updateEventById(Integer eventId, @Valid EventRequest eventRequest);

    void deleteEventById(Integer eventId);
}
