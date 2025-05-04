package com.humanchain.incident_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.humanchain.incident_api.model.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

}
