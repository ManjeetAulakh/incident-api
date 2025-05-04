package com.humanchain.incident_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanchain.incident_api.model.Incident;
import com.humanchain.incident_api.repository.IncidentRepository;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

     public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Optional<Incident> getIncidentById(Long id) {
        return incidentRepository.findById(id);
    }

    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public boolean deleteIncident(Long id) {
        if (incidentRepository.existsById(id)) {
            incidentRepository.deleteById(id);
            return true; 
        }
        return false; 
    }
    

    public Incident updateIncident(Long id, Incident updatedIncident) {
        Optional<Incident> optionalIncident = incidentRepository.findById(id);

        if (optionalIncident.isPresent()) {
            Incident existing = optionalIncident.get();
            existing.setTitle(updatedIncident.getTitle());
            existing.setDescription(updatedIncident.getDescription());
            existing.setSeverity(updatedIncident.getSeverity());
            return incidentRepository.save(existing);
        }

        return null;
    }
}
