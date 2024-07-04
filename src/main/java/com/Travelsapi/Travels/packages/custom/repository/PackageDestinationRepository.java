package com.Travelsapi.Travels.packages.custom.repository;

import com.Travelsapi.Travels.packages.custom.models.PackageDestination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageDestinationRepository extends JpaRepository<PackageDestination,Integer> {
}
