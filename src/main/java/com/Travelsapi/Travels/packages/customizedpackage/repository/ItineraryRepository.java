package com.Travelsapi.Travels.packages.customizedpackage.repository;

import com.Travelsapi.Travels.packages.customizedpackage.models.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary,Integer> {
}
