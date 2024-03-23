package com.Travelsapi.Travels.Countries.Repositories;

import com.Travelsapi.Travels.Countries.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Country,Integer> {

    Country findByName(String name);
}
