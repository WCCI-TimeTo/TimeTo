package com.TimeTo.TimeTo.Controllers;

import com.TimeTo.TimeTo.Models.Account;
import com.TimeTo.TimeTo.Models.Event;
import com.TimeTo.TimeTo.Repositories.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Optional;

@RestController
public class EventController {
    private EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events/")
    public Collection<Event> retrieveEvents() {
        return (Collection<Event>) eventRepository.findAll();
    }

    @GetMapping("/events/{id}/")
    public Optional<Event> retrieveEventById(@PathVariable String id) {
        return eventRepository.findById(id);
    }

    @DeleteMapping("/events/{id}/")
    public void deleteEvent(@PathVariable String id) {
        Event e = eventRepository.findById(id).get();
        Event newFreeTime = new Event(e.getCreator(), e.getId(), e.getDay(), true, e.getStartTime(), e.getEndTime(), "Free Time!");
        eventRepository.deleteById(id);
        eventRepository.save(newFreeTime);
    }

    @PostMapping("/events/")
    public Event createEvent(@RequestBody Event eventToAdd) {
        LocalTime timeOfEvent = eventToAdd.getStartTime();
        Event retrievedEvent = eventRepository.findByStartTime(timeOfEvent).get();
        eventRepository.delete(retrievedEvent);
        return eventRepository.save(eventToAdd);
    }
}
