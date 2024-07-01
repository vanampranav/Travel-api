package com.Travelsapi.Travels.packages.custom.repository;

import com.Travelsapi.Travels.packages.custom.models.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<TourPackage, Integer> {

}
