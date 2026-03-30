package com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {
    @NotNull(message = "Event name cannot be null")
    @NotBlank(message = "Event name cannot be blank")
    @Schema(defaultValue = "Khmer New Year")
    private String eventName;
    @NotNull(message = "Event date cannot be null")
    @Future(message = "Event date must be in the future")
    @Schema(defaultValue = "2026-04-14")
    private LocalDate eventDate;
    @NotNull(message = "Venue ID is required")
    @Positive(message = "VenueId must be Positive number")
    @Schema(defaultValue = "1073741824")
    private Integer venueId;
    @NotEmpty(message = "Attendee is required")
    @Schema(defaultValue = "[1073741824]")
    private Set<@Positive(message = "AttendeeId must be Positive number") Integer> attendees;
}
