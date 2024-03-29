package com.Travelsapi.Travels.locations.destinations.Repositories;

import com.Travelsapi.Travels.locations.destinations.models.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination,Integer> {

        Destination findByName(String name);
}
