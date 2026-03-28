package com.kshrd._2_chhim_pojim_pp_spring_homework003.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EventRepository {
    @Select("""
        SELECT COUNT(*) > 0 FROM events WHERE venue_id = #{venueId};
    """)
    boolean existsByVenueId(Integer venueId);
}
