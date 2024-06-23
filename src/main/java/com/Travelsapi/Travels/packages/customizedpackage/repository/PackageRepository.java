package com.Travelsapi.Travels.packages.customizedpackage.repository;

import com.Travelsapi.Travels.packages.customizedpackage.models.ReviewAndFaq;
import com.Travelsapi.Travels.packages.customizedpackage.models.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<TourPackage, Integer> {

}
