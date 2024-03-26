package com.Travelsapi.Travels.Countries.Service;

import com.Travelsapi.Travels.Countries.Repositories.Repository;
import com.Travelsapi.Travels.Countries.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.util.Map;
import java.util.Objects;

@Service
public class CountryService {

    @Autowired
    private Repository repository;

    public Country saveDetails(Country country){

        return repository.save(country);

    }

    public Country getCountryDetailsByName(String name){

        return  repository.findByName(name);
    }



    public Country updateDetails(Country country){

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




}
