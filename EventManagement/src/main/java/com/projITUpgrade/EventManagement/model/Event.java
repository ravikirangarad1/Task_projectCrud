package com.projITUpgrade.EventManagement.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "events")

public class Event {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "event_name", nullable = false)
	    private String eventName;

	    @Temporal(TemporalType.DATE)
	    @Column(name = "event_date", nullable = false)
	    private Date eventDate;

	    @Column(name = "description")
	    private String description;

	    @ManyToOne
	    @JoinColumn(name = "organizer_id", nullable = false)
	    private Organizer organizer;

	    @ManyToOne
	    @JoinColumn(name = "venue_id", nullable = false)
	    private Venue venue;

	
	    public Event() {}

	    public Event(String eventName, Date eventDate, String description, Organizer organizer, Venue venue) {
	        this.eventName = eventName;
	        this.eventDate = eventDate;
	        this.description = description;
	        this.organizer = organizer;
	        this.venue = venue;
	    }

	  
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getEventName() {
	        return eventName;
	    }

	    public void setEventName(String eventName) {
	        this.eventName = eventName;
	    }

	    public Date getEventDate() {
	        return eventDate;
	    }

	    public void setEventDate(Date eventDate) {
	        this.eventDate = eventDate;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public Organizer getOrganizer() {
	        return organizer;
	    }

	    public void setOrganizer(Organizer organizer) {
	        this.organizer = organizer;
	    }

	    public Venue getVenue() {
	        return venue;
	    }

	    public void setVenue(Venue venue) {
	        this.venue = venue;
	    }

}
