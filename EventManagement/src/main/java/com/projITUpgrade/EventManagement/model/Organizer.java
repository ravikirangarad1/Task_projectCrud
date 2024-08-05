package com.projITUpgrade.EventManagement.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "organizers")
public class Organizer {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name", nullable = false)
	    private String name;

	    @Column(name = "contact_info")
	    private String contactInfo;

	    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
	    private List<Event> events;

	    public Organizer() {}

	    public Organizer(String name, String contactInfo) {
	        this.name = name;
	        this.contactInfo = contactInfo;
	    }

	   
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getContactInfo() {
	        return contactInfo;
	    }

	    public void setContactInfo(String contactInfo) {
	        this.contactInfo = contactInfo;
	    }

	    public List<Event> getEvents() {
	        return events;
	    }

	    public void setEvents(List<Event> events) {
	        this.events = events;
	    }

}
