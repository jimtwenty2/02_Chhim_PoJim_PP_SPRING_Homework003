package com.kshrd._2_chhim_pojim_pp_spring_homework003.mapper;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.EventResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventResponse mapToEventResponse(Event event);
    List<EventResponse> mapToEventListResponse(List<Event> events);
}