package com.Travelsapi.Travels.packages.custom.repository;

import com.Travelsapi.Travels.packages.custom.models.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary,Integer> {
}
