package com.kshrd._2_chhim_pojim_pp_spring_homework003.repository;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.VenueRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Venue;
import org.apache.ibatis.annotations.*;

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
    List<Venue> findAllVenues(Integer page, Integer size);

    @Select("""
        SELECT * FROM venues WHERE venue_id = #{venueId}
    """)
    @ResultMap("venueMapper")
    Venue findVenueById(Integer venueId);

    @Select("""
        SELECT COUNT(*) > 0 FROM venues WHERE venue_id = #{venueId};
    """)
    boolean isVenueExistById(Integer venueId);

    @Select("""
        DELETE FROM venues WHERE venue_id = #{venueId} RETURNING *;
    """)
    Venue deleteVenueById(Integer venueId);

    @Select("""
        UPDATE venues SET venue_name = #{req.venueName} , location = #{req.location} 
        WHERE venue_id = #{venueId}
        RETURNING *;
    """)
    @ResultMap("venueMapper")
    Venue updateVenueById(Integer venueId,@Param("req") VenueRequest venueRequest);

    @Select("""
        INSERT INTO venues (venue_name, location) VALUES 
        (#{venueName}, #{location}) RETURNING *;
    """)
    @ResultMap("venueMapper")
    Venue saveVenue(VenueRequest venueRequest);

    @Select("""
        SELECT COUNT(*) > 0 FROM venues WHERE venue_name = #{venueName};
    """)
    boolean isVenueExistByName(String venueName);

    @Select("""
        SELECT COUNT(*) > 0 FROM venues 
        WHERE venue_name = #{venueName} AND venue_id != #{venueId};
    """)
    boolean isVenueExistByNameNotCurId(String venueName, Integer venueId);
}
