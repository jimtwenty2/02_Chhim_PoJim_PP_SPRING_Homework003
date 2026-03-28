package com.kshrd._2_chhim_pojim_pp_spring_homework003.controller;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.exception.InputParametersNotAllowedExceptionHandler;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.EventRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.ApiResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.ApiVoidResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.EventResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.VenueResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.EventService;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.SharedService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<EventResponse>>> getAllEvents(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size){
        List<EventResponse> eventResponses = eventService.getAllEvents(page,size);
        ApiResponse<List<EventResponse>> eventResponseApiResponse = ApiResponse
                .<List<EventResponse>>builder()
                .status(HttpStatus.OK.value())
                .message("Retrieved events successfully")
                .payload(eventResponses)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(eventResponseApiResponse);
    }

    @GetMapping("/{event-id}")
    public ResponseEntity<ApiResponse<EventResponse>> getEventById(@PathVariable("event-id") Integer eventId){
        EventResponse eventResponse = eventService.getEventById(eventId);
        ApiResponse<EventResponse> eventResponseApiResponse =
                ApiResponse
                        .<EventResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("Retrieved event with id " + eventId + " successfully")
                        .payload(eventResponse)
                        .timestamp(Instant.now())
                        .build();
        return ResponseEntity.status(HttpStatus.OK).body(eventResponseApiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EventResponse>> createEvent(@RequestBody @Valid EventRequest eventRequest){
        EventResponse eventResponse = eventService.createEvent(eventRequest);
        ApiResponse<EventResponse> eventResponseApiResponse = ApiResponse.<EventResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Create event successfully")
                .payload(eventResponse)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(eventResponseApiResponse);
    }

    @PutMapping("/{event-id}")
    public ResponseEntity<ApiResponse<EventResponse>> updateEventById(
            @PathVariable("event-id") Integer eventId,
            @RequestBody @Valid EventRequest eventRequest
    ){
        EventResponse eventResponse = eventService.updateEventById(eventId,eventRequest);
        ApiResponse<EventResponse> eventResponseApiResponse = ApiResponse.<EventResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Updated event with id " + eventId + " successfully")
                .payload(eventResponse)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(eventResponseApiResponse);
    }

    @DeleteMapping("/{event-id}")
    public ResponseEntity<ApiVoidResponse> deleteEventById(@PathVariable("event-id") Integer eventId){
        eventService.deleteEventById(eventId);
        ApiVoidResponse eventApiVoidResponse = ApiVoidResponse.builder()
                .status(HttpStatus.NO_CONTENT.value())
                .message("Event with id " + eventId + " deleted successfully")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(eventApiVoidResponse);
    }

}
