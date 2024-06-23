package com.Travelsapi.Travels.packages.customizedpackage.service;

import com.Travelsapi.Travels.packages.customizedpackage.models.Itinerary;
import com.Travelsapi.Travels.packages.customizedpackage.repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService {
    @Autowired
    private ItineraryRepository itineraryRepository;

    public List<Itinerary> getAllItineraries() {

        return itineraryRepository.findAll();
    }
    public Itinerary getItineraryById(int id) {

        return itineraryRepository.findById(id).orElse(null);
    }
    public Itinerary saveItinerary(Itinerary itinerary) {

        return itineraryRepository.save(itinerary);
    }
    public void deleteItinerary(int id) {

        itineraryRepository.deleteById(id);
    }

}
