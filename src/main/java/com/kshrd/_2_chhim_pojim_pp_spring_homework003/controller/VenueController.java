package com.kshrd._2_chhim_pojim_pp_spring_homework003.controller;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.mapper.VenueMapper;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.ApiResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.VenueResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Venue;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class VenueController {
    private final VenueService venueService;
    private final VenueMapper venueMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<List<VenueResponse>>> getAllVenues(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size){
        List<Venue> venues = venueService.getAllVenues(page,size);
        List<VenueResponse> venueResponses = venueMapper.mapToListVenueResponse(venues);
        ApiResponse<List<VenueResponse>> apiResponse =
                ApiResponse.<List<VenueResponse>>builder()
                        .status(HttpStatus.OK.value())
                        .success(true)
                        .message("Get all venues successfully.")
                        .payload(venueResponses)
                        .timestamp(Instant.now())
                        .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
