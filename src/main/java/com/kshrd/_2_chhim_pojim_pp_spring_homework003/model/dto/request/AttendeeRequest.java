package com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendeeRequest {
    @NotNull(message = "Attendee cannot be null")
    private String attendeeName;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email is invalid")
    private String email;
}