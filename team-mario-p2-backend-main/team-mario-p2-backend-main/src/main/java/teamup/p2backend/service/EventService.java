package teamup.p2backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import teamup.p2backend.model.Event;
import teamup.p2backend.repository.EventRepository;

import java.lang.annotation.*;
import java.util.List;

@Component
public class EventService {

    EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(String name) {
        eventRepository.deleteByName(name);
    }

    public Event findEventByName(String name) {return eventRepository.findByName(name);}

    //works
    public Event findEventBySport(String sportname) {return eventRepository.findBySport(sportname);}

    //works
    public Event findEventByPlace(String place){return eventRepository.findByPlace(place);}

    //works
    public Event findEventByLevel(String level){return eventRepository.findByLevel(level);}

    public Event findEventByUser(String username){return eventRepository.findByUser(username);}

    //update
    public void updateEvent(Event event){eventRepository.updateEvent(event.getName(), event.getPlace(),
            event.getDate(), event.getTime(), event.getLevel(), event.getSport(),
            event.getEvent_id());}

}
