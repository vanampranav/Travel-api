package com.Travelsapi.Travels.locations.countries.Repositories;

import com.Travelsapi.Travels.locations.countries.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Country,Integer> {

    Country findByName(String name);
}
