package com.Travelsapi.Travels.packages.custom.service;

import com.Travelsapi.Travels.locations.destinations.Service.DestinationService;
import com.Travelsapi.Travels.packages.custom.models.Itinerary;
import com.Travelsapi.Travels.packages.custom.repository.ItineraryRepository;
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

    public Itinerary updateItineraryDestinations(int id, List<String> destinationNames) {
        Itinerary itinerary = itineraryRepository.findById(id).orElse(null);
        if (itinerary != null) {
            itinerary.setDestination_name(destinationNames);
            itineraryRepository.save(itinerary);
        }
        return itinerary;
    }
}
