package com.kshrd._2_chhim_pojim_pp_spring_homework003.service.implement;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.exception.NotFoundExceptionHandler;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.mapper.AttendeeMapper;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.AttendeeRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.AttendeeResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Attendee;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.AttendeeRepository;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;
    private final AttendeeMapper attendeeMapper;

    @Override
    public List<AttendeeResponse> getAllAttendees(Integer page, Integer size) {
        List<Attendee> attendees = attendeeRepository.findAllAttendees(page,size);
        return attendeeMapper.mapToAttendeeListResponse(attendees);
    }

    @Override
    public AttendeeResponse getAttendeeById(Integer attendeeId) {
        Attendee attendee = attendeeRepository.findAttendeeById(attendeeId);
        if(attendee == null) throw new NotFoundExceptionHandler("Attendee with id " + attendeeId + " not found");
        return attendeeMapper.mapToAttendeeResponse(attendee);
    }

    @Override
    public AttendeeResponse createAttendee(AttendeeRequest attendeeRequest) {
        Attendee attendee = attendeeRepository.saveAttendee(attendeeRequest);
        return attendeeMapper.mapToAttendeeResponse(attendee);
    }

    @Override
    public AttendeeResponse updateAttendeeById(Integer attendeeId, AttendeeRequest attendeeRequest) {
        if(!attendeeRepository.isAttendeeExist(attendeeId)) throw new NotFoundExceptionHandler("Attendee with id " + attendeeId + " not found");
        Attendee attendee = attendeeRepository.updateVenueById(attendeeId, attendeeRequest);
        return attendeeMapper.mapToAttendeeResponse(attendee);
    }

    @Override
    public void deleteAttendeeById(Integer attendeeId) {
        if(!attendeeRepository.isAttendeeExist(attendeeId)) throw new NotFoundExceptionHandler("Attendee with id " + attendeeId + " not found");
        attendeeRepository.deleteAttendeeById(attendeeId);
    }
}
