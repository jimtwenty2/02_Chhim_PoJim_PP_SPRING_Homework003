package com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Attendee;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Venue;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {
    @NotNull(message = "Event name cannot be null")
    @NotBlank(message = "Event name cannot be blank")
    private String eventName;
    @NotNull(message = "Event date cannot be null")
    @FutureOrPresent(message = "Event date must be in the future")
    private LocalDate eventDate;
    @NotNull(message = "Venue ID is required")
    private Integer venueId;
    @NotEmpty(message = "Attendee is required")
    private Set<Integer> attendees;
}
