package com.kshrd._2_chhim_pojim_pp_spring_homework003.service.implement;

import com.kshrd._2_chhim_pojim_pp_spring_homework003.repository.EventRepository;
import com.kshrd._2_chhim_pojim_pp_spring_homework003.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
}
