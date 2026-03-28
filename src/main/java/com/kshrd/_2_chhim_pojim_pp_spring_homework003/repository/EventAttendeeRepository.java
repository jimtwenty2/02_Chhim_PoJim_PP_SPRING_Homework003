package com.kshrd._2_chhim_pojim_pp_spring_homework003.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventAttendeeRepository {
    @Insert("INSERT INTO event_attendee (attendee_id, event_id) VALUES (#{attendeeId},#{eventId}) ;")
    Integer saveEventAttendee( Integer attendeeId,Integer eventId);

    @Delete("DELETE FROM event_attendee WHERE event_id = #{eventId};")
    void deleteEventAttendeeByEventId(Integer eventId);
}
