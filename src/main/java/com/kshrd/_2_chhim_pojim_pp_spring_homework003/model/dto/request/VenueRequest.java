package com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueRequest {
    @NotNull(message = "Venue name cannot be null")
    private String venueName;
    @NotNull(message = "Location cannot be null")
    private String location;
}