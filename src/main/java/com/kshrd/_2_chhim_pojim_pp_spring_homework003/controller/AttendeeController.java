package com.kshrd._2_chhim_pojim_pp_spring_homework003.controller;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.AttendeeRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.ApiResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.ApiVoidResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.AttendeeResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.AttendeeService;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
@RequiredArgsConstructor
public class AttendeeController {
    private final AttendeeService attendeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<AttendeeResponse>>> getAllAttendees(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size){
        List<AttendeeResponse> attendeeResponses = attendeeService.getAllAttendees(page,size);
        ApiResponse<List<AttendeeResponse>> attendeeResponsesApiResponse =
                ApiResponse.<List<AttendeeResponse>>builder()
                        .status(HttpStatus.OK.value())
                        .message("Retrieved attendees successfully.")
                        .payload(attendeeResponses)
                        .timestamp(Instant.now())
                        .build();
        return ResponseEntity.status(HttpStatus.OK).body(attendeeResponsesApiResponse);
    }

    @GetMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<AttendeeResponse>> getAttendeeById(@PathVariable("attendee-id") Integer attendeeId){
        AttendeeResponse attendeeResponse = attendeeService.getAttendeeById(attendeeId);
        ApiResponse<AttendeeResponse> attendeeResponseApiResponse =
                ApiResponse
                        .<AttendeeResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("Retrieved attendee with id " + attendeeId + " successfully")
                        .payload(attendeeResponse)
                        .timestamp(Instant.now())
                        .build();
        return ResponseEntity.status(HttpStatus.OK).body(attendeeResponseApiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AttendeeResponse>> createAttendee(@RequestBody @Valid AttendeeRequest attendeeRequest){
        AttendeeResponse attendeeResponse = attendeeService.createAttendee(attendeeRequest);
        ApiResponse<AttendeeResponse> attendeeResponseApiResponse = ApiResponse.<AttendeeResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Create attendee successfully")
                .payload(attendeeResponse)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(attendeeResponseApiResponse);
    }

    @PutMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<AttendeeResponse>> updateAttendeeId(
            @PathVariable("attendee-id") Integer attendeeId, @RequestBody @Valid AttendeeRequest attendeeRequest){
        AttendeeResponse attendeeResponse = attendeeService.updateAttendeeById(attendeeId,attendeeRequest);
        ApiResponse<AttendeeResponse> attendeeResponseApiResponse = ApiResponse.<AttendeeResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Updated attendee with id " + attendeeId + " successfully")
                .payload(attendeeResponse)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(attendeeResponseApiResponse);
    }

    @DeleteMapping("/{attendee-id}")
    public ResponseEntity<ApiVoidResponse> deleteAttendeeById(@PathVariable("attendee-id") Integer attendeeId){
        attendeeService.deleteAttendeeById(attendeeId);
        ApiVoidResponse attendeeApiVoidResponse = ApiVoidResponse.builder()
                .status(HttpStatus.NO_CONTENT.value())
                .message("Attendee with id " + attendeeId + " deleted successfully")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(attendeeApiVoidResponse);
    }
}
