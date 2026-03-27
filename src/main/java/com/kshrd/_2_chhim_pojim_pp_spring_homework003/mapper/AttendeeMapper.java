package com.kshrd._2_chhim_pojim_pp_spring_homework003.mapper;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.AttendeeResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Attendee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttendeeMapper {
    AttendeeResponse mapToAttendeeResponse(Attendee attendee);
    List<AttendeeResponse> mapToAttendeeListResponse(List<Attendee> attendees);
}
