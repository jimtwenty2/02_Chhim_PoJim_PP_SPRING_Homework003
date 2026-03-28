package com.kshrd._2_chhim_pojim_pp_spring_homework003.service.implement;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.exception.NotFoundExceptionHandler;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.exception.OperationNotAllowExceptionHandler;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.exception.PaginationNotAllowedExceptionHandler;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.mapper.VenueMapper;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.VenueRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.VenueResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Venue;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.EventRepository;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.VenueRepository;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.SharedService;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class VenueServiceImpl implements VenueService {
    private final VenueRepository venueRepository;
    private final EventRepository eventRepository;
    private final VenueMapper venueMapper;
    private final SharedService sharedService;

    @Override
    public List<VenueResponse> getAllVenues(Integer page, Integer size) {
        Map<String, String> errors = sharedService.validatePageAndSize(page,size);
        if (!errors.isEmpty()) {
            throw new PaginationNotAllowedExceptionHandler(errors);
        }
        List<Venue> venues = venueRepository.findAllVenues(page, size);
        return venueMapper.mapToListVenueResponse(venues);
    }

    @Override
    public VenueResponse getVenueById(Integer venueId) {
        Venue venue = venueRepository.findVenueById(venueId);
        if(venue == null) throw new NotFoundExceptionHandler("Venue with id " + venueId + " not found");
        return venueMapper.mapToVenueResponse(venue);
    }

    @Override
    public void deleteVenueById(Integer venueId) {
        if(!venueRepository.isVenueExist(venueId)) throw new NotFoundExceptionHandler("Venue with id " + venueId + " not found");

        boolean hasEvents = eventRepository.existsByVenueId(venueId);
        if(hasEvents) throw new OperationNotAllowExceptionHandler("Some events still use this venue. Update or delete those events first.");

        venueRepository.deleteVenueById(venueId);
    }

    @Override
    public VenueResponse updateVenueById(Integer venueId, VenueRequest venueRequest) {
        if(!venueRepository.isVenueExist(venueId)) throw new NotFoundExceptionHandler("Venue with id " + venueId + " not found");
        Venue venue = venueRepository.updateVenueById(venueId, venueRequest);
        return venueMapper.mapToVenueResponse(venue);
    }

    @Override
    public VenueResponse createVenue(VenueRequest venueRequest) {
        Venue venue = venueRepository.saveVenue(venueRequest);
        return venueMapper.mapToVenueResponse(venue);
    }
}

