package com.kshrd._2_chhim_pojim_pp_spring_homework003.controller;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.VenueRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.ApiResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.ApiVoidResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.VenueResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.VenueRepository;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.VenueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class VenueController {
    private final VenueService venueService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<VenueResponse>>> getAllVenues(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size){
        List<VenueResponse> venueResponses = venueService.getAllVenues(page,size);
        ApiResponse<List<VenueResponse>> venueResponsesApiResponse =
                ApiResponse.<List<VenueResponse>>builder()
                        .status(HttpStatus.OK.value())
                        .message("Retrieved venues successfully.")
                        .payload(venueResponses)
                        .timestamp(Instant.now())
                        .build();
        return ResponseEntity.status(HttpStatus.OK).body(venueResponsesApiResponse);
    }

    @GetMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<VenueResponse>> getVenueById(@PathVariable("venue-id") Integer venueId){
        VenueResponse venueResponse = venueService.getVenueById(venueId);
        ApiResponse<VenueResponse> venueResponseApiResponse =
                ApiResponse
                        .<VenueResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("Retrieved venue with id " + venueId + " successfully")
                        .payload(venueResponse)
                        .timestamp(Instant.now())
                        .build();
        return ResponseEntity.status(HttpStatus.OK).body(venueResponseApiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VenueResponse>> createVenue(@RequestBody @Valid  VenueRequest venueRequest){
        VenueResponse venueResponse = venueService.createVenue(venueRequest);
        ApiResponse<VenueResponse> venueResponseApiResponse = ApiResponse.<VenueResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Create venue successfully")
                .payload(venueResponse)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(venueResponseApiResponse);
    }

    @PutMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<VenueResponse>> updateVenueId(
            @PathVariable("venue-id") Integer venueId, @RequestBody @Valid VenueRequest venueRequest){
        VenueResponse venueResponse = venueService.updateVenueById(venueId,venueRequest);
        ApiResponse<VenueResponse> venueResponseApiResponse = ApiResponse.<VenueResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Updated venue with id " + venueId + " successfully")
                .payload(venueResponse)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(venueResponseApiResponse);
    }

    @DeleteMapping("/{venue-id}")
    public ResponseEntity<ApiVoidResponse> deleteVenueById(@PathVariable("venue-id") Integer venueId){
        venueService.deleteVenueById(venueId);
        ApiVoidResponse venueApiVoidResponse = ApiVoidResponse.builder()
                .status(HttpStatus.NO_CONTENT.value())
                .message("Venue with id " + venueId + " deleted successfully")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(venueApiVoidResponse);
    }
}
