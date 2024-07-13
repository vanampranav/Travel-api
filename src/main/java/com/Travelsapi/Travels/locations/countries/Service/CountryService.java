package com.Travelsapi.Travels.locations.countries.Service;

import com.Travelsapi.Travels.locations.countries.Repositories.Repository;
import com.Travelsapi.Travels.locations.countries.models.Country;
import com.Travelsapi.Travels.locations.destinations.models.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private Repository repository;

    public Country saveDetails(Country country){
        return repository.save(country);
    }

    public Country findById(final int id){
        Optional<Country> country = repository.findById(id);
        return country.get();
    }
    public Country getCountryDetailsByName(String name) {

        return  repository.findByName(name);
    }
    public Country updateDetails(Country country) {

        Country updateCountry=repository.findByName(country.getName());
        if(updateCountry!=null)
        {
            updateCountry.setCapital(country.getCapital());
            updateCountry.setService_accept(country.getService_accept());
            repository.save(updateCountry);

            return updateCountry;
        }
        return null;
    }

    public List<Destination> getDestinationsByCountryId(int countryId) {
        Country country = repository.findById(countryId).orElseThrow(() -> new RuntimeException("Country not found"));
        return country.getDestinations();
    }

}
