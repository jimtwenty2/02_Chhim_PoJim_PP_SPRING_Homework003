package com.kshrd._2_chhim_pojim_pp_spring_homework003.repository;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Venue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VenueRepository {
    @Results(id = "venueMapper", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name")
    })
    @Select("""
        SELECT * FROM venues
        LIMIT #{size}
        OFFSET (#{page} - 1) * ${size};
    """)
    public List<Venue> findAllVenues(Integer page, Integer size);
}
