package com.Travelsapi.Travels.locations.countries.Controller;


import com.Travelsapi.Travels.locations.countries.Service.CountryService;
import com.Travelsapi.Travels.locations.countries.models.Country;
import com.Travelsapi.Travels.locations.destinations.models.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/{name}")
    public Country getCountryByName(@PathVariable String name){
        return countryService.getCountryDetailsByName(name);
    }

    // Todo: Update this
    @PutMapping("/")
    public Country updateCountryDetails(@RequestBody Country country) {
        return countryService.updateDetails(country);
    }

    @PostMapping("/{id}/destinations")
    public List<Destination> addDestinations(@PathVariable int id, @RequestBody List<Destination> destinations) {
        final Country country = countryService.findById(id);
        for (Destination destination : destinations) {
            destination.setCountry(country);
        }
        country.setDestinations(destinations);
        countryService.saveDetails(country);
        return destinations;
    }

    @GetMapping("/{id}/destinations")
    public List<Destination> getDestinationsByCountry(@PathVariable int id) {
        return countryService.getDestinationsByCountryId(id);
    }
}
