package com.Travelsapi.Travels.Countries.Controller;


import com.Travelsapi.Travels.Countries.Service.CountryService;
import com.Travelsapi.Travels.Countries.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/addCountry")
    public Country postDetails(@RequestBody Country country){

        return countryService.saveDetails(country);
    }

    @GetMapping("/getCountryByNAME/{name}")
    public Country fetchDetailsById(@PathVariable String name){
        return countryService.getCountryDetailsByName(name);
    }

    @PatchMapping("/updateCountry")
    public Country updateCountryDetails(@RequestBody Country country){

        return countryService.updateDetails(country);
    }


}
