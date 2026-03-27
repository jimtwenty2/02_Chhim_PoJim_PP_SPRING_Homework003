package com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueResponse {
    private Integer venueId;
    private String venueName;
    private String location;
}