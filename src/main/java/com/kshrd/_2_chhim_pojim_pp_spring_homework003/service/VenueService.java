package com.kshrd._2_chhim_pojim_pp_spring_homework003.service;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Venue;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenues(Integer page, Integer size);
}
