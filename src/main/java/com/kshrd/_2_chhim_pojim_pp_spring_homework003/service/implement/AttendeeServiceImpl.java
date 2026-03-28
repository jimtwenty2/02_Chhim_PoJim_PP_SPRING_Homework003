package com.kshrd._2_chhim_pojim_pp_spring_homework003.service.implement;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.exception.NotFoundExceptionHandler;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.exception.InputParametersNotAllowedExceptionHandler;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.exception.OperationNotAllowExceptionHandler;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.mapper.AttendeeMapper;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.AttendeeRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.AttendeeResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Attendee;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.AttendeeRepository;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.AttendeeService;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.SharedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;
    private final AttendeeMapper attendeeMapper;
    private final SharedService sharedService;

    private void validate(Map<String, Integer> params) {
        Map<String, String> errors = sharedService.validateInputParameters(params);
        if (!errors.isEmpty()) {
            throw new InputParametersNotAllowedExceptionHandler(errors);
        }
    }

    @Override
    public List<AttendeeResponse> getAllAttendees(Integer page, Integer size) {
        validate(Map.of("page", page, "size", size));
        List<Attendee> attendees = attendeeRepository.findAllAttendees(page,size);
        return attendeeMapper.mapToAttendeeListResponse(attendees);
    }

    @Override
    public AttendeeResponse getAttendeeById(Integer attendeeId) {
        validate(Map.of("attendeeId",attendeeId));
        Attendee attendee = attendeeRepository.findAttendeeById(attendeeId);
        if(attendee == null) throw new NotFoundExceptionHandler("Attendee with id " + attendeeId + " not found");
        return attendeeMapper.mapToAttendeeResponse(attendee);
    }

    @Override
    public AttendeeResponse createAttendee(AttendeeRequest attendeeRequest) {
        if(attendeeRepository.isAttendeeExistByName(attendeeRequest.getAttendeeName()))
            throw new OperationNotAllowExceptionHandler("Attendee name is already exists");
        if(attendeeRepository.isAttendeeExistByEmail(attendeeRequest.getEmail()))
            throw new OperationNotAllowExceptionHandler("Attendee email is already exists");
        Attendee attendee = attendeeRepository.saveAttendee(attendeeRequest);
        return attendeeMapper.mapToAttendeeResponse(attendee);
    }

    @Override
    public AttendeeResponse updateAttendeeById(Integer attendeeId, AttendeeRequest attendeeRequest) {
        validate(Map.of("attendeeId",attendeeId));
        if(!attendeeRepository.isAttendeeExist(attendeeId))
            throw new NotFoundExceptionHandler("Attendee with id " + attendeeId + " not found");
        if(attendeeRepository.isAttendeeExistByNameNotCurId(attendeeRequest.getAttendeeName(),attendeeId))
            throw new OperationNotAllowExceptionHandler("Attendee name is already exists");
        if(attendeeRepository.isAttendeeExistByEmailNotCurId(attendeeRequest.getEmail(),attendeeId))
            throw new OperationNotAllowExceptionHandler("Attendee email is already exists");
        Attendee attendee = attendeeRepository.updateVenueById(attendeeId, attendeeRequest);
        return attendeeMapper.mapToAttendeeResponse(attendee);
    }

    @Override
    public void deleteAttendeeById(Integer attendeeId) {
        validate(Map.of("attendeeId",attendeeId));
        if(!attendeeRepository.isAttendeeExist(attendeeId)) throw new NotFoundExceptionHandler("Attendee with id " + attendeeId + " not found");
        attendeeRepository.deleteAttendeeById(attendeeId);
    }
}
