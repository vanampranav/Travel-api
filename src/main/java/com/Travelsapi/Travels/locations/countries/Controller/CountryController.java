package com.Travelsapi.Travels.locations.countries.Controller;


import com.Travelsapi.Travels.locations.countries.Service.CountryService;
import com.Travelsapi.Travels.locations.countries.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/add")
    public Country postDetails(@RequestBody Country country) {

        return countryService.saveDetails(country);
    }

    @GetMapping("/{name}")
    public Country fetchDetailsById(@PathVariable String name){
        return countryService.getCountryDetailsByName(name);
    }



    @PatchMapping("/patchCountry")
    public Country updateCountryDetails(@RequestBody Country country) {

        return countryService.updateDetails(country);
    }


}
