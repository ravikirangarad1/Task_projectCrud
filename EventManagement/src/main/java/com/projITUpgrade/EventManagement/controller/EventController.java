package com.projITUpgrade.EventManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projITUpgrade.EventManagement.model.Event;
import com.projITUpgrade.EventManagement.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
	
	  @Autowired
	    private EventService eventService;

	    @PostMapping
	    public Event createEvent(@RequestBody Event event) {
	        return eventService.createEvent(event);
	    }

	    @GetMapping
	    public List<Event> getAllEvents() {
	        return eventService.getAllEvents();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
	        return eventService.getEventById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
	        return eventService.updateEvent(id, event);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
	        eventService.deleteEvent(id);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/venue/{venueId}")
	    public List<Event> getEventsByVenue(@PathVariable Long venueId) {
	        return eventService.getEventsByVenue(venueId);
	    }

	    @GetMapping("/organizer/{organizerId}")
	    public List<Event> getEventsByOrganizer(@PathVariable Long organizerId) {
	        return eventService.getEventsByOrganizer(organizerId);
	    }
}
