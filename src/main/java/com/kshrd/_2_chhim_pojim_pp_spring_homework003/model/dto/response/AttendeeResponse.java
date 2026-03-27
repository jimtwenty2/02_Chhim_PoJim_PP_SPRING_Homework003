package com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendeeResponse {
     private Integer attendeeId;
     private String attendeeName;
     private String email;
}
