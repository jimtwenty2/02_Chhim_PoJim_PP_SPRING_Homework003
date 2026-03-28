package com.kshrd._2_chhim_pojim_pp_spring_homework003.service.implement;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.exception.InputParametersNotAllowedExceptionHandler;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.exception.NotFoundExceptionHandler;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.exception.OperationNotAllowExceptionHandler;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.mapper.EventMapper;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.request.EventRequest;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.dto.response.EventResponse;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Event;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.model.entity.Venue;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.AttendeeRepository;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.EventAttendeeRepository;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.EventRepository;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.VenueRepository;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.EventService;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.SharedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final SharedService sharedService;
    private final AttendeeRepository attendeeRepository;
    private final VenueRepository venueRepository;
    private final EventAttendeeRepository eventAttendeeRepository;

    private void validate(Map<String, Integer> params) {
        Map<String, String> errors = sharedService.validateInputParameters(params);
        if (!errors.isEmpty()) {
            throw new InputParametersNotAllowedExceptionHandler(errors);
        }
    }

    @Override
    public List<EventResponse> getAllEvents(Integer page, Integer size) {
        validate(Map.of("page", page, "size", size));
        List<Event> events = eventRepository.findAllEvents(page,size);
        return eventMapper.mapToEventListResponse(events);
    }

    @Override
    public EventResponse getEventById(Integer eventId) {
        validate(Map.of("eventId",eventId));
        Event event = eventRepository.findEventById(eventId);
        if(event == null) throw new NotFoundExceptionHandler("Event with id " + eventId + " not found");
        return eventMapper.mapToEventResponse(event);
    }

    @Override
    public EventResponse createEvent(EventRequest eventRequest) {
        if(eventRepository.isEventExistsByNameAndDate(eventRequest.getEventName(),eventRequest.getEventDate()))
            throw new OperationNotAllowExceptionHandler("Event name already exists on this date");
        if(!venueRepository.isVenueExistById(eventRequest.getVenueId())){
            throw new NotFoundExceptionHandler("Venue with ID " + eventRequest.getVenueId() + " not found");
        }
        Set<Integer> attendeesId = eventRequest.getAttendees();
        for(Integer attendeeId : attendeesId){
            if(!attendeeRepository.isAttendeeExist(attendeeId))
                throw new NotFoundExceptionHandler("Attendee ID with " + attendeeId + " not found");
        }
        Event event = eventRepository.saveEvent(eventRequest);
        for(Integer attendeeId : attendeesId){
            eventAttendeeRepository.saveEventAttendee(attendeeId,event.getEventId());
        }
        Event createdEvent = eventRepository.findEventById(event.getEventId());
        return eventMapper.mapToEventResponse(createdEvent);
    }

    @Override
    public EventResponse updateEventById(Integer eventId, EventRequest eventRequest) {
        validate(Map.of("eventId", eventId));
        if (!eventRepository.isEventExistsById(eventId)) {
            throw new NotFoundExceptionHandler("Event with id " + eventId + " not found");
        }
        if (eventRepository.isEventExistsByNameDateAndIdNot(
                eventRequest.getEventName(),
                eventRequest.getEventDate(),
                eventId)) {
            throw new OperationNotAllowExceptionHandler("Event name already exists with the given date");
        }
        if(!venueRepository.isVenueExistById(eventRequest.getVenueId())){
            throw new NotFoundExceptionHandler("Venue ID with " + eventRequest.getVenueId() + " not found");
        }
        for(Integer attendeeId : eventRequest.getAttendees()){
            if(!attendeeRepository.isAttendeeExist(attendeeId))
                throw new NotFoundExceptionHandler("Attendee ID with " + attendeeId + " not found");
        }
        Event event = eventRepository.updateEventById(eventId, eventRequest);
        eventAttendeeRepository.deleteEventAttendeeByEventId(eventId);
        for (Integer attendeeId : eventRequest.getAttendees()) {
            eventAttendeeRepository.saveEventAttendee(attendeeId, eventId);
        }
        Event findUpdatedEvent = eventRepository.findEventById(event.getEventId());
        return eventMapper.mapToEventResponse(findUpdatedEvent);
    }

    @Override
    public void deleteEventById(Integer eventId) {
        validate(Map.of("eventId",eventId));
        if(!eventRepository.isEventExistsById(eventId)) throw new NotFoundExceptionHandler("Event with id " + eventId + " not found");
        eventRepository.deleteEventById(eventId);
    }
}
