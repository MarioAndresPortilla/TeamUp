package teamup.p2backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teamup.p2backend.model.Event;
import teamup.p2backend.service.EventService;

import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {

    EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    List<Event> getEvents(){
        return eventService.findAllEvents();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("name/{name}")
    public Event getEventByName(@PathVariable String name){return eventService.findEventByName(name);}

    //works
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("sport/{sport}")
    public Event getEventBySport(@PathVariable String sport){return eventService.findEventBySport(sport);}

    //works
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("place/{place}")
    public Event getEventByPlace(@PathVariable String place){return eventService.findEventByPlace(place);}

    //works
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("level/{level}")
    public Event getEventByLevel(@PathVariable String level){return eventService.findEventByLevel(level);}

    //get event by username -- in progress
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("username/{username}")
    public Event getEventByUser(@PathVariable String username){return eventService.findEventByUser(username);}

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public Event postEvent(@RequestBody Event event){return eventService.saveEvent(event);}

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping
    public void deleteEvent(@RequestParam String name){
        eventService.deleteEvent(name);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PatchMapping
    public void updateEvent(@RequestBody Event event){eventService.updateEvent(event);}

}