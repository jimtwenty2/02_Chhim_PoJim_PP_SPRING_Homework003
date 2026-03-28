package com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueRequest {
    @NotNull(message = "Venue name cannot be null")
    @NotBlank(message = "Venue name cannot be blank")
    private String venueName;
    @NotNull(message = "Location cannot be null")
    @NotBlank(message = "Location cannot be blank")
    private String location;
}