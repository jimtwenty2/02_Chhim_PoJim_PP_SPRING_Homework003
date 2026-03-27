package com.kshrd._2_chhim_pojim_pp_spring_homework003.mapper;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.VenueResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Venue;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VenueMapper {
    VenueResponse mapToVenueResponse(Venue venue);
    List<VenueResponse> mapToListVenueResponse(List<Venue> venues);
}
