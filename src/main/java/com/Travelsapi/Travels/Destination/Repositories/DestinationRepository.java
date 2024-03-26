package com.Travelsapi.Travels.Destination.Repositories;

import com.Travelsapi.Travels.Destination.models.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination,Integer> {

        Destination findByName(String name);
}
