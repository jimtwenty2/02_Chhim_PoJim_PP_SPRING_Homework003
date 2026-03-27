package com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Integer eventId;
    private String eventName;
    private LocalDate eventDate;
    private Venue venue;
}
