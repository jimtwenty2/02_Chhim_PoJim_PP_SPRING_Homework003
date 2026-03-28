package com.kshrd._2_chhim_pojim_pp_spring_homework003.repository;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.AttendeeRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Attendee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeeRepository {

    @Results(id = "attendeeMapper", value = {
       @Result(property = "attendeeId", column = "attendee_id"),
       @Result(property = "attendeeName", column = "attendee_name")
    })
    @Select("""
        SELECT * FROM attendees
        LIMIT #{size}
        OFFSET (#{page} - 1) * #{size};   
    """)
    List<Attendee> findAllAttendees(Integer page, Integer size);

    @Select("""
        SELECT * FROM attendees
        WHERE attendee_id = #{attendeeId};   
    """)
    @ResultMap("attendeeMapper")
    Attendee findAttendeeById(Integer attendeeId);

    @Select("""
        INSERT INTO attendees (attendee_name, email) 
        VALUES (#{attendeeName} , #{email}) RETURNING *;
    """)
    @ResultMap("attendeeMapper")
    Attendee saveAttendee(AttendeeRequest attendeeRequest);

    @Select("""
        SELECT COUNT(*) > 0 FROM attendees 
        WHERE attendee_id = #{attendeeId};
    """)
    boolean isAttendeeExist(Integer attendeeId);

    @Select("""
        UPDATE attendees SET attendee_name = #{req.attendeeName} ,
                             email = #{req.email} WHERE attendees.attendee_id = #{attendeeId}
                            RETURNING *;
    """)
    @ResultMap("attendeeMapper")
    Attendee updateVenueById(Integer attendeeId,@Param("req") AttendeeRequest attendeeRequest);

    @Delete("DELETE FROM attendees WHERE attendee_id = #{attendeeId}")
    void deleteAttendeeById(Integer attendeeId);

    @Select("""
        SELECT COUNT(*) > 0 FROM attendees 
        WHERE attendee_name = #{attendeeName};
    """)
    boolean isAttendeeExistByName(String attendeeName);

    @Select("""
        SELECT COUNT(*) > 0 FROM attendees 
        WHERE email = #{email};
    """)
    boolean isAttendeeExistByEmail(String email);

    @Select("""
        SELECT COUNT(*) > 0 FROM attendees 
        WHERE attendee_name = #{attendeeName} AND attendee_id != #{attendeeId};
    """)
    boolean isAttendeeExistByNameNotCurId(String attendeeName, Integer attendeeId);

    @Select("""
        SELECT COUNT(*) > 0 FROM attendees 
        WHERE email = #{email} AND attendee_id != #{attendeeId};
    """)
    boolean isAttendeeExistByEmailNotCurId(String email, Integer attendeeId);

    @Select("""
        SELECT * FROM attendees a INNER JOIN event_attendee ea ON
        a.attendee_id = ea.attendee_id WHERE event_id = #{eventId};
    """)
    @ResultMap("attendeeMapper")
    List<Attendee> getAllAttendeesByEventId(Integer eventId);

}
