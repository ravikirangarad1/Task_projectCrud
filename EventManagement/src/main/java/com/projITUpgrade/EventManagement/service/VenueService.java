package com.projITUpgrade.EventManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projITUpgrade.EventManagement.model.Venue;
import com.projITUpgrade.EventManagement.repository.VenueRepository;

@Service
public class VenueService {
	
	 @Autowired
	    private VenueRepository venueRepository;

	    public Venue createVenue(Venue venue) {
	        return venueRepository.save(venue);
	    }

	    public Optional<Venue> getVenueById(Long id) {
	        return venueRepository.findById(id);
	    }

	    public Venue updateVenue(Long id, Venue venueDetails) {
	        Venue venue = venueRepository.findById(id).orElseThrow();
	        venue.setName(venueDetails.getName());
	        venue.setLocation(venueDetails.getLocation());
	        venue.setCapacity(venueDetails.getCapacity());
	        return venueRepository.save(venue);
	    }

	    public void deleteVenue(Long id) {
	        venueRepository.deleteById(id);
	    }

}
