package com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.EventRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Attendee;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Venue;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {
    private Integer eventId;
    private String eventName;
    private LocalDate eventDate;
    private Venue venue;
    private List<Attendee> attendees;
}
