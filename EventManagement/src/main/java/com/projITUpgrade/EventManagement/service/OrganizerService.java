package com.projITUpgrade.EventManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projITUpgrade.EventManagement.model.Organizer;
import com.projITUpgrade.EventManagement.repository.OrganizerRepository;

@Service
public class OrganizerService {
	
	  @Autowired
	    private OrganizerRepository organizerRepository;

	    public Organizer createOrganizer(Organizer organizer) {
	        return organizerRepository.save(organizer);
	    }

	    public Optional<Organizer> getOrganizerById(Long id) {
	        return organizerRepository.findById(id);
	    }

	    public Organizer updateOrganizer(Long id, Organizer organizerDetails) {
	        Organizer organizer = organizerRepository.findById(id).orElseThrow();
	        organizer.setName(organizerDetails.getName());
	        organizer.setContactInfo(organizerDetails.getContactInfo());
	        return organizerRepository.save(organizer);
	    }

	    public void deleteOrganizer(Long id) {
	        organizerRepository.deleteById(id);
	    }

}
