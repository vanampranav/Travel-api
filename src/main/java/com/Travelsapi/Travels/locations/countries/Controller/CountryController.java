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

    @PostMapping("/add")
    public Country postDetails(@RequestBody Country country) {

        return countryService.saveDetails(country);
    }

    @GetMapping("/{name}")
    public Country fetchDetailsByName(@PathVariable String name){
        return countryService.getCountryDetailsByName(name);
    }



    @PatchMapping("/patchCountry")
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
}
