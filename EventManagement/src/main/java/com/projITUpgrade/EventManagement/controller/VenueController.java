package com.projITUpgrade.EventManagement.controller;

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

import com.projITUpgrade.EventManagement.model.Venue;
import com.projITUpgrade.EventManagement.service.VenueService;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
	
	 @Autowired
	    private VenueService venueService;

	    @PostMapping
	    public Venue createVenue(@RequestBody Venue venue) {
	        return venueService.createVenue(venue);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
	        return venueService.getVenueById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public Venue updateVenue(@PathVariable Long id, @RequestBody Venue venue) {
	        return venueService.updateVenue(id, venue);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
	        venueService.deleteVenue(id);
	        return ResponseEntity.noContent().build();
	    }

}
