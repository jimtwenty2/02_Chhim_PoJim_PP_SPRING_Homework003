package com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendeeRequest {
    @NotNull(message = "Attendee cannot be null")
    @NotBlank(message = "Attendee name cannot be blank")
    @Schema(defaultValue = "Mann VannDa")
    private String attendeeName;
    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email is invalid")
    @Schema(defaultValue = "vannda@example.com")
    private String email;
}