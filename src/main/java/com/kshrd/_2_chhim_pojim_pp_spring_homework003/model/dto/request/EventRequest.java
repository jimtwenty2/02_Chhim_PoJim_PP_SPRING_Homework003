package com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {
    private String eventName;
    private LocalDate eventDate;
    private Integer venueId;
}
