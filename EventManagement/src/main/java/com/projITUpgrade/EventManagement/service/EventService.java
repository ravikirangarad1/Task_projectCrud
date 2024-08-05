package com.projITUpgrade.EventManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projITUpgrade.EventManagement.model.Event;
import com.projITUpgrade.EventManagement.repository.EventRepository;

@Service
public class EventService {
	 @Autowired
	    private EventRepository eventRepository;

	    public Event createEvent(Event event) {
	        return eventRepository.save(event);
	    }

	    public List<Event> getAllEvents() {
	        return eventRepository.findAll();
	    }

	    public Optional<Event> getEventById(Long id) {
	        return eventRepository.findById(id);
	    }

	    public Event updateEvent(Long id, Event eventDetails) {
	        Event event = eventRepository.findById(id).orElseThrow();
	        event.setEventName(eventDetails.getEventName());
	        event.setEventDate(eventDetails.getEventDate());
	        event.setDescription(eventDetails.getDescription());
	        return eventRepository.save(event);
	    }

	    public void deleteEvent(Long id) {
	        eventRepository.deleteById(id);
	    }

	    public List<Event> getEventsByVenue(Long venueId) {
	        return eventRepository.findByVenueId(venueId);
	    }

	    public List<Event> getEventsByOrganizer(Long organizerId) {
	        return eventRepository.findByOrganizerId(organizerId);
	    }

}
