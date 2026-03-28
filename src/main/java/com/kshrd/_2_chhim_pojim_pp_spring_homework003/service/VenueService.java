package com.kshrd._2_chhim_pojim_pp_spring_homework003.service;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.VenueRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.VenueResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Venue;

import java.util.List;

public interface VenueService {
    List<VenueResponse> getAllVenues(Integer page, Integer size);

    VenueResponse getVenueById(Integer venueId);

    void deleteVenueById(Integer venueId);

    VenueResponse updateVenueById(Integer venueId, VenueRequest venueRequest);

    VenueResponse createVenue(VenueRequest venueRequest);
}
