package com.Travelsapi.Travels.packages.custom.controller;

import com.Travelsapi.Travels.packages.custom.models.Itinerary;
import com.Travelsapi.Travels.packages.custom.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itineraries")
public class ItineraryController {
    @Autowired
    private ItineraryService itineraryService;

    @GetMapping
    public List<Itinerary> getAllItineraries() {
        return itineraryService.getAllItineraries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Itinerary> getItineraryById(@PathVariable int id) {
        Itinerary itinerary = itineraryService.getItineraryById(id);
        if (itinerary != null) {
            return ResponseEntity.ok(itinerary);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Itinerary createItinerary(@RequestBody Itinerary itinerary) {
        return itineraryService.saveItinerary(itinerary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItinerary(@PathVariable int id) {
        itineraryService.deleteItinerary(id);
        return ResponseEntity.noContent().build();
    }
}
