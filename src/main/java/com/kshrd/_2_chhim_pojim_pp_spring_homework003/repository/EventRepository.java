package com.kshrd._2_chhim_pojim_pp_spring_homework003.repository;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.EventRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Event;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EventRepository {
    @Results(id = "eventMapper", value = {
            @Result(property = "eventId",column = "event_id"),
            @Result(property = "eventName",column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id",
                one = @One(select = "com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.VenueRepository.findVenueById")
            ),
            @Result(property = "attendees", column = "event_id",
                many = @Many(select = "com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.AttendeeRepository.getAllAttendeesByEventId")
            )
    })
    @Select("""
        SELECT * FROM events 
        LIMIT #{size}
        OFFSET (#{page}-1) * #{size};
    """)
    List<Event> findAllEvents(Integer page, Integer size);

    @Select("""
        SELECT COUNT(*) > 0 FROM events WHERE venue_id = #{venueId};
    """)
    boolean existsByVenueId(Integer venueId);

    @Select("""
        SELECT * FROM events WHERE event_id = #{eventId};
    """)
    @ResultMap("eventMapper")
    Event findEventById(Integer eventId);

    @Select("""
        SELECT COUNT(*) > 0 FROM events WHERE event_name = #{eventName}
                                          AND event_date = #{eventDate};
    """)
    boolean isEventExistsByNameAndDate(String eventName, LocalDate eventDate);

    @Select("""
        INSERT INTO events (event_name, event_date, venue_id)
        VALUES (#{req.eventName}, #{req.eventDate}, #{req.venueId})
        RETURNING *;
    """)
    @ResultMap("eventMapper")
    Event saveEvent(@Param("req") EventRequest eventRequest);

    @Select("SELECT COUNT(*) > 0 FROM events WHERE event_id = #{eventId};")
    boolean isEventExistsById(Integer eventId);

    @Select("""
        UPDATE events SET event_name = #{req.eventName} , 
                          event_date = #{req.eventDate},
                          venue_id = #{req.venueId}
                      WHERE event_id = #{eventId}
        RETURNING *;
    """)
    @ResultMap("eventMapper")
    Event updateEventById(Integer eventId,@Param("req") EventRequest eventRequest);

    @Select("""
            SELECT COUNT(*) > 0
            FROM events
            WHERE event_name = #{eventName}
              AND event_date = #{eventDate}
              AND event_id != #{eventId};
    """)
    boolean isEventExistsByNameDateAndIdNot(String eventName, LocalDate eventDate, Integer eventId);

    @Delete("DELETE FROM events WHERE event_id = #{eventId}")
    void deleteEventById(Integer eventId);
}
